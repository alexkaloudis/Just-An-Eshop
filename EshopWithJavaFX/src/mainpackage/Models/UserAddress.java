/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage.Models;

/**
 *
 * @author Mike
 */
public class UserAddress {
    private int userid,number;
    private String country,region,city,street,postalcode;
    
    
    public UserAddress() {
    }

    public UserAddress(int userid, int number, String country, String region, String city, String street, String postalcode) {
        this.userid = userid;
        this.number = number;
        this.country = country;
        this.region = region;
        this.city = city;
        this.street = street;
        this.postalcode = postalcode;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public void setPostalcode(String postalcode) {
        this.postalcode = postalcode;
    }

    public int getUserid() {
        return userid;
    }

    public int getNumber() {
        return number;
    }

    public String getCountry() {
        return country;
    }

    public String getRegion() {
        return region;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public String getPostalcode() {
        return postalcode;
    }


}
