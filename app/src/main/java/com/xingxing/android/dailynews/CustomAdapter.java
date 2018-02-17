package com.xingxing.android.dailynews;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by ZHOU on 2/16/18.
 */

public class CustomAdapter extends ArrayAdapter {
    //to reference the Activity the ListView is on
    private final Activity context;
    private final List<String[]> newsList;

    //constructor
    public CustomAdapter(Activity context, List<String[]> newsList){
        super(context,R.layout.singlenews_layout, newsList);
        this.context = context;
        this.newsList = newsList;
    }

    //method to populate data into each row
    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();
        View singleNewsView = inflater.inflate(R.layout.singlenews_layout, null, true);

        ImageView imgView = (ImageView) singleNewsView.findViewById(R.id.img_view);
        TextView titleView = (TextView) singleNewsView.findViewById(R.id.news_title);
        TextView descView = (TextView) singleNewsView.findViewById(R.id.news_description);

        final String[] currNews = newsList.get(position);
        // load data into row view
        titleView.setText(currNews[0]);
        descView.setText(currNews[1]);
        // image loading takes much time, so we use doInBackground()
        new ImageLoadTask(imgView).execute(currNews[2]);
        //TODO: image not showing or not visible, but bitmap has produced, why?
        return singleNewsView;
    }
/**
    private Bitmap getBitmapFromURL(String src) {
        try {
            URL url = new URL(src);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            InputStream inputStream = conn.getInputStream();
            return BitmapFactory.decodeStream(inputStream);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            System.out.println("@@@@@@@@@@@@@@@@@@@@@@@@@@@@#############");
        }
        return null;
    }
 */
}
