package com.tedu.sp09.service;

import com.tedu.sp01.pojo.Order;
import com.tedu.sp01.utils.JsonResult;
import org.springframework.stereotype.Component;

/**
 * <p>  </p>
 *
 * @program: sc
 * @author: 许仕昊
 * @create: 2020-04-24 17:38
 **/

@Component
public class OrderFeignServiceFB implements OrderFeignService {

    @Override
    public JsonResult<Order> getOrder(String orderId) {
        return JsonResult.err("无法获取商品订单");
    }

    @Override
    public JsonResult addOrder() {
        return JsonResult.err("无法保存订单");
    }

}
