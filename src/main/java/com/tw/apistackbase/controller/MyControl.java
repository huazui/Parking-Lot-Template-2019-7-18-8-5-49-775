package com.tw.apistackbase.controller;
import com.tw.apistackbase.entity.LotRepository;
import com.tw.apistackbase.entity.ParkingLot;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MyControl {
    @Autowired
    public LotRepository lotRepository;



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


}
