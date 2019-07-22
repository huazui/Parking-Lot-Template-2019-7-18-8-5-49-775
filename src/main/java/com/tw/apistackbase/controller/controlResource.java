package com.tw.apistackbase.controller;

;
import com.tw.apistackbase.entity.LotRepository;
import com.tw.apistackbase.entity.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;
import java.util.logging.Logger;

/**
 * Created by jxzhong on 18/08/2017.
 */
@RestController
@RequestMapping("/parkingLots")
public class controlResource {

    private final Logger log = Logger.getLogger(this.getClass().getName());
    @Autowired
     private MyControl control;
@Autowired
LotRepository lots;

//
   @PostMapping
    public @ResponseBody String increate(@RequestBody ParkingLot lot ){

       return control.increate(lot);
    }
//
   @GetMapping(params="page")
    public @ResponseBody String findPage(@RequestParam ("page") int page){
       ParkingLot lot1 = new ParkingLot("ting1",21,"xibian");
       ParkingLot lot2 = new ParkingLot("ting2",22,"xibian");
       ParkingLot lot3 = new ParkingLot("ting3",23,"xibian");
       ParkingLot lot4 = new ParkingLot("ting4",24,"xibian");
       ParkingLot lot5 = new ParkingLot("ting5",26,"xibian");
       ParkingLot lot6 = new ParkingLot("ting6",26,"xibian");
       control.increate(lot1);
       control.increate(lot2);
       control.increate(lot3);
       control.increate(lot4);
       control.increate(lot5);
       control.increate(lot6);
   return control.getPage(page);

}
//
    @GetMapping("/{id}")
    public @ResponseBody String getMessageById(@PathVariable("id") String id){
        ParkingLot lot=new ParkingLot("zhangsann",22,"xibian");
        control.increate(lot);
      ParkingLot parkingLot = control.getMessageByName(id);
      return parkingLot.getName()+" "+parkingLot.getVolumn()+" "+parkingLot.getLocation();
}
//
    @DeleteMapping("/{id}")
    public @ResponseBody String deleteLot(@PathVariable("id") String name){

        ParkingLot lot=new ParkingLot("ting1",22,"xibian");
        ParkingLot lot1=new ParkingLot("ting2",22,"xibian");
       control.increate(lot);
       control.increate(lot1);
   return  control.deteteByName(name);

}

@PutMapping("/{id}")
    public @ResponseBody String  change(@PathVariable("id") String id,@RequestParam("volumn") int volumn){
    ParkingLot lot=new ParkingLot("ting1",22,"xibian");
    control.increate(lot);
     int volumnNew= control.changeVolumn(id,volumn);
     return  "ting1 "+volumnNew;
}
}
