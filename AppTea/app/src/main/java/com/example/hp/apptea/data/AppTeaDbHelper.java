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
        sqLiteDatabase.execSQL("CREATE TABLE Type ("
                + TypeContract.TypeyEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TypeContract.TypeyEntry.ID + " TEXT NOT NULL,"
                + TypeContract.TypeyEntry.NAME + " TEXT NOT NULL,"
                + TypeContract.TypeyEntry.PICTUREURL + " TEXT,"
                + "UNIQUE (" + TypeContract.TypeyEntry.ID + "))");

        populate(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Type");
        onCreate(db);
    }

    private void populate(SQLiteDatabase sqLiteDatabase) {
        addType(sqLiteDatabase, new Type("Texto", "http://www.elecodevaldepenas.es/images/showid/672374"));
        addType(sqLiteDatabase, new Type("Dibujos", "https://s-media-cache-ak0.pinimg.com/564x/50/36/ca/5036ca976650c1fb8c7c74a01a41d6c5.jpg"));
        addType(sqLiteDatabase, new Type("Imagen", "http://www.cruceroclick.com/admin/archivos/Image/PAISAJES/POLINESIA/Tranquil_Lagoon_Bora_Bora_Island_French_Polynesia.jpg"));
    }

    public long addType(SQLiteDatabase db, Type type) {
        return db.insert(
                TypeContract.TypeyEntry.TABLE_NAME,
                null,
                type.toContentValues());
    }

}
