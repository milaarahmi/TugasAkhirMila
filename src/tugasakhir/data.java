/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;
import javafx.beans.property.StringProperty;
import javafx.beans.property.SimpleStringProperty;
/**
 *
 * @author Mila
 */
public class data {
   private final StringProperty no;
    private final StringProperty pengarang;
    private final StringProperty judul;
    private final StringProperty tahun;
    private final StringProperty penerbit;
  
    public data(String no, String pengarang, String judul, String tahun, String penerbit){
        this.no = new SimpleStringProperty(no);
        this.pengarang = new SimpleStringProperty(pengarang);
        this.judul = new SimpleStringProperty(judul);
        this.tahun = new SimpleStringProperty(tahun);
        this.penerbit = new SimpleStringProperty(penerbit);
    }
    public String getNo(){
        return no.get();
    }
    
    public String getPengarang(){
        return pengarang.get();
    }
    
    public String getNoJudul(){
        return judul.get();
    }
    
    public String getTahun(){
        return tahun.get();
    }
    
    public String getPenerbit(){
        return penerbit.get();
    }
    
    
    public void setNo(String value){
        no.set(value);
    }
    
    public void setPengarang(String value){
        pengarang.set(value);
    }
    
    public void setJudul(String value){
        judul.set(value);
    }
    
    public void setTahun(String value){
        tahun.set(value);
    }
    
    public void setPenerbit(String value){
        penerbit.set(value);
    }
    
    public StringProperty noProperty(){
        return no;
    }
    
    public StringProperty pengarangProperty(){
        return pengarang;
    }
    
    public StringProperty judulProperty(){
        return judul;
    }
    
    public StringProperty tahunProperty(){
        return tahun;
    }
    
    public StringProperty penerbitProperty(){
        return penerbit;
    }
}

