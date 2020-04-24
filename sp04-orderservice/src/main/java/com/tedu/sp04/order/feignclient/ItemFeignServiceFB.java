package com.tedu.sp04.order.feignclient;

import com.tedu.sp01.pojo.Item;
import com.tedu.sp01.utils.JsonResult;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * <p>  </p>
 *
 * @program: sc
 * @author: 许仕昊
 * @create: 2020-04-24 17:47
 **/

@Component
public class ItemFeignServiceFB implements ItemFeignService {

    @Override
    public JsonResult<List<Item>> getItems(String orderId) {
        if(Math.random()<0.5) {
            return JsonResult.ok().data(

                    Arrays.asList(new Item[] {
                            new Item(1,"缓存aaa",2),
                            new Item(2,"缓存bbb",1),
                            new Item(3,"缓存ccc",3),
                            new Item(4,"缓存ddd",1),
                            new Item(5,"缓存eee",5)
                    })

            );
        }
        return JsonResult.err("无法获取订单商品列表");
    }

    @Override
    public JsonResult decreaseNumber(List<Item> items) {
        return JsonResult.err("无法修改商品库存");
    }

}