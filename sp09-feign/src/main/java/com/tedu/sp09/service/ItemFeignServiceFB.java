package com.tedu.sp09.service;

import com.tedu.sp01.pojo.Item;
import com.tedu.sp01.utils.JsonResult;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>  </p>
 *
 * @program: sc
 * @author: 许仕昊
 * @create: 2020-04-24 17:37
 **/

@Component
public class ItemFeignServiceFB implements ItemFeignService {

    @Override
    public JsonResult<List<Item>> getItems(String orderId) {
        return JsonResult.err("无法获取订单商品列表");
    }

    @Override
    public JsonResult decreaseNumber(List<Item> items) {
        return JsonResult.err("无法修改商品库存");
    }

}
