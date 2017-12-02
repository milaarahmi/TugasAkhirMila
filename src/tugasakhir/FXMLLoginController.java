/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.sql.Connection;
import java.net.URL;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mila
 */
public class FXMLLoginController implements Initializable {

    @FXML
    private JFXTextField idUsername;
    @FXML
    private JFXTextField idPassword;
    @FXML
    private JFXButton idButton;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void login(ActionEvent event) {                                    
    Connection con;
    Statement stat;
    ResultSet rs;
    String sql;
    
        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = DB.stm;                                      
         if(idUsername.getText().equals("") && idPassword.getText().equals("")){
                JOptionPane.showMessageDialog(null,"MAAF USERNAME DAN PASSWORD SALAH!!");
            }
            else {
        try {
            sql = "SELECT * FROM login WHERE username='"+idUsername.getText()+"' AND password='"
                    +idPassword.getText()+"'";
            rs = stat.executeQuery(sql);
            if(rs.next()){
                if(idUsername.getText().equals(rs.getString("username")) && idPassword.getText().
                equals(rs.getString("password"))){
               
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("menu.fxml"));
                      
            
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Perpustakaan");
            stage.show();
                }
            }else{
                    JOptionPane.showMessageDialog(null, "username atau password salah");
                }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }}
}