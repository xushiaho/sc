package com.tedu.sp09.service;

import com.tedu.sp01.pojo.Item;
import com.tedu.sp01.utils.JsonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

/**
 * <p>  </p>
 *
 * @program: sc
 * @author: 许仕昊
 * @create: 2020-04-24 17:20
 **/

//@FeignClient("item-service")
@FeignClient(name="item-service", fallback = ItemFeignServiceFB.class)
public interface ItemFeignService {
    @GetMapping("/{orderId}")
    JsonResult<List<Item>> getItems(@PathVariable String orderId);

    @PostMapping("/decreaseNumber")
    JsonResult decreaseNumber(@RequestBody List<Item> items);
}