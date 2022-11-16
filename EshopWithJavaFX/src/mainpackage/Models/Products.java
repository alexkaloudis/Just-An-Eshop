/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage.Models;

import java.sql.Timestamp;
import java.sql.Date;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author Mike
 */
public class Products {
    private int id;
    private String name,description;
    private float price;
    private Timestamp dateofcreation;
    
    public Products(){};

    public Products(int id, String name, float price, String description,Timestamp dateofcreation) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.dateofcreation = dateofcreation;
        this.description = description;              
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public double getPrice() {
        return price;
    }

    public Timestamp getDateofcreation() {
        return dateofcreation;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public void setDateofcreation(Timestamp Dateofcreation) {
        this.dateofcreation = Dateofcreation;
    }
    
}
