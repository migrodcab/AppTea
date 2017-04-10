package com.example.hp.apptea.data.item;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hp.apptea.data.AppTeaDbHelper;

import java.util.ArrayList;

/**
 * Created by HP on 14/03/2017.
 */
public class ItemRepo {
    private AppTeaDbHelper dbHelper;

    public ItemRepo(Context context) {
        dbHelper = new AppTeaDbHelper(context);
    }

    public ArrayList<Item> getItemsByCategoryId(String categoryId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "Select * From Item i where i.category_id = '" + categoryId+"'";

        ArrayList<Item> items = new ArrayList<Item>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Item item;
                String id, name, picture;

                id = cursor.getString(cursor.getColumnIndex("id"));
                name = cursor.getString(cursor.getColumnIndex("name"));
                picture = cursor.getString(cursor.getColumnIndex("pictureUrl"));
                item = new Item(id, name, picture, categoryId);

                items.add(item);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return items;

    }
}
