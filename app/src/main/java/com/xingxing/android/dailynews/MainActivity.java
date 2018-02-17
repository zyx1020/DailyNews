package com.xingxing.android.dailynews;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;
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

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {
    RequestQueue requestQueue;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolBar);
        toolbar.setTitle("NNEEWW");
        toolbar.inflateMenu(R.menu.menu_main);

        requestQueue = Volley.newRequestQueue(this);//this means this activity
        //auto load when app start
        String initUrl = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=9fcc5d04d4964e3295098e985ced26d5";
        jsonParse(initUrl);

    }

    public boolean onCreateOptionMenu(Menu menu) {
        // inflate the menu; add items to action bar if present
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle action bar clicks.
        int id = item.getItemId();
        String urlToFetchFrom = "";
        switch (id) {
            case R.id.top_news:
                showMsg("TTop");
                urlToFetchFrom = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=9fcc5d04d4964e3295098e985ced26d5";
                break;
            case R.id.tech_news:
                showMsg("TTech");
                urlToFetchFrom = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=9fcc5d04d4964e3295098e985ced26d5";
                break;
            case R.id.music_news:
                showMsg("MMusic");
                urlToFetchFrom = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=9fcc5d04d4964e3295098e985ced26d5";
                break;
            case R.id.sport_news:
                showMsg("SSport");
                urlToFetchFrom = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=9fcc5d04d4964e3295098e985ced26d5";
                break;
            case R.id.health_news:
                showMsg("HHealth");
                urlToFetchFrom = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=9fcc5d04d4964e3295098e985ced26d5";
                break;
        }
        jsonParse(urlToFetchFrom);
        return onOptionsItemSelected(item);
    }

    public void jsonParse(String url) {
        JsonObjectRequest request = new JsonObjectRequest(Request.Method.GET, url, null, new Response.Listener<JSONObject>() {
            @Override
            public void onResponse(JSONObject response) {
                try {
                    JSONArray articles = response.getJSONArray("articles");
                    List<String[]> newsList = new ArrayList<>();
                    for (int i = 0; i < articles.length(); i++) {
                        JSONObject article = articles.getJSONObject(i);
                        String[] newsDetails = new String[] {article.getString("title"), article.getString("description"), article.getString("urlToImage")};
                        newsList.add(newsDetails);
                    }
                    showNews(newsList);

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

    public void showNews(List<String[]> newsList) {
        CustomAdapter customAdapter = new CustomAdapter(this, newsList);
        ListView newsListView = (ListView) findViewById(R.id.newsList);
        newsListView.setAdapter(customAdapter);
    }

    private void showMsg(String msg) {
        Toast toast = Toast.makeText(getApplicationContext(), msg, Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.BOTTOM | Gravity.CENTER, 0, 0);
        toast.show();
    }
}