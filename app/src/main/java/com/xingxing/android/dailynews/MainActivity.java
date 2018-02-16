package com.xingxing.android.dailynews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;


public class MainActivity extends AppCompatActivity {
    private TextView news;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button tops = (Button) findViewById(R.id.top_news);
        Button us = (Button) findViewById(R.id.us_news);
        news = (TextView) findViewById(R.id.contents);

        requestQueue = Volley.newRequestQueue(this);//this means this activity

        tops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                jsonParse();
            }
        });
    }

    private void jsonParse() {
        String url = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=9fcc5d04d4964e3295098e985ced26d5";
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray articles = response.getJSONArray("articles");
                    for (int i = 0; i < articles.length(); i++) {
                        JSONObject aNews = articles.getJSONObject(i);
                        String title = aNews.getString("title");
                        String description = aNews.getString("description");

                        news.append(title + "\n" + description + "\n\n");
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Toast toast = Toast.makeText(getApplicationContext(), "Something wrong happens.....", Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
                toast.show();
            }
        });

        requestQueue.add(request);
    }
}