package com.tedu.sp01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <p> 用户 </p>
 *
 * @program: sc
 * @author: 许仕昊
 * @create: 2020-04-07 15:53
 **/


@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {
    private Integer id;
    private String username;
    private String password;
}
