package com.tedu.sp01.service;

import com.tedu.sp01.pojo.User;

/**
 * <p> 用户接口 </p>
 *
 * @program: sc
 * @author: 许仕昊
 * @create: 2020-04-07 16:19
 **/

public interface UserService {
    User getUser(Integer id);
    void addScore(Integer id, Integer score);
}
