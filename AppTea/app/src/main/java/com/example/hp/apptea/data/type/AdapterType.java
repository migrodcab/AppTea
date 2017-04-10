package com.example.hp.apptea.data.type;

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
import com.example.hp.apptea.utils.ImageMethods;

import java.util.ArrayList;

/**
 * Created by HP on 16/03/2017.
 */
public class AdapterType extends BaseAdapter {
    protected Activity activity;
    protected ArrayList<Type> types;

    public AdapterType(Activity activity, ArrayList<Type> types) {
        this.activity = activity;
        this.types = types;
    }

    @Override
    public int getCount() {
        return types.size();
    }

    @Override
    public Object getItem(int arg0) {
        return types.get(arg0);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    public void clear() {
        types.clear();
    }


    public Object getType(int arg0) {
        return types.get(arg0);
    }

    public long getTypeId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;

        if (convertView == null) {
            LayoutInflater inf = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            v = inf.inflate(R.layout.item_type, null);
        }

        Type dir = types.get(position);

        TextView title = (TextView) v.findViewById(R.id.type);
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