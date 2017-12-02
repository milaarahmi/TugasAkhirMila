/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.net.URL;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javax.swing.JOptionPane;

/**
 * FXML Controller class
 *
 * @author Mila
 */
public class PinjamBukuController implements Initializable {

    @FXML
    private TableView<data> tabel;
    @FXML
    private TableColumn<data, String> noID;
    @FXML
    private TableColumn<data, String> pengarangID;
    @FXML
    private TableColumn<data, String> judulID;
    @FXML
    private TableColumn<data, String> tahunID;
    @FXML
    private TableColumn<data, String> penerbitID;
    @FXML
    private JFXButton baca;
    @FXML
    private JFXButton reset1;
    @FXML
    private JFXButton menu;
    private ObservableList<data>data;
    private koneksi dc;
    private JFXTextField no;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    

    @FXML
    private void baca(ActionEvent event) {
        Connection con;
        Statement stat;

        koneksi DB = new koneksi();
        DB.config();
        con = DB.con;
        stat = (Statement) DB.stm;
        try{
            data = FXCollections.observableArrayList();
            
            ResultSet rs = con.createStatement().executeQuery("SELECT * FROM perpus");
            while (rs.next()){
                data.add(new data(rs.getString(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5)));
            }
        }catch(SQLException ex){
            System.err.println("Error"+ex);
        }
        
        noID.setCellValueFactory(new PropertyValueFactory<>("no"));
        pengarangID.setCellValueFactory(new PropertyValueFactory<>("pengarang"));
        judulID.setCellValueFactory(new PropertyValueFactory<>("judul"));
        tahunID.setCellValueFactory(new PropertyValueFactory<>("tahun"));
        penerbitID.setCellValueFactory(new PropertyValueFactory<>("penerbit"));
        

        tabel.setItems(null);
        tabel.setItems(data);
  }

    @FXML
    private void hapus(ActionEvent event) {
        try{
            data val = tabel.getSelectionModel().getSelectedItem();
            String sql= "DELETE FROM perpus WHERE no_buku='"+val.getNo()+"'";
            System.out.println(sql);
            java.sql.Connection conn=(Connection)config.configDB();
            java.sql.PreparedStatement pst=conn.prepareStatement(sql);
            pst.execute();
            JOptionPane.showMessageDialog(null, "Peminjaman Succes");
            baca(event);
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Peminjaman Gagal"+ no);
        }

    }

    @FXML
    private void menu(ActionEvent event) {
        try{
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
        }catch(Exception e){
         JOptionPane.showMessageDialog(null, e.getMessage());
        
        }    
    }
    
}
