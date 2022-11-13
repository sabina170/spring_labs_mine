package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Order;
import com.cydeo.lab07ormqueries.enums.PaymentMethod;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;


@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {
    //Write a derived query to get top 5 orders by order by total price desc:
    List<Order> findTop5ByOrderByTotalPriceDesc();

    //Write a derived query to get all orders by customer email:
    List<Order> findAllByCustomer_Email(String email);

    //Write a derived query to get all orders by specific payment method:
    List<Order> findAllByPayment_PaymentMethod(PaymentMethod paymentMethod);

    //Write a derived query to check is there any orders by customer email:
    boolean existsByCustomer_Email(String email);

    //Write a native query to get all orders by specific product name:
    @Query(value = "SELECT * FROM orders o " +
            "JOIN cart c ON o.cart_id = c.id" +
            "JOIN cart_item ci ON ci.cart_id = c.id" +
            "JOIN product p ON ci.product_id = p.id" +
            "WHERE p.name = ?1", nativeQuery = true)
    List<Order> retrieveAllByProductName(@Param("name") String name);


    //Write a native query to get all orders by specific categoryId:
    @Query(value = "SELECT * FROM orders o " +
            "JOIN cart c ON o.cart_id = c.id" +
            "JOIN cart_item ci ON ci.cart_id = c.id" +
            "JOIN product p ON ci.product_id = p.id" +
            "JOIN category c ON p.c_id = c.id" +
            "WHERE c.id = ?1", nativeQuery = true)
    List<Order> retrieveAllByCategoryId(@Param("id") Long id);

    //Write a JPQL query to get all orders by totalPrice and paidPrice are equals:
    @Query("SELECT o FROM Order o WHERE o.paidPrice = o.totalPrice")
    List<Order> retrieveAllBetweenTotalPriceAndPaidPriceIsSame();

    //Write a JPQL query to get all orders by totalPrice and paidPrice are not equals and discount is not null

    @Query("SELECT o FROM Order o WHERE o.paidPrice <> o.totalPrice AND o.cart.discount IS NOT NULL")
    List<Order> retrieveAllBetweenTotalPriceAndPaidPriceIsNotSameAndDiscountIsNotNull();

}