/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
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
public class FXMLDaftarController implements Initializable {

    @FXML
    private JFXTextField idUsername;
    @FXML
    private JFXTextField idPassword;
    @FXML
    private JFXButton idButton;
    @FXML
    private JFXButton idButton1;
    
    @FXML
    private JFXTextField alamat;

    @FXML
    private JFXTextField telp;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void daftar(ActionEvent event) {
            if(idUsername.getText().equals("")){
                JOptionPane.showMessageDialog(null,"MOHON ISI USERNAME!!");
            }
            if(idPassword.getText().equals("")){
                JOptionPane.showMessageDialog(null,"MOHON ISI PASSWORD!!");
            }
            if(alamat.getText().equals("")){
                JOptionPane.showMessageDialog(null,"MOHON ISI ALAMAT!!");
            }
            if(telp.getText().equals("")){
                JOptionPane.showMessageDialog(null,"MOHON ISI TELEPON!!");
            }
            
                try{
            String sql = "INSERT INTO login (username,password,alamat,telp) VALUES ('"+idUsername.getText()+"','"+idPassword.getText()+"','"+alamat.getText()+"','"+telp.getText()+"')";
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Sign Up Succes");
            try {
            // Hide this current window (if this is what you want)
            ((Node)(event.getSource())).getScene().getWindow().hide();
            
            // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLLogin.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Log In");
            stage.show();
            
        } catch (IOException e) {
            System.out.println("Failed to create new Window." + e.getMessage());
        }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

    }

    @FXML
    private void login(ActionEvent event) {
        try{
            ((Node)(event.getSource())).getScene().getWindow().hide();
        // Load the new fxml
            FXMLLoader fxmlLoader = new FXMLLoader();
            fxmlLoader.setLocation(getClass().getResource("FXMLLogin.fxml"));
            Scene scene = new Scene(fxmlLoader.load());
            
            // Create new stage (window), then set the new Scene
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.setTitle("Perpustakaan");
            stage.show();
        }catch(Exception e){
         JOptionPane.showMessageDialog(null, e.getMessage());
        
        }    
           
    }
}

