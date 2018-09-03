package com.example.yurak.helperclient;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.ImageView;

import com.example.yurak.helperclient.Entities.ProductList;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Map;

/**
 * Created by yurak on 25.04.2018.
 */

public class DownloadImageTask extends AsyncTask<String, Void, Bitmap> {

    Map<String, Bitmap> images;
    String url;

    private CallBack callBack;

    public void setCallBack(final CallBack callBack){
        this.callBack = callBack;
    }

    public DownloadImageTask(Map<String, Bitmap> images) {
        this.images = images;
    }

    protected Bitmap doInBackground(String... urls) {
        String urldisplay = urls[0];
        url = urls[0];
        Bitmap mIcon11 = null;
        try {
            InputStream in = new java.net.URL(urldisplay).openStream();
            mIcon11 = BitmapFactory.decodeStream(in);
        } catch (Exception e) {
            Log.e("Error", e.getMessage());
            e.printStackTrace();
        }
        return mIcon11;
    }

    protected void onPostExecute(Bitmap result) {
        images.put(url, result);


        if(images.size() == 10 && callBack != null){
            callBack.updateReady();
        }
    }

    public interface CallBack {
        public void updateReady();
    }
}
