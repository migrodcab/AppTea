package com.example.hp.apptea.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class AppTeaDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "AppTea.db";

    public AppTeaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Category ("
                + CategoryContract.CategoryEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + CategoryContract.CategoryEntry.ID + " TEXT NOT NULL,"
                + CategoryContract.CategoryEntry.NAME + " TEXT NOT NULL,"
                + CategoryContract.CategoryEntry.PICTUREURL + " TEXT,"
                + "UNIQUE (" + CategoryContract.CategoryEntry.ID + "))");

        populate(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Category");
        onCreate(db);
    }

    private void populate(SQLiteDatabase sqLiteDatabase) {
        addCategory(sqLiteDatabase, new Category("Texto", "http://www.elecodevaldepenas.es/images/showid/672374"));
        addCategory(sqLiteDatabase, new Category("Dibujos", "https://s-media-cache-ak0.pinimg.com/564x/50/36/ca/5036ca976650c1fb8c7c74a01a41d6c5.jpg"));
        addCategory(sqLiteDatabase, new Category("Imagen", "http://www.cruceroclick.com/admin/archivos/Image/PAISAJES/POLINESIA/Tranquil_Lagoon_Bora_Bora_Island_French_Polynesia.jpg"));
    }

    public long addCategory(SQLiteDatabase db, Category category) {
        return db.insert(
                CategoryContract.CategoryEntry.TABLE_NAME,
                null,
                category.toContentValues());
    }

}
