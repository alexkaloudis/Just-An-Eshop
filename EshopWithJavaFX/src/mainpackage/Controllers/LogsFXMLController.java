/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpackage.Controllers;

import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import mainpackage.JDBCPosrgreSQLConnector;

public class LogsFXMLController implements Initializable {

    @FXML
    private Button b_user_address;    
    @FXML
    private Button b_Dsc;
    @FXML
    private Button b_Pr;
    @FXML
    private Button b_home;
    @FXML
    private Button b_orders;
    @FXML
    private Button b_orders_products;
    @FXML
    private Button b_s1;
    @FXML
    private Button btn_gotologs;    
    @FXML
    private TableView<?> logs_projector;
    @FXML
    private Button btn_users;
    @FXML
    private Button btn_products;
    @FXML
    private Button btn_discounts;
    @FXML
    private Button btn_orders;
    @FXML
    private Button btn_order_products;
    @FXML
    private Button btn_user_address;
    @FXML
    private Button btn_home;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void projectUsersLogFile(){
        JDBCPosrgreSQLConnector.getDataUsersLogs();
    }
    
    @FXML
    private void projectProductsLogFile(){
        JDBCPosrgreSQLConnector.getDataProductsLogs();
    }
    
    @FXML
    private void projectDiscountsLogFile(){
        JDBCPosrgreSQLConnector.getDataDiscountsLogs();
    }
    
    @FXML
    private void projectOrdersLogFile(){
        JDBCPosrgreSQLConnector.getDataOrdersLogs();
    }
    
    @FXML
    private void projectOrderProductsLogFile(){
        JDBCPosrgreSQLConnector.getDataOrderProductsLogs();
    }
    
    @FXML
    private void projectUserAddressLogFile(){
        JDBCPosrgreSQLConnector.getDataUserAddressLogs();
    }
    
    
      @FXML
    public void handleButtonHome() throws Exception{
        URL url = new File("src/mainpackage/Fxml/menuFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_home.getScene().getWindow();
        window.setScene(new Scene(root,988,730));
    }

    @FXML
    public void handleButtonProducts()throws Exception {
        URL url = new File("src/mainpackage/Fxml/productsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_Pr.getScene().getWindow();
        window.setScene(new Scene(root,988,730));
    }

    @FXML
    public void handleButtonScene1() throws Exception{
        URL url = new File("src/mainpackage/Fxml/scene1FXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_s1.getScene().getWindow();
        window.setScene(new Scene(root,988,730));
    }
    
    @FXML
    public void handleButtonDiscounts() throws Exception{
        URL url = new File("src/mainpackage/Fxml/discountsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_Dsc.getScene().getWindow();
        window.setScene(new Scene(root,988,730));
    }  
    
    @FXML
    public void handleButtonOrders()throws Exception {
        URL url = new File("src/mainpackage/Fxml/ordersFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_orders.getScene().getWindow();
        window.setScene(new Scene(root,988,730));
    } 
    
    @FXML
    public void handleButtonOrders_prod()throws Exception {
        URL url = new File("src/mainpackage/Fxml/ordersFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_orders_products.getScene().getWindow();
        window.setScene(new Scene(root,988,730));
    }
    
    @FXML
    public void handleButtonUserAddress()throws Exception {
        URL url = new File("src/mainpackage/Fxml/userAddressFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_user_address.getScene().getWindow();
        window.setScene(new Scene(root,988,730));
    }
    @FXML
    public void handleButtonLogs()throws Exception {
        URL url = new File("src/mainpackage/Fxml/logsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) btn_gotologs.getScene().getWindow();
        window.setScene(new Scene(root,988,730));
    } 
    
}
