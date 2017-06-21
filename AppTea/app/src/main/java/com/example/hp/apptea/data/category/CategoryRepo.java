package com.example.hp.apptea.data.category;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.hp.apptea.data.AppTeaDbHelper;
import com.example.hp.apptea.data.type.Type;

import java.util.ArrayList;

/**
 * Created by HP on 14/03/2017.
 */
public class CategoryRepo {
    private AppTeaDbHelper dbHelper;

    public CategoryRepo(Context context) {
        dbHelper = new AppTeaDbHelper(context);
    }

    public ArrayList<Category> getCategoriesByTypeId(String typeId) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "Select * From Category c where c.type_id = '" + typeId+"' order by c.relevance desc";

        ArrayList<Category> categories = new ArrayList<Category>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Category category;
                String id, name, picture;
                int relevance;

                id = cursor.getString(cursor.getColumnIndex("id"));
                name = cursor.getString(cursor.getColumnIndex("name"));
                relevance = Integer.parseInt(cursor.getString(cursor.getColumnIndex("relevance")));
                picture = cursor.getString(cursor.getColumnIndex("pictureUrl"));
                category = new Category(id, name, relevance, picture, typeId);

                categories.add(category);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return categories;

    }
}
