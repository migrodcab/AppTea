package com.example.hp.apptea.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hp.apptea.data.category.Category;
import com.example.hp.apptea.data.category.CategoryContract;
import com.example.hp.apptea.data.type.Type;
import com.example.hp.apptea.data.type.TypeContract;

public class AppTeaDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "AppTea.db";

    public AppTeaDbHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL("CREATE TABLE Type ("
                + TypeContract.TypeyEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + TypeContract.TypeyEntry.NAME + " TEXT NOT NULL,"
                + TypeContract.TypeyEntry.PICTUREURL + " TEXT,"
                + "UNIQUE (" + TypeContract.TypeyEntry.ID + "))");

        sqLiteDatabase.execSQL("CREATE TABLE Category ("
                + CategoryContract.CategoryEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + CategoryContract.CategoryEntry.NAME + " TEXT NOT NULL,"
                + CategoryContract.CategoryEntry.PICTUREURL + " TEXT,"
                + CategoryContract.CategoryEntry.TYPE_ID + " INTEGER,"
                + "FOREIGN KEY("+CategoryContract.CategoryEntry.TYPE_ID+") REFERENCES Type("+TypeContract.TypeyEntry.ID+"),"
                + "UNIQUE (" + TypeContract.TypeyEntry.ID + "))");

        populate(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Type");
        db.execSQL("DROP TABLE IF EXISTS Category");
        onCreate(db);
    }

    private void populate(SQLiteDatabase sqLiteDatabase) {
        addType(sqLiteDatabase, new Type("1", "Texto", "http://www.elecodevaldepenas.es/images/showid/672374"));
        addType(sqLiteDatabase, new Type("2","Dibujos", "https://s-media-cache-ak0.pinimg.com/564x/50/36/ca/5036ca976650c1fb8c7c74a01a41d6c5.jpg"));
        addType(sqLiteDatabase, new Type("3","Imagen", "http://www.cruceroclick.com/admin/archivos/Image/PAISAJES/POLINESIA/Tranquil_Lagoon_Bora_Bora_Island_French_Polynesia.jpg"));

        addCategory(sqLiteDatabase,"4", "Colegio", "http://www.tribunadelamoraleja.com/fotos/3/sanpa.jpg", "3");
        addCategory(sqLiteDatabase,"5", "Familia", "http://conceptodefinicion.de/wp-content/uploads/2014/07/Familia.jpg", "3");
        addCategory(sqLiteDatabase,"6", "Casa", "http://www.canexel.es/wp-content/uploads/2015/06/casa-de-madera-logrono.jpg", "3");
    }

    public long addType(SQLiteDatabase db, Type type) {
        return db.insert(
                TypeContract.TypeyEntry.TABLE_NAME,
                null,
                type.toContentValues());
    }

    public void addCategory(SQLiteDatabase db, String id, String name, String url, String typeId) {
        db.execSQL("INSERT INTO Category (id, name, pictureUrl, type_id) VALUES('"+id+"', '"+name+"', '"+url+"', '"+typeId+"')");
    }
}
