/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpackage.Controllers;

import java.sql.SQLException;
import com.sun.javafx.logging.PlatformLogger.Level;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;
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

/**
 * FXML Controller class
 *
 * @author Mike
 */
public class Scene1FXMLController implements Initializable {
    
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
    Button b_home,b_s1,b_s2;
    
    @FXML
    Button b_add,b_remove, b_update; 
    
    
    @FXML
    private TextField tf_age;

    @FXML
    private TextField tf_doc;

    @FXML
    private TextField tf_email;

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
        String query = "INSERT INTO users(username,password,email,phonenumber,fname,lname,age) VALUES ('" + tf_username.getText()
                +"','"+tf_password.getText()
                +"','"+tf_email.getText()
                +"','"+tf_phonenumber.getText()
                +"','"+tf_fName.getText()
                +"','"+tf_lName.getText()
                +"',"+tf_age.getText()+")";
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
    public void handleMouseAction(MouseEvent event) {
        Users user = table_users.getSelectionModel().getSelectedItem();
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
        String query = "UPDATE users SET username = '"+tf_username.getText()
                +"', password = '"+tf_password.getText()
                +"', email= '"+tf_email.getText()
                +"', phonenumber= '"+tf_phonenumber.getText()
                +"', fname= '"+tf_fName.getText()
                +"', lname= '"+tf_lName.getText()
                +"', age= "+tf_age.getText()+" where age = "+tf_age.getText();

        executeQuery(query);
        showUsers();
        
    }
    public void handleDeleteButton(){
        String query = "DELETE FROM users WHERE username ='" +tf_username.getText()+"'";

        executeQuery(query);
        showUsers();        
    }

    
    @FXML
     public void handleButtonHome() throws Exception{
        URL url = new File("src/mainpackage/Fxml/menuFXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_home.getScene().getWindow();
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
     public void handleButtonScene2() throws Exception{
        URL url = new File("src/mainpackage/Fxml/scene2FXML.fxml").toURI().toURL();
        Parent root = FXMLLoader.load(url);
        
        Stage window = (Stage) b_s2.getScene().getWindow();
        window.setScene(new Scene(root,930,680));
    }
     
    @FXML
      public void handleCreateButton() throws Exception{
        System.out.println("Button clicked");

            insertUser();
            System.out.println("user inserted");
//            String userName,password,eMail,phonenumber,fName,lName,age1,doc1;
//            int age;
//            Date doc;
//         //   java.time.format.DateTimeFormatter formatter = java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy");
//         //   java.time.LocalDate textFieldAsDate = java.time.LocalDate.parse(tf_doc, formatter);
//            userName = tf_username.getText();
//            password = tf_password.getText();
//            eMail = tf_email.getText();
//            phonenumber = tf_phonenumber.getText();
//            fName = tf_fName.getText();
//            lName = tf_lName.getText();
//       //     age = Integer.parseInt(tf_age.getText()); //kanw parse 
//            age1 = tf_age.getText();
//           // doc = Date.format(tf_doc.getText());
//           doc1=tf_doc.getText();
    //    try
    //    {
//            ps = con.prepareStatement("insert into Users(Username,Password,Email,Phonenumber,Firstname,Lastname,Age,Dateofcreation)values(?,?,?,?,?,?,?,?)");
//            ps.setString(1, userName);
//            ps.setString(2, password);
//            ps.setString(3, eMail);
//            ps.setString(4, phonenumber);
//            ps.setString(5, fName);
//            ps.setString(6, lName);
        //    ps.setInt(7, age);
//            ps.setString(7, age1);
//        //    ps.setDate(8, (java.sql.Date) doc);
//            ps.setString(8,  doc1);
//            ps.executeUpdate();
          
            
//            tf_username.setText("");
//            tf_password.setText("");
//            tf_email.setText("");
//            tf_phonenumber.setText("");
//            tf_fName.setText("");
//            tf_lName.setText("");
//            tf_age.setText("");
//            tf_doc.setText("");
//            tf_username.requestFocus();
      //  }
    //    catch (SQLException ex)
      //  {
       //     Logger.getLogger(JDBCPosrgreSQLConnector.class.getName()).log(Level.SEVERE, null, ex);
       // }  
    }
     

    
}
