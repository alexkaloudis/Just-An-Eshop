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
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import mainpackage.JDBCPosrgreSQLConnector;
import mainpackage.Models.UserAddress;
import mainpackage.Models.Users;

public class UserAddressFXMLController implements Initializable {

    @FXML
    private Button b_Dsc,
            b_Pr,
            b_add,
            b_home,
            b_orders,
            b_orders_products,
            b_remove,
            b_s1,
            b_update,
            b_user_address;

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
    private TextField tf_number;

    @FXML
    private TextField tf_postal_code;

    @FXML
    private TextField tf_region;

    @FXML
    private TextField tf_street;
    
    @FXML
    private ChoiceBox cb_usernames;
    
    ObservableList<UserAddress> listM;
    
    ObservableList<Users> listUsernames;
    
    int index = -1;
    
    Connection con = null;
    ResultSet set = null;
    PreparedStatement ps=null;
    
    
    public void showUserAddresses(){
        listM = JDBCPosrgreSQLConnector.getDataUserAddress();
        //to PropertyValueFactory pairnei to argument apo ton Constructor ths klashs Products
        col_id.setCellValueFactory(new PropertyValueFactory<UserAddress,Integer>("userid"));
        col_country.setCellValueFactory(new PropertyValueFactory<UserAddress,String>("country"));
        col_region.setCellValueFactory(new PropertyValueFactory<UserAddress,String>("region"));
        col_city.setCellValueFactory(new PropertyValueFactory<UserAddress,String>("city"));
        col_street.setCellValueFactory(new PropertyValueFactory<UserAddress,String>("street"));
        col_number.setCellValueFactory(new PropertyValueFactory<UserAddress,Integer>("number"));
        col_postalCode.setCellValueFactory(new PropertyValueFactory<UserAddress,String>("postalcode"));
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
    public void handleCreateButton() {
        int idFromUsername = JDBCPosrgreSQLConnector.getUserIdFromUsername(cb_usernames.getSelectionModel().getSelectedItem().toString());
        String query = "INSERT INTO useraddress(userid,country,region,city,street,number,postalcode) VALUES (" 
                +idFromUsername
                +",'" +tf_country.getText()
                +"','"+tf_region.getText()
                +"','"+tf_city.getText()
                +"','"+tf_street.getText()
                +"',"+tf_number.getText()
                +",'"+tf_postal_code.getText()+"')";
        executeQuery(query);
        showUserAddresses();        

    }

    @FXML
    public void handleDeleteButton() {
        int selectedIndexId = table_user_address.getSelectionModel().getSelectedItem().getId();
        String query = "DELETE FROM useraddress WHERE id =" +selectedIndexId+"";
        executeQuery(query);
        showUserAddresses();
    }
    
    @FXML
    public void handleMouseAction() {
        UserAddress userAd = table_user_address.getSelectionModel().getSelectedItem();
        String username = JDBCPosrgreSQLConnector.getUserNameFromUserid(userAd.getUserid());
        cb_usernames.getSelectionModel().select(username);
        tf_country.setText(userAd.getCountry());
        tf_region.setText(userAd.getRegion());
        tf_city.setText(userAd.getCity());
        tf_street.setText(userAd.getStreet());
        tf_number.setText(String.valueOf(userAd.getNumber()));
        tf_postal_code.setText(userAd.getPostalcode()); 
    } 

    @FXML
    public void handleUpdateButton() {
        UserAddress userAd = table_user_address.getSelectionModel().getSelectedItem();
        int selectedIndexUAdId = table_user_address.getSelectionModel().getSelectedItem().getId();
        String query = "UPDATE useraddress SET country = '"+tf_country.getText()
                +"', region = '"+tf_region.getText()
                +"', city = '"+tf_city.getText()
                +"', street = '"+tf_street.getText()
                +"', number = '"+tf_number.getText()
                +"', postalcode = '"+tf_postal_code.getText()+"' where id = "+selectedIndexUAdId;

        executeQuery(query);
        showUserAddresses();        
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
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        showUserAddresses();
        listUsernames = JDBCPosrgreSQLConnector.getDataUsers();
        for(Users user : listUsernames){
            cb_usernames.getItems().add(user.getUsername());
        }
    }    
    
}
