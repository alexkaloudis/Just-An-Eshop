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
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import mainpackage.JDBCPosrgreSQLConnector;
import mainpackage.Models.Discounts;
import mainpackage.Models.Orders;
import mainpackage.Models.Products;


/**
 * FXML Controller class
 *
 * @author Mike
 */
public class DiscountsFXMLController implements Initializable {
    
     
    @FXML
    private Button b_orders_products,
            b_orders,
            b_Dsc,
            b_Pr,
            b_add,
            b_home,
            b_remove,
            b_s1,
            b_update,
            b_user_address;
        @FXML
    private Button b_defaultView;

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
    private TextField tf_value;
    
//    @FXML
//    private VBox left_vbox;
//    @FXML
//    private ChoiceBox prod_names;
    
    @FXML
    private ComboBox combo_products;
    
    
    ObservableList<Discounts> listM;
    ObservableList<Products> listPr;
    
    int index = -1;
    
    Connection con = null;
    ResultSet set = null;
    PreparedStatement ps=null;    
    
    
        public void showDiscounts(){
        listM = JDBCPosrgreSQLConnector.getDataDiscounts();
        //to PropertyValueFactory pairnei to argument apo ton Constructor ths klashs Users
        col_id.setCellValueFactory(new PropertyValueFactory<Discounts,Integer>("Id"));
        col_PR_ID.setCellValueFactory(new PropertyValueFactory<Discounts,Integer>("productid"));
        col_value.setCellValueFactory(new PropertyValueFactory<Discounts,Float>("Value"));
        col_dateofcreation.setCellValueFactory(new PropertyValueFactory<Discounts,Date>("dateofcreation"));
        col_description.setCellValueFactory(new PropertyValueFactory<Discounts,String>("description"));

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
    public void handleCreateButton() {
        
        int getIdFromProdName = JDBCPosrgreSQLConnector.getProductId(combo_products.getSelectionModel().getSelectedItem().toString());
        String query = "INSERT INTO discounts(productid,value,description) VALUES ('" 
                +getIdFromProdName
                +"','"+ tf_value.getText()
                +"','"+tf_description.getText()+"')";
        executeQuery(query);
        showDiscounts();
    }

    @FXML
    public void handleDeleteButton() {
        Alert a = new Alert(AlertType.NONE);
        try{     
            int selectedIndexId = table_discounts.getSelectionModel().getSelectedItem().getId();
            if(selectedIndexId != 0){
                String query = "DELETE FROM discounts WHERE id =" +selectedIndexId;
                executeQuery(query);
                showDiscounts();
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
            int selectedIndexId = table_discounts.getSelectionModel().getSelectedItem().getId();
            if(selectedIndexId != 0){
                String query = "UPDATE discounts SET value = "+tf_value.getText()
                +"', description = '"+tf_description.getText()+" where id = "+selectedIndexId;
                executeQuery(query);
                showDiscounts();
            }   
        }catch(Exception e){
            a.setAlertType(AlertType.ERROR);
            a.setContentText("no index is selected from the table");
            a.show();
        }
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
    public void handleMouseAction() {
        Discounts selectedIndexId = table_discounts.getSelectionModel().getSelectedItem(); 
        Discounts dis = table_discounts.getSelectionModel().getSelectedItem();
        String getProdName = JDBCPosrgreSQLConnector.getProductNameFromProdId(dis.getId());
        combo_products.getSelectionModel().select(getProdName);
        tf_value.setText(String.valueOf(dis.getValue()));
        tf_description.setText(dis.getDescription());  
    }
    
        @FXML
    void handleDefaultView() {
        showDiscounts();      
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showDiscounts();
        listPr = JDBCPosrgreSQLConnector.getDataProducts();
//        for(Products pr : listPr){
//            prod_names.getItems().add(pr.getName());
//        } 
        listPr = JDBCPosrgreSQLConnector.getDataProducts();
        for(Products pr : listPr){
            combo_products.getItems().add(pr.getName());
        }
//        left_vbox.widthProperty().addListener(new ChangeListener<Number>() {
//        @Override public void changed(ObservableValue<? extends Number> observableValue, Number oldSceneWidth, Number newSceneWidth) {
//            if(newSceneWidth!=oldSceneWidth){
//                System.out.println("pame");
//            }
//        }
//        });

    }    
    
}
