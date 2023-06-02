package com.vk.jodl7.TestProgrammForEasyBot.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class PC {
    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotEmpty
    @Column(name = "serial")
    private int serial;

    @NotEmpty
    @Column(name = "manufacture")
    private String manufacture;

    @NotEmpty
    @Column(name = "formfactor")
    private String formfactor;

    @NotEmpty
    @Column(name = "price")
    private int price;

    @NotEmpty
    @Column(name = "stock")
    private int stock;

    public PC() {

    }

    public PC(int id, int serial, String manufacture, String formfactor, int price, int stock) {
        this.id = id;
        this.serial = serial;
        this.manufacture = manufacture;
        this.formfactor = formfactor;
        this.price = price;
        this.stock = stock;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getSerial() {
        return serial;
    }

    public void setSerial(int serial) {
        this.serial = serial;
    }

    public String getManufacture() {
        return manufacture;
    }

    public void setManufacture(String manufacture) {
        this.manufacture = manufacture;
    }

    public String getFormfactor() {
        return formfactor;
    }

    public void setFormfactor(String formfactor) {
        this.formfactor = formfactor;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
