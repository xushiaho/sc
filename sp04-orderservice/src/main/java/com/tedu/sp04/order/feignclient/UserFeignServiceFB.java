package com.tedu.sp04.order.feignclient;

import com.tedu.sp01.pojo.User;
import com.tedu.sp01.utils.JsonResult;
import org.springframework.stereotype.Component;

/**
 * <p>  </p>
 *
 * @program: sc
 * @author: 许仕昊
 * @create: 2020-04-24 17:47
 **/

@Component
public class UserFeignServiceFB implements UserFeignService {

    @Override
    public JsonResult<User> getUser(Integer userId) {
        if(Math.random()<0.4) {
            return JsonResult.ok(new User(userId, "缓存name"+userId, "缓存pwd"+userId));
        }
        return JsonResult.err("无法获取用户信息");
    }

    @Override
    public JsonResult addScore(Integer userId, Integer score) {
        return JsonResult.err("无法增加用户积分");
    }

}