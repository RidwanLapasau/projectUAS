package com.example.tokobuku;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;

public class DetailActivity extends AppCompatActivity {
    public static final String nama="buku";
    public static final String text="text";
    public static final String deskripsi="deskripsi";
    public static final String detail="detail";
    public static final String harga="harga";
    public static final String gambar="null";
    public ImageView imgdata;
    public TextView tvtextdata;
    public TextView tvnamadata;
    public TextView tvdeskripsidata;
    public TextView tvhargadata;
    public TextView tvdetaildata;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView( R.layout.activity_detail );

        tvnamadata=findViewById(R.id.tv_nama);
        tvtextdata=findViewById(R.id.tv_text);
        tvdeskripsidata=findViewById(R.id.tv_deskripsi);
        tvdetaildata=findViewById(R.id.tv_detail);
        tvhargadata=findViewById(R.id.tv_harga);
        imgdata=findViewById(R.id.img_menu);

        String simpannama = getIntent().getStringExtra(nama);
        String simpantext = getIntent().getStringExtra(text);
        String simpandeskripsi = getIntent().getStringExtra(deskripsi);
        String simpanharga = getIntent().getStringExtra(harga);
        String simpandetail = getIntent().getStringExtra(detail);
        String simpangambar = getIntent().getStringExtra(gambar);

        tvnamadata.setText(simpannama);
        tvtextdata.setText(simpantext);
        tvdeskripsidata.setText(simpandeskripsi);
        tvdetaildata.setText(simpandetail);
        tvhargadata.setText(simpanharga);

        Glide
                .with(this)
                .load(simpangambar)
                .centerCrop()
                .into(imgdata);

    }
}
