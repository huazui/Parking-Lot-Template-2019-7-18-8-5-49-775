package com.tw.apistackbase.entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OrderRepository extends JpaRepository<LotOrder, Long>, JpaSpecificationExecutor<String> {
    //    public void delete(ParkingLot lot);
    public LotOrder findByCarid(String name);

    @Modifying(clearAutomatically = true)
    @Query(value="update parkinglot set volumn = :cap where name= :id",nativeQuery = true)
    public void update(@Param(value = "id") String id, @Param(value = "cap") Integer cap);

}