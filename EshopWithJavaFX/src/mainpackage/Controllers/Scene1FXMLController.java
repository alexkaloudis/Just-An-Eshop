/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpackage.Controllers;

import java.io.File;
import mainpackage.Models.Users;
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


public class Scene1FXMLController implements Initializable {

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
    private TableView<Users> table_users;
    @FXML
    private TableColumn<Users,Integer > col_id;
    @FXML
    private TableColumn<Users, String> col_username;
    @FXML
    private TableColumn<Users, String> col_password;
    @FXML
    private TableColumn<Users, String> col_email;
    @FXML
    private TableColumn<Users, String> col_phonenumber;
    @FXML
    private TableColumn<Users, String> col_firstname;
    @FXML
    private TableColumn<Users, String> col_lastname;
    @FXML
    private TableColumn<Users, Integer> col_age;
    @FXML
    private TableColumn<Users, Date> col_dateofcreation;
           
    @FXML
    private TextField tf_age;

    @FXML
    private TextField tf_doc;

    @FXML
    private TextField tf_email;
    
    @FXML    
    private TextField tf_id;

    @FXML
    private TextField tf_fName;

    @FXML
    private TextField tf_lName;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_phonenumber;

    @FXML
    private TextField tf_username;
    
    ObservableList<Users> listM;
    
    int index = -1;
    
    Connection con = null;
    ResultSet set = null;
    PreparedStatement ps=null;
    
    public void showUsers(){
        listM = JDBCPosrgreSQLConnector.getDataUsers();
        //to PropertyValueFactory pairnei to argument apo ton Constructor ths klashs Users
        col_id.setCellValueFactory(new PropertyValueFactory<Users,Integer>("Id"));
        col_username.setCellValueFactory(new PropertyValueFactory<Users,String>("Username"));
        col_password.setCellValueFactory(new PropertyValueFactory<Users,String>("Password"));
        col_email.setCellValueFactory(new PropertyValueFactory<Users,String>("Email"));
        col_phonenumber.setCellValueFactory(new PropertyValueFactory<Users,String>("Phonenumber"));
        col_firstname.setCellValueFactory(new PropertyValueFactory<Users,String>("Firstname"));
        col_lastname.setCellValueFactory(new PropertyValueFactory<Users,String>("Lastname"));
        col_age.setCellValueFactory(new PropertyValueFactory<Users,Integer>("Age"));
        col_dateofcreation.setCellValueFactory(new PropertyValueFactory<Users,Date>("dateofcreation"));
        table_users.setItems(listM);
    }
    public void insertUser(){
        String query = "INSERT INTO users(username,password,email,phonenumber,fname,lname,age) VALUES ('" 
                + tf_username.getText()
                +"','"+tf_password.getText()
                +"','"+tf_email.getText()
                +"','"+tf_phonenumber.getText()
                +"','"+tf_fName.getText()
                +"','"+tf_lName.getText()
                +"','"+tf_age.getText()+"')";
        executeQuery(query);
        showUsers();
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
    public void handleMouseAction() {
        Users user = table_users.getSelectionModel().getSelectedItem();
//        tf_id.setText(""+user.getId());
        tf_username.setText(user.getUsername());
        tf_password.setText(user.getPassword());
        tf_email.setText(user.getEmail());
        tf_phonenumber.setText(user.getPhonenumber());
        tf_fName.setText(user.getFirstname());
        tf_lName.setText(user.getLastname());
        tf_age.setText(""+user.getAge());   
    } 
   
    
        @Override
    public void initialize(URL url, ResourceBundle rb) {
      showUsers();
    }
    
    
    public void handleUpdateButton(){
        int selectedIndexId = table_users.getSelectionModel().getSelectedItem().getId();
        String query = "UPDATE users SET username = '"+tf_username.getText()
                +"', password = '"+tf_password.getText()
                +"', email= '"+tf_email.getText()
                +"', phonenumber= '"+tf_phonenumber.getText()
                +"', fname= '"+tf_fName.getText()
                +"', lname= '"+tf_lName.getText()
                +"', age= "+tf_age.getText()+" where id = "+selectedIndexId;
        executeQuery(query);
        showUsers();
        
    }
    public void handleDeleteButton(){
        int selectedIndexId = table_users.getSelectionModel().getSelectedItem().getId();
        String queryToDeleteChildren = "DELETE FROM useraddress WHERE userid =" +selectedIndexId;
        String query = "DELETE FROM users WHERE id =" +selectedIndexId;
        executeQuery(queryToDeleteChildren);
        executeQuery(query);
        showUsers();        
    }
    
        @FXML
      public void handleCreateButton() throws Exception{
        System.out.println("Button clicked");

            insertUser();
            System.out.println("user inserted");            
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

    
}
