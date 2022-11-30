/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package mainpackage.Controllers;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableView;
import mainpackage.JDBCPosrgreSQLConnector;

public class LogsFXMLController implements Initializable {

    @FXML
    private TableView<?> logs_projector;
    @FXML
    private Button btn_users;
    @FXML
    private Button btn_products;
    @FXML
    private Button btn_discounts;
    @FXML
    private Button btn_orders;
    @FXML
    private Button btn_order_products;
    @FXML
    private Button btn_user_address;
    @FXML
    private Button btn_home;


    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    

    @FXML
    private void projectUsersLogFile(){
        JDBCPosrgreSQLConnector.getDataUsersLogs();
    }
    
    @FXML
    private void projectProductsLogFile(){
        JDBCPosrgreSQLConnector.getDataProductsLogs();
    }
    
    @FXML
    private void projectDiscountsLogFile(){
        JDBCPosrgreSQLConnector.getDataDiscountsLogs();
    }
    
    @FXML
    private void projectOrdersLogFile(){
        JDBCPosrgreSQLConnector.getDataOrdersLogs();
    }
    
    @FXML
    private void projectOrderProductsLogFile(){
        JDBCPosrgreSQLConnector.getDataOrderProductsLogs();
    }
    
    @FXML
    private void projectUserAddressLogFile(){
        JDBCPosrgreSQLConnector.getDataUserAddressLogs();
    }
    
}
