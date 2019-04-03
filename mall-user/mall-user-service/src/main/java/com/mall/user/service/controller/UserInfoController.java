package com.mall.user.service.controller;

import com.mall.user.service.VO.ResultVO;
import com.mall.user.service.constant.CookieContant;
import com.mall.user.service.constant.RedisContant;
import com.mall.user.service.entity.UserInfo;
import com.mall.user.service.enums.ResultEnum;
import com.mall.user.service.enums.RoleEnum;
import com.mall.user.service.service.UserInfoService;
import com.mall.user.service.util.CookieUtil;
import com.mall.user.service.util.ResultVOUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

@RestController
@RequestMapping("/user")
public class UserInfoController {

        @Autowired
        UserInfoService userInfoService;

        @Autowired
        StringRedisTemplate stringRedisTemplate;
        /**
         * 买家登陆
         */
        @GetMapping("/buyer")
        public ResultVO buyLogin(@RequestParam("openid")String openid, HttpServletResponse response){
            //1 openid和数据库中的数据是否匹配
            UserInfo userInfo = userInfoService.findByOpenid(openid);
            if(userInfo==null){
                return ResultVOUtil.error(ResultEnum.LOGIN_ERROR);
            }
            //2判断角色
            if(!RoleEnum.ROLE_BUYER.getCode().equals(userInfo.getRole())){
                return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
            }
            //3 cookie里设置openid=abc
            CookieUtil.set(response, CookieContant.OPENID,userInfo.getOpenid(),CookieContant.expire);
            //返回成功
            return ResultVOUtil.success();
        }
        /**
         * 卖家登陆
         */
        @GetMapping("/seller")
        public ResultVO sellLogin(@RequestParam("openid") String openid, HttpServletRequest request,HttpServletResponse response){
            //判断redis中是否已经存在，该用户已经登陆
            Cookie cookie = CookieUtil.get(request, CookieContant.TOKEN);
            if(cookie!=null && !StringUtils.isEmpty(stringRedisTemplate.opsForValue().get(String.format(RedisContant.TOKEN_KEY,cookie.getValue())))){
                //再次请求的时候，刷新缓存，并且重新计算过期时间
                //stringRedisTemplate.opsForValue().set(String.format(RedisContant.TOKEN_KEY,cookie.getValue()),openid,CookieContant.expire, TimeUnit.SECONDS);
                //CookieUtil.set(response, CookieContant.TOKEN,cookie.getValue(),CookieContant.expire);
                return ResultVOUtil.success();
            }

            //1 openid和数据库中的数据是否匹配
            UserInfo userInfo = userInfoService.findByOpenid(openid);
            if(userInfo==null){
                return ResultVOUtil.error(ResultEnum.LOGIN_ERROR);
            }
            //2判断角色
            if(!RoleEnum.ROLE_SELLER.getCode().equals(userInfo.getRole())){
                return ResultVOUtil.error(ResultEnum.ROLE_ERROR);
            }
            //3 将卖家信息写入redis当中 ,key为UUID，value为openid，设置过期时间
            String token = UUID.randomUUID().toString();
            Integer expire = CookieContant.expire;                                                                          //单位 秒
            stringRedisTemplate.opsForValue().set(String.format(RedisContant.TOKEN_KEY,token),userInfo.getOpenid(),expire, TimeUnit.SECONDS);
            //4 cookie里设置openid=xyz
            CookieUtil.set(response, CookieContant.TOKEN,token,CookieContant.expire);
            //返回成功
            return ResultVOUtil.success();
        }

}
