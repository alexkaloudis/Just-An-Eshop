/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage.Models;

import java.util.Date;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author Mike
 */
public class Products {
    private int id;
    private String name,description;
    private float price;
    private Date dateofcreation;
    
    public Products(){};

    public Products(int id, String name, String description, float price, Date Dateofcreation) {
        this.id = id;
        this.name = name;
        this.price = price;

       // this.dateofcreation = Dateofcreation;

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

    public Date getDateofcreation() {
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

    public void setDateofcreation(Date Dateofcreation) {
        this.dateofcreation = Dateofcreation;
    }
    
}
