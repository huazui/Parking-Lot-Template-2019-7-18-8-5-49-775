package com.tw.apistackbase.Controller;


import com.tw.apistackbase.entity.LotOrder;
import com.tw.apistackbase.entity.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Logger;

@RestController
@RequestMapping("/parkACar")
public class OrderControl {
    private final Logger log = Logger.getLogger(this.getClass().getName());
    @Autowired
    private MyControl control;

    @PostMapping
    public @ResponseBody String getOrders(@RequestBody LotOrder myOrder ){
        String orderNumber=myOrder.getOrderNumber();
        String lotName=myOrder.getLotname();
        String createTime=myOrder.getCreateTime();
        String carId=myOrder.getCarId();
        return control.parkCar(orderNumber,lotName,carId,createTime);

    }

   @GetMapping("/{id}")
    public  @ResponseBody String fetch(@PathVariable("id") String id){
       String finishTime="20190304";
       return control.fetchCar(id,finishTime);
   }
}
