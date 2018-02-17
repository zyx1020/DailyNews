package com.xingxing.android.dailynews;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by ZHOU on 2/17/18.
 */

public class ImageLoadTask extends AsyncTask<String,Void,Bitmap> {
    private ImageView imageView;
    public ImageLoadTask(ImageView imageView) {
        this.imageView = imageView;
    }
    @Override
    protected Bitmap doInBackground(String...params) {
        URL url = null;
        HttpURLConnection conn = null;
        try {
            url = new URL(params[0]);
            conn = (HttpURLConnection) url.openConnection();
            conn.connect();
            InputStream inputStream = conn.getInputStream();
            if (inputStream != null) {
                return BitmapFactory.decodeStream(inputStream);
            }
        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    protected void onPostExecute(Bitmap imgBitmap) {
//        System.out.println("the bitmap is" + imgBitmap);
        Bitmap compressedImgBitmap = Bitmap.createScaledBitmap(imgBitmap, 80, 80, false);
        imageView.setImageBitmap(compressedImgBitmap);
    }
}
