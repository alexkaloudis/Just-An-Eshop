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
import mainpackage.Models.Discounts;


/**
 * FXML Controller class
 *
 * @author Mike
 */
public class DiscountsFXMLController implements Initializable {
    
     
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
    private TableColumn<Discounts, Integer> col_PR_ID;

    @FXML
    private TableColumn<Discounts, Date> col_dateofcreation;

    @FXML
    private TableColumn<Discounts, String> col_description;

    @FXML
    private TableColumn<Discounts, Integer> col_id;

    @FXML
    private TableColumn<Discounts, Float> col_value;

    @FXML
    private TableView<Discounts> table_discounts;

    @FXML
    private TextField tf_description;

    @FXML
    private TextField tf_id;

    @FXML
    private TextField tf_name;

    @FXML
    private TextField tf_value;
    
    
    ObservableList<Discounts> listM;
    
    int index = -1;
    
    Connection con = null;
    ResultSet set = null;
    PreparedStatement ps=null;    
    
    
        public void showDiscounts(){
        listM = JDBCPosrgreSQLConnector.getDataDiscounts();
        //to PropertyValueFactory pairnei to argument apo ton Constructor ths klashs Users
        col_id.setCellValueFactory(new PropertyValueFactory<Discounts,Integer>("Id"));
        col_PR_ID.setCellValueFactory(new PropertyValueFactory<Discounts,Integer>("Product ID"));
        col_value.setCellValueFactory(new PropertyValueFactory<Discounts,Float>("Value"));
        col_dateofcreation.setCellValueFactory(new PropertyValueFactory<Discounts,Date>("dateofcreation"));
        col_description.setCellValueFactory(new PropertyValueFactory<Discounts,String>("Description"));

        table_discounts.setItems(listM);
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
    public void handleButtonHome() throws Exception{
        URL url = new File("src/mainpackage/Fxml/menuFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_home.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
    }

    @FXML
    void handleButtonProducts()throws Exception {
        URL url = new File("src/mainpackage/Fxml/productsFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_Pr.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
    }

    @FXML
    public void handleButtonScene1() throws Exception{
        URL url = new File("src/mainpackage/Fxml/scene1FXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_s1.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
    }

    @FXML
   public void handleCreateButton(ActionEvent event) {
        String query = "INSERT INTO discounts(value,description) VALUES ('" 
                + tf_value.getText()
                +"','"+tf_description.getText()+")";
        executeQuery(query);
        showDiscounts();
    }

    @FXML
    void handleDeleteButton(ActionEvent event) {
        String query = "DELETE FROM discounts WHERE id =" +tf_id.getText()+"";

        executeQuery(query);
        showDiscounts();
    }

    @FXML
    void handleUpdateButton(ActionEvent event) {
        String query = "UPDATE discounts SET value = "+tf_name.getText()
                +"', description = '"+tf_description.getText()+"";

        executeQuery(query);
        showDiscounts();
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
        URL url = new File("src/mainpackage/Fxml/ordersFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_orders_products.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
    }

    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
