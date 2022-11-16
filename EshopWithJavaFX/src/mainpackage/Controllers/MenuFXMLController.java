/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpackage.Controllers;

import java.awt.event.ActionEvent;
import java.io.File;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import javafx.fxml.FXML;

import javafx.fxml.FXML;

import javafx.scene.control.Button;

/**
 * FXML Controller class
 *
 * @author Mike
 */
public class MenuFXMLController implements Initializable {

    @FXML
    private Button b_s2; 
    @FXML
    private Button b_user_address;
    @FXML
    private Button b_Dsc;

    @FXML
    private Button b_Pr;

    @FXML
    private Button b_add;

    @FXML
    private Button b_home;

    @FXML
    private Button b_orders;

    @FXML
    private Button b_orders_products;

    @FXML
    private Button b_remove;

    @FXML
    private Button b_s1;

    @FXML
    private Button b_update;

    
     public void handleButtonHome() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("menuFXML.fxml"));
        
        Stage window = (Stage) b_home.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
    }
     
    public void handleButtonScene1() throws Exception{

        Parent root = FXMLLoader.load(getClass().getResource("scene1FXML.fxml"));

        URL url = new File("src/mainpackage/Fxml/scene1FXML.fxml").toURI().toURL();
        root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_s1.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
    }
    

     public void handleButtonScene2() throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("scene2FXML.fxml"));
        
        Stage window = (Stage) b_s2.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
     }

     public void handleButtonProducts() throws Exception{
        URL url = new File("src/mainpackage/Fxml/productsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_Pr.getScene().getWindow();

        window.setScene(new Scene(root,930,680));
    }
     
    @FXML
   public void handleButtonDiscounts() throws Exception{
        URL url = new File("src/mainpackage/Fxml/discountsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_Dsc.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
    }
    
        @FXML
    public void handleButtonOrders()throws Exception {
        URL url = new File("src/mainpackage/Fxml/ordersFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_orders.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
    }
    
         @FXML
   public void handleButtonOrders_prod()throws Exception {
        URL url = new File("src/mainpackage/Fxml/ordersFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_orders_products.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
    } 

    @FXML
   public void handleButtonUserAddress()throws Exception {
        URL url = new File("src/mainpackage/Fxml/userAddressFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_user_address.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
    }    
     
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
