package com.cydeo.lab07ormqueries.repository;



import com.cydeo.lab07ormqueries.entity.CartItem;
import com.cydeo.lab07ormqueries.enums.CartState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    //Write a derived query to get count cart items:
    Integer countAllBy();
    Integer countCartItemBy();

    //Write a derived query to get cart items for specific cart state:
    List<CartItem> findAllByCart_CartState(CartState cartState);

    //Write a native query to get cart items for specific cart state and product name:
    @Query(value="SELECT * FROM cart_item ci  " +
            "JOIN cart c ON ci.cart_id=c.id " +
            "JOIN product p ON ci.product_id=p.id " +
            "WHERE c.cart_state=?1 AND p.name=?2", nativeQuery = true)
    List<CartItem> retrieveCartItemByCartStateAndProductName(@Param("cartState") String cartState, @Param("name") String name);

    //Write a native query to get cart items for specific cart state and without discount:


    //Write a native query to get cart items for specific cart state and with specific Discount type
}