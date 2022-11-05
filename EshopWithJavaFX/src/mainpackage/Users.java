/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package mainpackage;

import java.util.Date;

/**
 *
 * @author kalou
 */
public class Users {
    private int id,Age;
    private String Username,Password,Email,Phonenumber,Firstname,Lastname;
    private Date Dateofcreation;
    
    public Users(){};
    public Users(int id, String Username, String Password, String Email, String Phonenumber, String Firstname, String Lastname, int Age,Date Dateofcreation) {
        this.id = id;
        this.Username = Username;
        this.Password = Password;
        this.Email = Email;
        this.Phonenumber = Phonenumber;
        this.Firstname = Firstname;
        this.Lastname = Lastname;
        this.Age = Age;
        this.Dateofcreation=Dateofcreation;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setUsername(String Username) {
        this.Username = Username;
    }

    public void setPassword(String Password) {
        this.Password = Password;
    }

    public void setEmail(String Email) {
        this.Email = Email;
    }

    public void setPhonenumber(String Phonenumber) {
        this.Phonenumber = Phonenumber;
    }

    public void setFirstname(String Firstname) {
        this.Firstname = Firstname;
    }

    public void setLastname(String Lastname) {
        this.Lastname = Lastname;
    }

    public void setAge(int Age) {
        this.Age = Age;
    }

    public void setDateofcreation(Date Dateofcreation) {
        this.Dateofcreation = Dateofcreation;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return Username;
    }

    public String getPassword() {
        return Password;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhonenumber() {
        return Phonenumber;
    }

    public String getFirstname() {
        return Firstname;
    }

    public String getLastname() {
        return Lastname;
    }

    public int getAge() {
        return Age;
    }

    public Date getDateofcreation() {
        return Dateofcreation;
    }

    

    
    
}
