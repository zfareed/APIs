package com.example.apis;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.VolleyLog;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;

import org.json.JSONException;
import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
   /* RequestQueue requestQueue;*/
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*requestQueue = Volley.newRequestQueue(this);
        fetchJsonResponse();*/

        imageView = findViewById(R.id.imageView);
        Glide.with(this).load("https://i.pinimg.com/564x/f1/9e/7c/f19e7cb6acfa9e2778b48f4f15a23aac.jpg").into(imageView);





   /* private void fetchJsonResponse() {
        // Pass second argument as "null" for GET requests
        JsonObjectRequest req = new JsonObjectRequest(Request.Method.GET, "https://run.mocky.io/v3/27a10eb7-9a0d-4462-b53b-3dea1f1c3d5a", null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        Log.i("Zain","OnResponse"+response.toString());
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.e("Zain","OnResponse"+error.getMessage());
            }
        });

        requestQueue.add(req);*/

    }
}