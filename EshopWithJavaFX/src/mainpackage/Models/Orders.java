/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage.Models;

import java.sql.Timestamp;
import java.util.UUID;

/**
 *
 * @author Mike
 */
public class Orders {
    private UUID ordeno;
    private Timestamp orderdate;
    private String fname,lname,comments;

    public Orders() {
    }

    public Orders(UUID ordeno, Timestamp orderdate, String fname, String lname, String comments) {
        this.ordeno = ordeno;
        this.orderdate = orderdate;
        this.fname = fname;
        this.lname = lname;
        this.comments = comments;
    }

    public UUID getOrdeno() {
        return ordeno;
    }

    public Timestamp getOrderdate() {
        return orderdate;
    }

    public String getFname() {
        return fname;
    }

    public String getLname() {
        return lname;
    }

    public String getComments() {
        return comments;
    }

    public void setOrdeno(UUID ordeno) {
        this.ordeno = ordeno;
    }

    public void setOrderdate(Timestamp orderdate) {
        this.orderdate = orderdate;
    }

    public void setFname(String fname) {
        this.fname = fname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
    
    
}
