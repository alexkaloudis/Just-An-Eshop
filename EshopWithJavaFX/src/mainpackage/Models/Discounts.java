/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage.Models;

import java.security.Timestamp;

/**
 *
 * @author Mike
 */
public class Discounts {
    private int id,productid;
    private float value;
    private Timestamp dateofcreation;
    private String description;

    public Discounts() {
    }

    public Discounts(int id, int productid, float value, Timestamp dateofcreation, String description) {
        this.id = id;
        this.productid = productid;
        this.value = value;
        this.dateofcreation = dateofcreation;
        this.description = description;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public void setValue(float value) {
        this.value = value;
    }

    public void setDateofcreation(Timestamp dateofcreation) {
        this.dateofcreation = dateofcreation;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getId() {
        return id;
    }

    public int getProductid() {
        return productid;
    }

    public float getValue() {
        return value;
    }

    public Timestamp getDateofcreation() {
        return dateofcreation;
    }

    public String getDescription() {
        return description;
    }
    
    
}
