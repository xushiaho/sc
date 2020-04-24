package com.tedu.sp01.service;

import com.tedu.sp01.pojo.Order;

/**
 * <p> 订单接口 </p>
 *
 * @program: sc
 * @author: 许仕昊
 * @create: 2020-04-07 16:19
 **/

public interface OrderService {
    Order getOrder(String orderId);
    void addOrder(Order order);
}
