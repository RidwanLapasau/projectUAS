package com.example.tokobuku;

public class menu {
    private String nama;
    private String harga;
    private String gambar;
    private String deskripsi;
    private String text;
    private String detail;

    public menu(String datanama, String dataharga, String datagambar,String datadeskripsi,String datatext,String datadetail){
        nama = datanama;
        harga = dataharga;
        gambar = datagambar;
        deskripsi = datadeskripsi;
        text = datatext;
        detail = datadetail;
    }

    public String getNama() {
        return nama;
    }

    public String getHarga() {
        return harga;
    }

    public String getGambar() {
        return gambar;
    }

    public String getDeskripsi() {
        return deskripsi;
    }

    public String getText() {
        return text;
    }

    public String getDetail() {
        return detail;
    }
}
