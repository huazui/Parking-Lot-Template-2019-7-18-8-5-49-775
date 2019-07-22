package com.tw.apistackbase.entity;


import javax.persistence.*;

@Entity
@Table(name="lotorder")
public class LotOrder {
    public LotOrder(){}
    public LotOrder(String lotName,String orderName,String carId,String createTime){
        this.carid=carId;
        this.createTime=createTime;
        this.lotname=lotName;
        this.orderNumber=orderName;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @Column(name="lotname",length=100)
    private String lotname;

    @Column(name="ordernumber",length=100)
    private String orderNumber;

    @Column(name="carid",length=100)
    private String carid;

    @Column(name="createtime",length=100)
    private String createTime;

    @Column(name="finishtime",length=100)
    private String finishTime;

    @Column(name="status")
    private boolean status;

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getFinishTime() {
        return finishTime;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public void setCarId(String carId) {
        this.carid = carId;
    }

    public String getCarId() {
        return carid;
    }

    public String getCreateTime() {
        return createTime;
    }

    public String getLotname() {
        return lotname;
    }

    public String getOrderNumber() {
        return orderNumber;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public void setFinishTime(String finishTime) {
        this.finishTime = finishTime;
    }

    public void setLotname(String lotname) {
        this.lotname = lotname;
    }

    public void setOrderNumber(String orderNumber) {
        this.orderNumber = orderNumber;
    }
}
