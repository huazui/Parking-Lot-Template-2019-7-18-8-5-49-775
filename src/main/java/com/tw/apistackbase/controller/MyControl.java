package com.tw.apistackbase.Controller;
import com.tw.apistackbase.entity.LotOrder;
import com.tw.apistackbase.entity.LotRepository;
import com.tw.apistackbase.entity.OrderRepository;
import com.tw.apistackbase.entity.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MyControl {
    @Autowired
    public LotRepository lotRepository;

    @Autowired
    public OrderRepository orderRepository;


    public String increate(ParkingLot lot){
        String name=lotRepository.save(lot).getName();
        return name;
    }

    public String getPage(int page){
        int size=2;
        List<ParkingLot> lotList = lotRepository.findAll();
        String getList="";
        for(int i =size*(page-1); i<size*page; i++){
            getList += lotList.get(i).getName()+" ";
        }
        return getList;
    }

    public ParkingLot getMessageByName(String name){

        ParkingLot alot=lotRepository.findByName(name);
        return alot;
    }

    public String deteteByName(String name){
        ParkingLot lot=lotRepository.findByName(name);
        lotRepository.delete(lot);
        List<ParkingLot> lots = lotRepository.findAll();
        String result="";
        for(int i=0;i<lots.size();i++){
            result += lots.get(i).getName()+" "+lots.get(i).getVolumn()+" "+lots.get(i).getLocation()+".";

        }
        return result;
    }
    @Transactional
    public int changeVolumn(String name,int volumn){
//        return 200;
       lotRepository.update(name,volumn);
        return lotRepository.findByName(name).getVolumn();
    }

   public String parkCar(String lotName,String carId,String createTime,String oderNumber){
        orderRepository.save(new LotOrder("str1","str2","str3","str4"));
        if(orderRepository.findAll().size()<1) {
            LotOrder order1 = new LotOrder(lotName, oderNumber, carId, createTime);
            order1.setStatus(true);
            return orderRepository.save(order1).getOrderNumber();
        }
        else {
            return "no position.";
        }

   }

   public String fetchCar(String carId,String time){
       orderRepository.save(new LotOrder("ting1","001","vz009","20190101"));
        LotOrder myorder=orderRepository.findByCarid(carId);
        myorder.setStatus(false);
        myorder.setFinishTime(time);
        return myorder.getOrderNumber();

   }
}
