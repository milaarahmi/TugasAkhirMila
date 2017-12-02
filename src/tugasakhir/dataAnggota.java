/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 *
 * @author Mila
 */
public class dataAnggota {
    private final StringProperty idUsername;
    private final StringProperty idPassword;
    private final StringProperty alamat;
    private final StringProperty telp;
    
    public dataAnggota(String idUsername, String idPassword, String alamat, String telp){
       this.idUsername = new SimpleStringProperty(idUsername);
        this.idPassword = new SimpleStringProperty(idPassword);
        this.alamat = new SimpleStringProperty(alamat);
        this.telp = new SimpleStringProperty(telp);
    }
    public String getIdUsername(){
        return idUsername.get();
    }
    
    public String getIdPassword(){
        return idPassword.get();
    }
    
    public String getAlamat(){
        return alamat.get();
    }
    
    public String getTelp(){
        return telp.get();
    }
    public void setIdUsername(String value){
        idUsername.set(value);
    }
    
    public void setIdPassword(String value){
        idPassword.set(value);
    }
    
    public void setAlamat(String value){
        alamat.set(value);
    }
    
    public void setTelp(String value){
        telp.set(value);
    }
    public StringProperty IdUsernameProperty(){
        return idUsername;
    }
    
    public StringProperty IdPasswordProperty(){
        return idPassword;
    }
    
    public StringProperty AlamatProperty(){
        return alamat;
    }
    
    public StringProperty TelpProperty(){
        return telp;
    }
}