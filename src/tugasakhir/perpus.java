/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tugasakhir;

/**
 *
 * @author Mila
 */
public class perpus {
    public String no, judul, pengarang, tahun, penerbit;
   

    public String getno() {
        return no;
    }

    public String getjudul() {
        return judul;
    }

    public String getpengarang() {
        return pengarang;
    }

    public String gettahun() {
        return tahun;
    }

    public String getpenerbit() {
        return penerbit;
    }

    //method set  
    public void setno(String no) {
        this.no = no;
    }

    public void setjudul(String judul) {
        this.judul = judul;
    }

    public void setkategori(String pengarang) {
        this.pengarang = pengarang;
    }

    public void settahun(String tahun) {
        this.tahun = tahun;
    }

    public void setpenerbit(String penerbit) {
        this.penerbit = penerbit;
    }
}
