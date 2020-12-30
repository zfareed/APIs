package com.example.apis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.google.gson.Gson;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
  RequestQueue requestQueue;
    ImageView imageView;
    TextView id;
    TextView name;
    TextView email;
    TextView gender;
    TextView mobile;
    TextView home;
    TextView office;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = findViewById(R.id.imageView);
        Glide.with(this).load("https://i.pinimg.com/564x/f1/9e/7c/f19e7cb6acfa9e2778b48f4f15a23aac.jpg").into(imageView);

        requestQueue = Volley.newRequestQueue(this);
        fetchJsonResponse();

        id = findViewById(R.id.idView);
        name = findViewById(R.id.nameView);
        email = findViewById(R.id.emailView);
        gender = findViewById(R.id.genderView);
        mobile = findViewById(R.id.mobileView);
        home = findViewById(R.id.homeView);
        office = findViewById(R.id.officeView);






      }

    private void fetchJsonResponse() {
        // Pass second argument as "null" for GET requests
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, "https://run.mocky.io/v3/27a10eb7-9a0d-4462-b53b-3dea1f1c3d5a", null,       //mocky.io is a free tool for checking API requests
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        Gson gson = new Gson();
                        Users users= gson.fromJson(response.toString(),Users.class);

                        id.setText(users.getUsers().get(0).getId());
                        name.setText(users.getUsers().get(0).getName());
                        email.setText(users.getUsers().get(0).getEmail());
                        gender.setText(users.getUsers().get(0).getGender());
                        mobile.setText(users.getUsers().get(0).getContact().getMobile());
                        home.setText(users.getUsers().get(0).getContact().getHome());
                        office.setText(users.getUsers().get(0).getContact().getOffice());




                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Fareed", "OnError" + error.getMessage());
            }
        });

        requestQueue.add(req);

    }
}