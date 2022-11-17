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
import java.util.UUID;
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
import mainpackage.Models.Orders;


/**
 * FXML Controller class
 *
 * @author Mike
 */
public class OrdersFXMLController implements Initializable {

   @FXML
    private Button b_user_address,
                b_orders_products,
                b_Dsc,
                b_Pr,
                b_add,
                b_home,
                b_orders,
                b_remove,
                b_s1,
                b_update;

    @FXML
    private TableColumn<Orders, String> col_comments;

    @FXML
    private TableColumn<Orders, Date> col_dateoforder;

    @FXML
    private TableColumn<Orders, String> col_fname;

    @FXML
    private TableColumn<Orders, String> col_lName;

    @FXML
    private TableColumn<Orders, UUID> col_uuid;

    @FXML
    private TableView<Orders> table_orders;

    @FXML
    private TextField tf_comment;

    @FXML
    private TextField tf_fName;

    @FXML
    private TextField tf_id;

    @FXML
    private TextField tf_lName;
 
    ObservableList<Orders> listM;
    
    int index = -1;
    
    Connection con = null;
    ResultSet set = null;
    PreparedStatement ps=null;
    
    
    
        public void showOrders(){
        listM = JDBCPosrgreSQLConnector.getDataOrders();
        //to PropertyValueFactory pairnei to argument apo ton Constructor ths klashs Products
        col_uuid.setCellValueFactory(new PropertyValueFactory<Orders,UUID>("orderno"));
        col_dateoforder.setCellValueFactory(new PropertyValueFactory<Orders,Date>("orderdate"));
        col_fname.setCellValueFactory(new PropertyValueFactory<Orders,String>("fname"));
        col_lName.setCellValueFactory(new PropertyValueFactory<Orders,String>("lname"));
        col_comments.setCellValueFactory(new PropertyValueFactory<Orders,String>("comments"));
        
        table_orders.setItems(listM);
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
    public void handleButtonDiscounts()throws Exception {
        URL url = new File("src/mainpackage/Fxml/discountsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_Dsc.getScene().getWindow();
        window.setScene(new Scene(root,930,730));
    }

    @FXML
    public void handleButtonHome() throws Exception{
        URL url = new File("src/mainpackage/Fxml/menuFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_home.getScene().getWindow();
        window.setScene(new Scene(root,930,730));
    }

    @FXML
    public void handleButtonOrders()throws Exception {
        URL url = new File("src/mainpackage/Fxml/ordersFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_orders.getScene().getWindow();
        window.setScene(new Scene(root,930,730));
    }

    @FXML
    public void handleButtonProducts() throws Exception{
        URL url = new File("src/mainpackage/Fxml/productsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_Pr.getScene().getWindow();
        window.setScene(new Scene(root,930,730));
    }

    @FXML
    public void handleButtonScene1() throws Exception{
        URL url = new File("src/mainpackage/Fxml/scene1FXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_s1.getScene().getWindow();
        window.setScene(new Scene(root,930,730));
    }

    @FXML
    public void handleCreateButton() {
        String query = "INSERT INTO orders(fname,lname,comments) VALUES ('" 
                + tf_fName.getText()
                +"','"+tf_lName.getText()
                +"','"+tf_comment.getText()+"')";
        executeQuery(query);
        showOrders();
    }

    @FXML
    public void handleDeleteButton() {
        String query = "DELETE FROM orders WHERE orderno =" +col_uuid.getText()+"";

        executeQuery(query);
        showOrders();
    }

    @FXML
    public void handleUpdateButton() {
        String query = "UPDATE orders SET fname = "+tf_fName.getText()
                +"', lname = '"+tf_lName.getText()
                +"', comment = '"+tf_comment.getText()+"";

        executeQuery(query);
        showOrders(); 
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showOrders();
    }   
    
    @FXML
    public void handleButtonOrders_prod()throws Exception {
        URL url = new File("src/mainpackage/Fxml/orderProductsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_orders_products.getScene().getWindow();
        window.setScene(new Scene(root,930,730));
    }
    
    @FXML
    public void handleButtonUserAddress()throws Exception {
        URL url = new File("src/mainpackage/Fxml/userAddressFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_user_address.getScene().getWindow();
        window.setScene(new Scene(root,930,730));
    }

    
}
