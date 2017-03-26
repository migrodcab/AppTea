package com.example.hp.apptea.data;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.os.AsyncTask;
import android.os.StrictMode;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.hp.apptea.R;
import com.example.hp.apptea.utils.DownloadImageTask;
import com.example.hp.apptea.utils.ImageMethods;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.ArrayList;

/**
 * Created by HP on 16/03/2017.
 */
public class AdapterCategory extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<Category> categories;

    public AdapterCategory (Activity activity, ArrayList<Category> categories) {
        this.activity = activity;
        this.categories = categories;
    }

    @Override
    public int getCount() {
        return categories.size();
    }

    @Override
    public Object getItem(int arg0) {
        return categories.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void clear() {
        categories.clear();
    }


    public Object getCategory(int arg0) {
        return categories.get(arg0);
    }

    public long getCategoryId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_category, null);
        }

        Category dir = categories.get(position);

        TextView title = (TextView) v.findViewById(R.id.category);
        title.setText(dir.getName());

        ImageView image = (ImageView) v.findViewById(R.id.imageView);
        new ImageMethods().loadImageUrl(image, dir.getPictureUrl());

        //new DownloadImageTask((ImageView) v.findViewById(R.id.imageView)).execute(dir.getPictureUrl());


        return v;
    }
}