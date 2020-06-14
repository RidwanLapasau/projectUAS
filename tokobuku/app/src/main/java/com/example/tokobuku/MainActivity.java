package com.example.tokobuku;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
private MenuAdapter menuAdapter;
private RecyclerView recyclerView;
private ArrayList<menu> menus;
int jumpdata;
private RequestQueue requestQueue;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.rv_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        menus=new ArrayList<>();
        requestQueue= Volley.newRequestQueue(this);
        parseJSON();


    }



    private void parseJSON() {
        String url="https://tokobuku160010280.000webhostapp.com/koneksi.php";
        JsonArrayRequest request= new JsonArrayRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONArray>() {
                    @Override
                    public void onResponse(JSONArray response) {
                        jumpdata = response.length();
                        try {
                            for (int i = 0; i < jumpdata; i++) {
                                JSONObject data = response.getJSONObject(i);
                                String gambarmenu = data.getString("gambar");
                                String namamenu = data.getString("buku");
                                String hargamenu = data.getString("harga");
                                String textmenu = data.getString("text");
                                String deskripsimenu = data.getString("deskripsi");
                                String detailmenu = data.getString("detail");
                                menus.add(new menu(namamenu, hargamenu, gambarmenu,textmenu,deskripsimenu,detailmenu));
                            }
                            menuAdapter = new MenuAdapter(MainActivity.this, menus);
                            recyclerView.setAdapter(menuAdapter);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
    });
        requestQueue.add(request);
    }
}