package com.xingxing.android.dailynews;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by ZHOU on 2/15/18.
 */

public class NewsArrayAdapter extends ArrayAdapter<String> {
    private final Context context;
    private final String[] titles;
    private final String[] descriptions;

    public NewsArrayAdapter(Context context, String[] values, String[] descriptions) {
        super(context, R.layout.singlenews_layout, values);
        this.context = context;
        this.titles = values;
        this.descriptions = descriptions;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View rowView = inflater.inflate(R.layout.singlenews_layout,parent,false);
        ImageView image_view = (ImageView) rowView.findViewById(R.id.img_view);
        TextView title_view = (TextView) rowView.findViewById(R.id.news_title);
        TextView description_view = (TextView) rowView.findViewById(R.id.news_description);
        title_view.setText(titles[position]);
        description_view.setText(descriptions[position]);
        i
    }
}
