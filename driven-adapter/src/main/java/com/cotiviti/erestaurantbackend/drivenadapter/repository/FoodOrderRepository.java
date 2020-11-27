package com.cotiviti.erestaurantbackend.drivenadapter.repository;

import com.cotiviti.erestaurantbackend.drivenadapter.entity.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;
import java.util.Optional;

public interface FoodOrderRepository extends JpaRepository<FoodOrder, Long> {
    @Query(
            value = "SELECT fo.`*`, b.id, b.payment_date, b.status, SUM(total) AS total from tbl_food_order fo\n" +
                    "INNER JOIN tbl_billing b\n" +
                    "ON b.id = fo.bill_id\n" +
                    "WHERE fo.table_id = :tableId\n" +
                    "AND b.status = FALSE\n" +
                    "GROUP BY fo.table_id",
            nativeQuery = true
    )
    Optional<FoodOrder> getPendingBillOf(@Param("tableId") long tableId);

    @Query(
            value = "SELECT fo.`*`, b.id, b.payment_date, b.status, SUM(total) AS total from tbl_food_order fo\n" +
                    "INNER JOIN tbl_billing b\n" +
                    "ON b.id = fo.bill_id\n" +
                    "AND b.status = FALSE\n" +
                    "GROUP BY fo.table_id",
            nativeQuery = true
    )
    List<FoodOrder> getAllPending();

    @Query(
            value = "SELECT fo.`*`, b.id, b.payment_date, b.status, SUM(total) AS total from tbl_food_order fo\n" +
                    "INNER JOIN tbl_billing b\n" +
                    "ON b.id = fo.bill_id\n" +
                    "AND b.status = FALSE\n" +
                    "AND fo.table_id = :id\n" +
                    "GROUP BY fo.table_id, fo.food_menu_id, fo.quantity",
            nativeQuery = true
    )
    List<FoodOrder> getAllPendingBy(@Param(value = "id") String id);


    @Query(
            value = "SELECT COUNT(*) from tbl_food_order fo\n" +
                    "INNER JOIN tbl_billing b\n" +
                    "ON b.id = fo.bill_id\n" +
                    "AND fo.order_date = CURDATE()\n",
            nativeQuery = true
    )
    Long countByOrderDate(Date date);

    @Query(
            value = "SELECT COUNT(*) from tbl_food_order fo\n" +
                    "INNER JOIN tbl_billing b\n" +
                    "ON b.id = fo.bill_id\n" +
                    "AND b.status = FALSE\n",
            nativeQuery = true
    )
    Long countPendingPayments();

    @Query(
            value = "SELECT SUM(total) from tbl_billing \n" +
                    "WHERE  payment_date = CURDATE()",
            nativeQuery = true
    )
    long todaysRevenue();

    @Query(
            value = "SELECT COUNT(*) AS menuCount, fo.`*` from tbl_food_order fo\n" +
                    "INNER JOIN tbl_billing b\n" +
                    "ON b.id = fo.bill_id\n" +
                    "WHERE  b.payment_date = CURDATE()\n" +
                    "GROUP BY fo.food_menu_id \n" +
                    "ORDER BY menuCount DESC\n" +
                    "LIMIT 1",
            nativeQuery = true
    )
    FoodOrder mostOrderItem();
}
