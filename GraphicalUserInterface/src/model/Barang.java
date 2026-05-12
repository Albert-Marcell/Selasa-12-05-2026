/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author user1
 */
public class Barang {
    private String kode;
    private String nama;
    private String umur;
    private int harga;
    private int juara;

    public Barang() {
    }

    public Barang(String kode, String nama, String umur, int harga, int juara) {
        this.kode = kode;
        this.nama = nama;
        this.umur = umur;
        this.harga = harga;
        this.juara = juara;
    }
    

    public String getKode() {
        return kode;
    }

    public void setKode(String kode) {
        this.kode = kode;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public int getJuara() {
        return juara;
    }

    public void setJuara(int juara) {
        this.juara = juara;
    }

    public String getUmur() {
        return umur;
    }

    public void setUmur(String umur) {
        this.umur = umur;
    }
    
    
    public int getKeuntungan(){
        return harga * juara;
    }
}
