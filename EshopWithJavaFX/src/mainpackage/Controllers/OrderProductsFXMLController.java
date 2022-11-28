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
import java.util.ResourceBundle;
import java.util.UUID;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mainpackage.JDBCPosrgreSQLConnector;
import mainpackage.Models.OrderProducts;
import mainpackage.Models.Orders;
import mainpackage.Models.Products;

public class OrderProductsFXMLController implements Initializable {

    
    @FXML
    private Button b_user_address,
                   b_Dsc,
                   b_Pr,
                   b_add,
                   b_home,
                   b_orders,
                   b_orders_products,
                   b_remove,
                   b_s1,
                   b_update;

    @FXML
    private TableColumn<OrderProducts, Integer> col_id;

    @FXML
    private TableColumn<OrderProducts, UUID> col_order_number;

    @FXML
    private TableColumn<OrderProducts, Float> col_order_value;

    @FXML
    private TableColumn<OrderProducts, Integer> col_prod_id;

    @FXML
    private TableColumn<OrderProducts, Integer> col_quantity;

    @FXML
    private TableView<OrderProducts> table_order_products;

    @FXML
    private TextField tf_order_value;

    @FXML
    private TextField tf_quantity;
     
    @FXML
    private ComboBox combo_order_no;
    
    @FXML
    private ComboBox combo_products;

    ObservableList<OrderProducts> listM; 
    ObservableList<Products> listPr;
    ObservableList<Orders> listOrd;

    int index = -1;
    
    Connection con = null;
    ResultSet set = null;
    PreparedStatement ps=null;
    
    
    public void showOrderProducts(){
        listM = JDBCPosrgreSQLConnector.getDataOrderProducts();
        //to PropertyValueFactory pairnei to argument apo ton Constructor ths klashs Products
        col_id.setCellValueFactory(new PropertyValueFactory<OrderProducts,Integer>("id"));
        col_order_number.setCellValueFactory(new PropertyValueFactory<OrderProducts,UUID>("orderno"));
        col_prod_id.setCellValueFactory(new PropertyValueFactory<OrderProducts,Integer>("productid"));
        col_quantity.setCellValueFactory(new PropertyValueFactory<OrderProducts,Integer>("quantity"));
        col_order_value.setCellValueFactory(new PropertyValueFactory<OrderProducts,Float>("ordervalue"));
        table_order_products.setItems(listM);
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
        int getIdFromProdName = JDBCPosrgreSQLConnector.getProductId(combo_products.getSelectionModel().getSelectedItem().toString());
        String query = "INSERT INTO orderproducts(orderno,productid,quantity,ordervalue) VALUES ('"
                +combo_order_no.getSelectionModel().getSelectedItem()
                +"','"+getIdFromProdName
                +"',"+tf_quantity.getText()
                +","+tf_order_value.getText()+")";
        executeQuery(query);
        showOrderProducts();        

    }

    @FXML
    public void handleDeleteButton() {
        String query = "DELETE FROM orderproducts WHERE id =" 
                +table_order_products.getSelectionModel().getSelectedItem().getId();
        executeQuery(query);
        showOrderProducts();
    }
    

    @FXML
    public void handleUpdateButton() {
        String query = "UPDATE orderproducts SET orderno = '"
                +combo_order_no.getSelectionModel().getSelectedItem()
                +"', productid = "+table_order_products.getSelectionModel().getSelectedItem().getProductid()
                +", quantity = "+tf_quantity.getText()
                +", ordervalue = "+tf_order_value.getText()+" where id = "
                +table_order_products.getSelectionModel().getSelectedItem().getId();

        executeQuery(query);
        showOrderProducts();        
    }
    
    @FXML
    public void handleButtonHome() throws Exception{
        URL url = new File("src/mainpackage/Fxml/menuFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_home.getScene().getWindow();
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
        OrderProducts op = table_order_products.getSelectionModel().getSelectedItem();
        String prodName = JDBCPosrgreSQLConnector.getProductNameFromProdId(op.getId());
        combo_order_no.getSelectionModel().select(op.getOrderno());
        combo_products.getSelectionModel().select(prodName);
        System.out.println(prodName);
        tf_quantity.setText(String.valueOf(op.getQuantity()));
        tf_order_value.setText(String.valueOf(op.getOrdervalue()));

    } 
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showOrderProducts();
        listPr = JDBCPosrgreSQLConnector.getDataProducts();
        for(Products pr : listPr){
            combo_products.getItems().add(pr.getName());
        }
        listOrd = JDBCPosrgreSQLConnector.getDataOrders();
        for(Orders or : listOrd){
            combo_order_no.getItems().add(or.getOrderno());
        }
    }
}


