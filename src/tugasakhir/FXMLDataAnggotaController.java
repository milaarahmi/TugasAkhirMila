/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.Initializable;
import com.jfoenix.controls.JFXButton;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

/**
 * FXML Controller class
 *
 * @author Mila
 */

public class FXMLDataAnggotaController implements Initializable {
 @FXML
    private TableView<dataAnggota> tabel;

    @FXML
    private TableColumn<dataAnggota, String> usernameId;

    @FXML
    private TableColumn<dataAnggota, String> passwordID;

    @FXML
    private TableColumn<dataAnggota, String> alamatID;

    @FXML
    private TableColumn<dataAnggota, String> telpID;

    @FXML
    private JFXButton doto;

    @FXML
    private JFXButton menu;
    private ObservableList<dataAnggota>data5;
    private koneksi dc;
    
    @FXML
    void doto(ActionEvent event) {
        
         Connection con;
        Statement stat;

        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = (Statement) DB.stm;
        try{
            data5 = FXCollections.observableArrayList();
            
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM login");
            while (rs.next()){
                data5.add(new dataAnggota(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4)));
            }
        }catch(SQLException ex){
            System.err.println("Error"+ex);
        }
        
        usernameId.setCellValueFactory(new PropertyValueFactory<>("idUsername"));
        passwordID.setCellValueFactory(new PropertyValueFactory<>("idPassword"));
        alamatID.setCellValueFactory(new PropertyValueFactory<>("alamat"));
        telpID.setCellValueFactory(new PropertyValueFactory<>("telp"));
       
        

        tabel.setItems(null);
        tabel.setItems(data5);


    }

    @FXML
    void menu(ActionEvent event) {

    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
