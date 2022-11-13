package com.cydeo.lab07ormqueries.entity;


import com.cydeo.lab07ormqueries.enums.DiscountType;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Discount extends BaseEntity{

    private BigDecimal discount;
    @Enumerated(EnumType.STRING)
    private DiscountType discountType;
    private String name;

    @Override
    public String toString() {
        return "Discount{" +
                "discount=" + discount +
                ", discountType=" + discountType +
                ", name='" + name + '\'' +
                '}';
    }
}
