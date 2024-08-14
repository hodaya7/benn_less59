package com.firstProject.firstProject.controller;

import com.firstProject.firstProject.model.OrderRequest;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;

@RestController
public class FirstControllerLess60 {
    @GetMapping("/test")
    public String testController() {
        return "this working";
    }

//    @GetMapping("/order/{orderId}")
//    public String getOrderById(@PathVariable int orderId){
//        return "this working with  id: "+orderId;
//    }

    @GetMapping("/order")
    public String getOrderById1(@RequestParam int orderId) {
        return "this working with  id: " + orderId;
    }

//    @PostMapping("order/createOrder")
//    public String createOrder(@RequestBody int orderId){
//        return "you created order id: "+orderId;
//    }

    @PostMapping("order/createOrder")
    public OrderRequest createOrder(@RequestBody OrderRequest orderRequest) {
        System.out.println("you created order id: " + orderRequest.getOrderId());
        return orderRequest;
    }

    @PostMapping("order/createOrder1")
    public OrderRequest createOrder(@RequestHeader(value = "token") String token, @RequestBody OrderRequest orderRequest) throws Exception {
        if (token.equals("valid")) {
            System.out.println("you created order id: " + orderRequest.getOrderId());
            return orderRequest;
        } else {
            throw new Exception("not valid token");
        }
    }

    //cls ex
//    ArrayList<OrderRequest> orders=new ArrayList<>();
    HashMap<Integer, OrderRequest> ordersMap = new HashMap<>();

    @GetMapping("/order/{orderId}")
    public OrderRequest getOrderById(@PathVariable int orderId) throws Exception {
        return ordersMap.get(orderId);
//        for (int i = 0; i < orders.size(); i++) {
//            if(orders.get(i).getOrderId()==orderId)
//                return orders.get(i);
//        }
//       throw new Exception("order was not found");
    }

    @PostMapping("order/createOrder2")
    public OrderRequest createOrder2(@RequestBody OrderRequest orderRequest) throws Exception {
        ordersMap.put(orderRequest.getOrderId(), orderRequest);
        return orderRequest;
//        for (int i = 0; i < orders.size(); i++) {
//            if(orders.get(i).getOrderId()==orderRequest.getOrderId())
//                throw new Exception("order id already exists");
//        }
//        orders.add(orderRequest);
//        System.out.println("you created order id: "+orderRequest.getOrderId());
//        return orderRequest;

    }

    @PutMapping("order/updateOrder/{orderId}")
    public OrderRequest updateOrder(@PathVariable int orderId, @RequestBody OrderRequest orderRequest) throws Exception {
        if (ordersMap.containsKey(orderId)) {
            ordersMap.put(orderId, orderRequest);
            return orderRequest;
        }
        return null;
//        int flag=0;
//        for (int i = 0; i < orders.size(); i++) {
//            if(orders.get(i).getOrderId()==orderId) {
//                orders.get(i).setOrderName(orderRequest.getOrderName());
//                orders.get(i).setCustomerName(orderRequest.getCustomerName());
//                orders.get(i).setOrderPrice(orderRequest.getOrderPrice());
//                flag=1;
//            }
//        }
//        if(flag==0)
//            throw new Exception("order didnt found");
//        return orderRequest;
    }

    @DeleteMapping("order/deleteOrder/{orderId}")
    public String deleteOrder(@PathVariable int orderId) throws Exception {
        if (ordersMap.containsKey(orderId)) {
            ordersMap.remove(orderId);
            return "deleted order: " + orderId;
        }

        return "order not exists";
//        for (int i = 0; i < orders.size(); i++) {
//            if(orders.get(i).getOrderId()==orderId)
//            orders.remove(i);
//        }
//        throw new Exception("order didnt found");
    }
}
