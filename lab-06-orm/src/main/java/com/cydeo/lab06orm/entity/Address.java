package com.cydeo.lab06orm.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;

@Getter
@Setter
@NoArgsConstructor
@Entity
public class Address {
    @Id
    private String id;
    private String name;
    private String street;
    private String zipCode;
    @ManyToOne
    private Customer customer;

}
