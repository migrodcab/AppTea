package com.example.hp.apptea.data.item;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.BitmapImageViewTarget;
import com.example.hp.apptea.R;

import java.util.ArrayList;

/**
 * Created by HP on 16/03/2017.
 */
public class AdapterItem extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<Item> items;

    public AdapterItem(Activity activity, ArrayList<Item> items) {
        this.activity = activity;
        this.items = items;
    }

    @Override
    public int getCount() {
        return items.size();
    }

    @Override
    public Object getItem(int arg0) {
        return items.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void clear() {
        items.clear();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_item, null);
        }

        Item dir = items.get(position);

        TextView title = (TextView) v.findViewById(R.id.item);
        title.setText(dir.getName());

        final ImageView image = (ImageView) v.findViewById(R.id.imageView);
        Glide
                .with(activity)
                .load(Uri.parse("file:///android_asset/" + dir.getPictureUrl()))
                .asBitmap()
                .centerCrop()
                .into(new BitmapImageViewTarget(image) {
                    @Override
                    protected void setResource(Bitmap resource) {
                        RoundedBitmapDrawable drawable
                                = RoundedBitmapDrawableFactory.create(activity.getResources(), resource);
                        image.setImageDrawable(drawable);
                    }
                });

        return v;
    }
}