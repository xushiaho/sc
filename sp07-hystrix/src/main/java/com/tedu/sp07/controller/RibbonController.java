package com.tedu.sp07.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.tedu.sp01.pojo.Item;
import com.tedu.sp01.pojo.Order;
import com.tedu.sp01.pojo.User;
import com.tedu.sp01.utils.JsonResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

/**
 * <p>  </p>
 *
 * @program: sc
 * @author: 许仕昊
 * @create: 2020-04-24 16:33
 **/
@RestController
public class RibbonController {
    //    @Autowired
//    private RestTemplate rt;
//
//    @GetMapping("/item-service/{orderId}")
//    public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
//        //向指定微服务地址发送 get 请求，并获得该服务的返回结果
//        //{1} 占位符，用 orderId 填充
//        return rt.getForObject("http://localhost:8001/{1}", JsonResult.class, orderId);
//    }
//
//    @PostMapping("/item-service/decreaseNumber")
//    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
//        //发送 post 请求
//        return rt.postForObject("http://localhost:8001/decreaseNumber", items, JsonResult.class);
//    }
//
//    /////////////////////////////////////////
//
//    @GetMapping("/user-service/{userId}")
//    public JsonResult<User> getUser(@PathVariable Integer userId) {
//        return rt.getForObject("http://localhost:8101/{1}", JsonResult.class, userId);
//    }
//
//    @GetMapping("/user-service/{userId}/score")
//    public JsonResult addScore(
//            @PathVariable Integer userId, Integer score) {
//        return rt.getForObject("http://localhost:8101/{1}/score?score={2}", JsonResult.class, userId, score);
//    }
//
//    /////////////////////////////////////////
//
//    @GetMapping("/order-service/{orderId}")
//    public JsonResult<Order> getOrder(@PathVariable String orderId) {
//        return rt.getForObject("http://localhost:8201/{1}", JsonResult.class, orderId);
//    }
//
//    @GetMapping("/order-service")
//    public JsonResult addOrder() {
//        return rt.getForObject("http://localhost:8201/", JsonResult.class);
//    }
//@Autowired
//private RestTemplate rt;
//
//    @GetMapping("/item-service/{orderId}")
//    public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
//        //这里服务器路径用 service-id 代替，ribbon 会向服务的多台集群服务器分发请求
//        return rt.getForObject("http://item-service/{1}", JsonResult.class, orderId);
//    }
//
//    @PostMapping("/item-service/decreaseNumber")
//    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
//        return rt.postForObject("http://item-service/decreaseNumber", items, JsonResult.class);
//    }
//
//    /////////////////////////////////////////
//
//    @GetMapping("/user-service/{userId}")
//    public JsonResult<User> getUser(@PathVariable Integer userId) {
//        return rt.getForObject("http://user-service/{1}", JsonResult.class, userId);
//    }
//
//    @GetMapping("/user-service/{userId}/score")
//    public JsonResult addScore(
//            @PathVariable Integer userId, Integer score) {
//        return rt.getForObject("http://user-service/{1}/score?score={2}", JsonResult.class, userId, score);
//    }
//
//    /////////////////////////////////////////
//
//    @GetMapping("/order-service/{orderId}")
//    public JsonResult<Order> getOrder(@PathVariable String orderId) {
//        return rt.getForObject("http://order-service/{1}", JsonResult.class, orderId);
//    }
//
//    @GetMapping("/order-service")
//    public JsonResult addOrder() {
//        return rt.getForObject("http://order-service/", JsonResult.class);
//    }
    @Autowired
    private RestTemplate rt;

    @GetMapping("/item-service/{orderId}")
    @HystrixCommand(fallbackMethod = "getItemsFB") //指定降级方法的方法名
    public JsonResult<List<Item>> getItems(@PathVariable String orderId) {
        return rt.getForObject("http://item-service/{1}", JsonResult.class, orderId);
    }

    @PostMapping("/item-service/decreaseNumber")
    @HystrixCommand(fallbackMethod = "decreaseNumberFB")
    public JsonResult decreaseNumber(@RequestBody List<Item> items) {
        return rt.postForObject("http://item-service/decreaseNumber", items, JsonResult.class);
    }

    /////////////////////////////////////////

    @GetMapping("/user-service/{userId}")
    @HystrixCommand(fallbackMethod = "getUserFB")
    public JsonResult<User> getUser(@PathVariable Integer userId) {
        return rt.getForObject("http://user-service/{1}", JsonResult.class, userId);
    }

    @GetMapping("/user-service/{userId}/score")
    @HystrixCommand(fallbackMethod = "addScoreFB")
    public JsonResult addScore(@PathVariable Integer userId, Integer score) {
        return rt.getForObject("http://user-service/{1}/score?score={2}", JsonResult.class, userId, score);
    }

    /////////////////////////////////////////

    @GetMapping("/order-service/{orderId}")
    @HystrixCommand(fallbackMethod = "getOrderFB")
    public JsonResult<Order> getOrder(@PathVariable String orderId) {
        return rt.getForObject("http://order-service/{1}", JsonResult.class, orderId);
    }

    @GetMapping("/order-service")
    @HystrixCommand(fallbackMethod = "addOrderFB")
    public JsonResult addOrder() {
        return rt.getForObject("http://order-service/", JsonResult.class);
    }

    /////////////////////////////////////////

    //降级方法的参数和返回值，需要和原始方法一致，方法名任意
    public JsonResult<List<Item>> getItemsFB(String orderId) {
        return JsonResult.err("获取订单商品列表失败");
    }
    public JsonResult decreaseNumberFB(List<Item> items) {
        return JsonResult.err("更新商品库存失败");
    }
    public JsonResult<User> getUserFB(Integer userId) {
        return JsonResult.err("获取用户信息失败");
    }
    public JsonResult addScoreFB(Integer userId, Integer score) {
        return JsonResult.err("增加用户积分失败");
    }
    public JsonResult<Order> getOrderFB(String orderId) {
        return JsonResult.err("获取订单失败");
    }
    public JsonResult addOrderFB() {
        return JsonResult.err("添加订单失败");
    }

}

