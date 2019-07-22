package com.tw.apistackbase.entity;
        import com.tw.apistackbase.entity.ParkingLot;
        import org.springframework.data.jpa.repository.JpaRepository;
        import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
        import org.springframework.data.jpa.repository.Modifying;
        import org.springframework.data.jpa.repository.Query;
        import org.springframework.data.repository.query.Param;

public interface LotRepository extends JpaRepository<ParkingLot, Long>, JpaSpecificationExecutor<String> {
//    public void delete(ParkingLot lot);
    public ParkingLot findByName(String name);

    @Modifying(clearAutomatically = true)
    @Query(value="update parkinglot set volumn = :cap where name= :id",nativeQuery = true)
    public void update(@Param(value = "id") String id, @Param(value = "cap") Integer cap);

}