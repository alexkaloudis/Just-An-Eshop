/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpackage.Controllers;

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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mainpackage.JDBCPosrgreSQLConnector;
import mainpackage.Models.Products;


/**
 * FXML Controller class
 *
 * @author Mike
 */
public class ProductsFXMLController implements Initializable {
 
    @FXML
    private Button b_user_address;
    @FXML
    private Button b_orders_products;
    @FXML
    private Button b_orders;
    @FXML
    private Button b_Dsc;
    
    @FXML
    private Button b_Pr;

    @FXML
    private Button b_add;

    @FXML
    private Button b_home;

    @FXML
    private Button b_remove;

    @FXML
    private Button b_s1;

    @FXML
    private Button b_update;
    @FXML
    private Button btn_gotologs;

    @FXML
    private TableColumn<Products, Date> col_dateofcreation;

    @FXML
    private TableColumn<Products, String> col_description;

    @FXML
    private TableColumn<Products, Integer> col_id;

    @FXML
    private TableColumn<Products, String> col_name;

    @FXML
    private TableColumn<Products, Double> col_price;

    @FXML
    private TableView<Products> table_products;

    @FXML
    private TextArea ta_description;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_price;
    
    ObservableList<Products> listM;
    
    int index = -1;
    
    Connection con = null;
    ResultSet set = null;
    PreparedStatement ps=null;
    
    
        public void showProducts(){
        listM = JDBCPosrgreSQLConnector.getDataProducts();
        //to PropertyValueFactory pairnei to argument apo ton Constructor ths klashs Products
        col_id.setCellValueFactory(new PropertyValueFactory<Products,Integer>("id"));
        col_name.setCellValueFactory(new PropertyValueFactory<Products,String>("name"));
        col_price.setCellValueFactory(new PropertyValueFactory<Products,Double>("price"));
        col_dateofcreation.setCellValueFactory(new PropertyValueFactory<Products,Date>("dateofcreation"));
        col_description.setCellValueFactory(new PropertyValueFactory<Products,String>("Description"));
        table_products.setItems(listM);
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
    public void handleCreateButton() {
        Alert a = new Alert(AlertType.NONE);
        try{ 
            if(tf_name.getText() != "" && tf_price.getText() != "" && ta_description.getText() != ""){
                String query = "select insert_into_products('" 
                + tf_name.getText()
                +"',"+tf_price.getText()
                +",'"+ta_description.getText()+"')";
                executeQuery(query);
                showProducts();
            }else{
                throw new Exception();
            }
                   
        }catch(Exception e){
            a.setAlertType(AlertType.ERROR);
            a.setContentText("all fields are required");
            a.show();
        }
             
    }

    @FXML
    public void handleDeleteButton() {
        Alert a = new Alert(AlertType.NONE);
        try{     
            int selectedIndexId = table_products.getSelectionModel().getSelectedItem().getId();
            if(selectedIndexId != 0){
                String query = "select delete_from_products(" +selectedIndexId+")";
                executeQuery(query);
                showProducts();
            }    
        }catch(Exception e){
            a.setAlertType(AlertType.ERROR);
            a.setContentText("no index is selected from the table");
            a.show();
        } 
        
    }
    

    @FXML
    public void handleUpdateButton() {
        Alert a = new Alert(AlertType.NONE);
        try{     
            int selectedIndexId = table_products.getSelectionModel().getSelectedItem().getId();
            if(selectedIndexId != 0){
                String query = "select update_products('"+tf_name.getText()
                    +"',"+tf_price.getText()
                    +",'"+ta_description.getText()+"',"+selectedIndexId+")";

                executeQuery(query);
                showProducts();
            }   
        }catch(Exception e){
            a.setAlertType(AlertType.ERROR);
            a.setContentText("no index is selected from the table");
            a.show();
        }        
    }
    
     public void handleButtonHome() throws Exception{
        URL url = new File("src/mainpackage/Fxml/menuFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_home.getScene().getWindow();
        window.setScene(new Scene(root,988,730));
    }
     
    public void handleButtonScene1() throws Exception{
        URL url = new File("src/mainpackage/Fxml/scene1FXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_s1.getScene().getWindow();
        window.setScene(new Scene(root,988,730));
    }
    
     public void handleButtonProducts() throws Exception{
        URL url = new File("src/mainpackage/Fxml/productsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_Pr.getScene().getWindow();
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
        URL url = new File("src/mainpackage/Fxml/orderProductsFXML.fxml").toURI().toURL();
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
    public void handleMouseAction() {
        Products pr = table_products.getSelectionModel().getSelectedItem();
        tf_name.setText(pr.getName());
        tf_price.setText(String.valueOf(pr.getPrice()));
        ta_description.setText(pr.getDescription());  
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showProducts();
        ta_description.setWrapText(true);
       
    }  
    @FXML
    public void handleButtonLogs()throws Exception {
        URL url = new File("src/mainpackage/Fxml/logsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) btn_gotologs.getScene().getWindow();
        window.setScene(new Scene(root,988,730));
    }
     @FXML
    public void handleQueryButton(){
    
    System.out.println("not implemented");}

    
}
