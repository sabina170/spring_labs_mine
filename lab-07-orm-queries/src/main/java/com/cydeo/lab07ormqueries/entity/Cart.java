package com.cydeo.lab07ormqueries.entity;

import com.cydeo.lab06orm.enums.CartState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Cart extends BaseEntity {

    @Enumerated(EnumType.STRING)
    private CartState cartState;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Discount discount;

}
