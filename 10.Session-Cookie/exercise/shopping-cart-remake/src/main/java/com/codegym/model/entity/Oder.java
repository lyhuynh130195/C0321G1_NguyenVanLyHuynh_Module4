package com.codegym.model.entity;

import javax.persistence.*;

@Entity
@Table
public class Oder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nameProduct;

    private Double priceProduct;

    private int amountProduct;

    public Oder() {
    }


    public Oder(String nameProduct, Double priceProduct, int amountProduct) {
        this.nameProduct = nameProduct;
        this.priceProduct = priceProduct;
        this.amountProduct = amountProduct;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNameProduct() {
        return nameProduct;
    }

    public void setNameProduct(String nameProduct) {
        this.nameProduct = nameProduct;
    }

    public Double getPriceProduct() {
        return priceProduct;
    }

    public void setPriceProduct(Double priceProduct) {
        this.priceProduct = priceProduct;
    }

    public int getAmountProduct() {
        return amountProduct;
    }

    public void setAmountProduct(int amountProduct) {
        this.amountProduct = amountProduct;
    }
}
