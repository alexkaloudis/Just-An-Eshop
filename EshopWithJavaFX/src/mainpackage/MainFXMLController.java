/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpackage;

import java.sql.DriverManager;
import java.sql.PreparedStatement;
import javafx.collections.FXCollections;
import java.sql.Connection;
import java.sql.ResultSet;
import java.net.URL;
import java.util.Date;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author kalou
 */
public class MainFXMLController implements Initializable {

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
    
    ObservableList<Users> listM;
    
    int index = -1;
    
    Connection con = null;
    ResultSet set = null;
    PreparedStatement ps = null;
    @Override
    public void initialize(URL url, ResourceBundle rb) {
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
        
        listM = JDBCPosrgreSQLConnector.getDataUsers();
        table_users.setItems(listM);
        System.out.println(listM.get(0));
    }    
    
}
