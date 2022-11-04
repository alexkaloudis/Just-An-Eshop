/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;

import java.util.Date;
import javafx.beans.value.ObservableValue;

/**
 *
 * @author Mike
 */
public class Products {
    private int id;
    private String name,description;
    private double price;
    private Date Dateofcreation;
    
    public Products(){};

    public Products(int id, String name, String description, double price, Date Dateofcreation) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.Dateofcreation = Dateofcreation;
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
        return Dateofcreation;
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

    public void setPrice(double price) {
        this.price = price;
    }

    public void setDateofcreation(Date Dateofcreation) {
        this.Dateofcreation = Dateofcreation;
    }
    
}
