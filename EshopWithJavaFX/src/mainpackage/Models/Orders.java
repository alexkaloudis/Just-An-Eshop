/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage.Models;

import java.sql.Timestamp;
import java.util.UUID;

public class Orders {
   private int orderno;
   private Timestamp orderdate;
   private String fname,lname,comments;


    public Orders(int  orderno, Timestamp orderdate, String fname, String lname, String comments) {
        this.orderno = orderno;
        this.orderdate = orderdate;
        this.fname = fname;
        this.lname = lname;
        this.comments = comments;
    }

    public int getOrderno() {
        return orderno;
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

    public void setOrderno(int orderno) {
        this.orderno = orderno;
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
