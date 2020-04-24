package com.tedu.sp01.service;

import com.tedu.sp01.pojo.Item;

import java.util.List;

/**
 * <p> 商品接口 </p>
 *
 * @program: sc
 * @author: 许仕昊
 * @create: 2020-04-07 16:14
 **/

public interface ItemService {
    List<Item> getItems(String orderId);
    void decreaseNumbers(List<Item> list);
}
