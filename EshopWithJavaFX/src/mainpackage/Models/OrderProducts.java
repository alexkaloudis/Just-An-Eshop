/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage.Models;

import java.util.UUID;

/**
 *
 * @author Mike
 */
public class OrderProducts {
    private UUID ordeno;
    private int id,productid,quantity;
    private float ordevalue;

    public OrderProducts() {
    }

    
    public OrderProducts(int id,UUID ordeno,  int productid, int quantity, float ordevalue) {
        this.ordeno = ordeno;
        this.id = id;
        this.productid = productid;
        this.quantity = quantity;
        this.ordevalue = ordevalue;
    }

    public UUID getOrdeno() {
        return ordeno;
    }

    public int getId() {
        return id;
    }

    public int getProductid() {
        return productid;
    }

    public int getQuantity() {
        return quantity;
    }

    public float getOrdevalue() {
        return ordevalue;
    }

    public void setOrdeno(UUID ordeno) {
        this.ordeno = ordeno;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setProductid(int productid) {
        this.productid = productid;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public void setOrdevalue(float ordevalue) {
        this.ordevalue = ordevalue;
    }
    
    
}
