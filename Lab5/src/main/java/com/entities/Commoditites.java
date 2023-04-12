package com.entities;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name ="Commodities")
public class Commoditites {
    @Column(name = "id")
    private String id;
    @Column(name = "nameCom")
    private String nameCom;
    @Column(name = "price")
    private double price;
    @Id
    private String idUser;


}
