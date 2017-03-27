package com.example.hp.apptea.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

/**
 * Created by HP on 14/03/2017.
 */
public class TypeRepo {
    private AppTeaDbHelper dbHelper;

    public TypeRepo(Context context) {
        dbHelper = new AppTeaDbHelper(context);
    }

    public ArrayList<Type> getTypes() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery = "Select * From Type";

        ArrayList<Type> types = new ArrayList<Type>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Type type;
                String name, picture;

                name = cursor.getString(cursor.getColumnIndex("name"));
                picture = cursor.getString(cursor.getColumnIndex("pictureUrl"));
                type = new Type(name, picture);

                types.add(type);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return types;

    }
}
