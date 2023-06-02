package com.vk.jodl7.TestProgrammForEasyBot.models;

import javax.persistence.*;
import javax.validation.constraints.NotEmpty;

@Entity
@Table
public class Notebook {
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
    @Column(name = "noteDiagonal")
    private int noteDiagonal;

    @NotEmpty
    @Column(name = "price")
    private int price;

    @NotEmpty
    @Column(name = "stock")
    private int stock;

    public Notebook() {

    }

    public Notebook(int id, int serial, String manufacture, int noteDiagonal, int price, int stock) {
        this.id = id;
        this.serial = serial;
        this.manufacture = manufacture;
        this.noteDiagonal = noteDiagonal;
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

    public int getNoteDiagonal() {
        return noteDiagonal;
    }

    public void setNoteDiagonal(int noteDiagonal) {
        this.noteDiagonal = noteDiagonal;
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
