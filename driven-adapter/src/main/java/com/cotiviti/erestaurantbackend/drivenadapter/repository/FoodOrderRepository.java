package com.cotiviti.erestaurantbackend.drivenadapter.repository;

import com.cotiviti.erestaurantbackend.drivenadapter.entity.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
    @Query(
            value = "SELECT * FROM tbl_food_order fo\n" +
                    "INNER JOIN tbl_billing b\n" +
                    "ON b.id = fo.bill_id\n" +
                    "WHERE fo.table_id = :tableId\n" +
                    "AND b.status = 0",
            nativeQuery = true
    )
    List<FoodOrder> getPendingBillOf(@Param("tableId") long tableId);
}
