package com.tedu.sp01.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * <p> 订单 </p>
 *
 * @program: sc
 * @author: 许仕昊
 * @create: 2020-04-07 15:54
 **/

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Order {
    private String id;
    private User user;
    private List<Item> items;
}