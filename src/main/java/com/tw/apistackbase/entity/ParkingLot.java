package com.tw.apistackbase.entity;

import org.springframework.data.jpa.repository.JpaRepository;

import javax.persistence.*;

@Entity
@Table(name="PARKINGLOT")
public class ParkingLot{
    public ParkingLot(){}
    public ParkingLot(String name,int volume,String location){
        this.name=name;
        this.volumn=volume;
        this.location=location;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(name="name",length=(255),unique = true)
    private String name;
    @Column(name="volumn")
    private int volumn;
    @Column (name="location",length=255)
    private String location;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setName(){
        this.name=name;
    }

    public String getName() {
        return name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public int getVolumn() {
        return volumn;
    }

    public void setVolumn(int volumn) {
        this.volumn = volumn;
    }

}