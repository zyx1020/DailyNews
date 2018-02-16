package com.xingxing.android.dailynews;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

/**
 * Created by ZHOU on 2/15/18.
 */

public class OptionMenuActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
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
                urlToFetchFrom = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=9fcc5d04d4964e3295098e985ced26d5";
                break;
            case R.id.tech_news:
                urlToFetchFrom = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=9fcc5d04d4964e3295098e985ced26d5";
                break;
            case R.id.music_news:
                urlToFetchFrom = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=9fcc5d04d4964e3295098e985ced26d5";
                break;
            case R.id.sport_news:
                urlToFetchFrom = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=9fcc5d04d4964e3295098e985ced26d5";
                break;
            case R.id.health_news:
                urlToFetchFrom = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=9fcc5d04d4964e3295098e985ced26d5";
                break;
            default:
                urlToFetchFrom = "https://newsapi.org/v2/top-headlines?country=us&category=business&apiKey=9fcc5d04d4964e3295098e985ced26d5";
                break;
        }
        // TODO

        return super.onOptionsItemSelected(item);
    }
}
