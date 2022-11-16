/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpackage.Controllers;

import java.awt.event.ActionEvent;
import java.io.File;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mainpackage.JDBCPosrgreSQLConnector;
import mainpackage.JDBCPosrgreSQLConnector;
import mainpackage.Models.Products;
import mainpackage.Models.UserAddress;

/**
 * FXML Controller class
 *
 * @author Mike
 */
public class UserAddressFXMLController implements Initializable {

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

    @FXML
    private Button b_user_address;

    @FXML
    private TableColumn<UserAddress, String> col_city;

    @FXML
    private TableColumn<UserAddress, String> col_country;

    @FXML
    private TableColumn<UserAddress, Integer> col_id;

    @FXML
    private TableColumn<UserAddress, Integer> col_number;

    @FXML
    private TableColumn<UserAddress, String> col_postalCode;

    @FXML
    private TableColumn<UserAddress, String> col_region;

    @FXML
    private TableColumn<UserAddress, String> col_street;

    @FXML
    private TableView<UserAddress> table_user_address;

    @FXML
    private TextField tf_city;

    @FXML
    private TextField tf_country;

    @FXML
    private TextField tf_id;

    @FXML
    private TextField tf_number;

    @FXML
    private TextField tf_postal_code;

    @FXML
    private TextField tf_region;

    @FXML
    private TextField tf_street;
    
    ObservableList<UserAddress> listM;
    
    int index = -1;
    
    Connection con = null;
    ResultSet set = null;
    PreparedStatement ps=null;
    
    
        public void showUserAddress(){
        listM = JDBCPosrgreSQLConnector.getDataUserAddress();
        //to PropertyValueFactory pairnei to argument apo ton Constructor ths klashs Products
        col_id.setCellValueFactory(new PropertyValueFactory<UserAddress,Integer>("Id"));
        col_country.setCellValueFactory(new PropertyValueFactory<UserAddress,String>("Name"));
        col_region.setCellValueFactory(new PropertyValueFactory<UserAddress,String>("Price"));
        col_city.setCellValueFactory(new PropertyValueFactory<UserAddress,String>("dateofcreation"));
        col_street.setCellValueFactory(new PropertyValueFactory<UserAddress,String>("Description"));
        col_number.setCellValueFactory(new PropertyValueFactory<UserAddress,Integer>("Description"));
        col_postalCode.setCellValueFactory(new PropertyValueFactory<UserAddress,String>("Description"));
        table_user_address.setItems(listM);
    }

    public void executeQuery(String query){
        con = JDBCPosrgreSQLConnector.ConnectDb(); 
        try{
            PreparedStatement ps = con.prepareStatement(query);
            ps.executeUpdate();
        }catch(Exception e){
            e.printStackTrace();
        }
    }        
    @FXML
    void handleCreateButton(ActionEvent event) {
        String query = "INSERT INTO useraddress(country,region,city,street,number,postalcode) VALUES ('" 
                + tf_country.getText()
                +"','"+tf_region.getText()
                +"','"+tf_city.getText()
                +"','"+tf_street.getText()
                +"','"+tf_number.getText()
                +"','"+tf_postal_code.getText()+")";
        executeQuery(query);
        showUserAddress();        

    }

    @FXML
    void handleDeleteButton(ActionEvent event) {
        String query = "DELETE FROM products WHERE id =" +tf_id.getText()+"";

        executeQuery(query);
        showUserAddress();
    }
    

    @FXML
    void handleUpdateButton(ActionEvent event) {
        String query = "UPDATE users SET country = "+tf_country.getText()
                +"', region = '"+tf_region.getText()
                +"', city = '"+tf_city.getText()
                +"', street = '"+tf_street.getText()
                +"', number = '"+tf_number.getText()
                +"', postalcode = '"+tf_postal_code.getText()+"";

        executeQuery(query);
        showUserAddress();        
    }
    
     public void handleButtonHome() throws Exception{
        URL url = new File("src/mainpackage/Fxml/menuFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_home.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
    }
     
    public void handleButtonScene1() throws Exception{
        URL url = new File("src/mainpackage/Fxml/scene1FXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_s1.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
    }
    
     public void handleButtonProducts() throws Exception{
        URL url = new File("src/mainpackage/Fxml/productsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_Pr.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
    }
     
    @FXML
    void handleButtonDiscounts() throws Exception{
        URL url = new File("src/mainpackage/Fxml/discountsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_Dsc.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
    }
    
        @FXML
    void handleButtonOrders(ActionEvent event)throws Exception {
        URL url = new File("src/mainpackage/Fxml/ordersFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_orders.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
    }
    
    @FXML
    void handleButtonOrders_prod(ActionEvent event)throws Exception {
        URL url = new File("src/mainpackage/Fxml/ordersProductsL.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_orders_products.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
    }
    
    @FXML
    void handleButtonUserAddress(ActionEvent event)throws Exception {
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
