package com.example.hp.apptea.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.example.hp.apptea.data.category.Category;
import com.example.hp.apptea.data.category.CategoryContract;
import com.example.hp.apptea.data.item.ItemContract;
import com.example.hp.apptea.data.type.Type;
import com.example.hp.apptea.data.type.TypeContract;

public class AppTeaDbHelper extends SQLiteOpenHelper {

    public static final int DATABASE_VERSION = 2;
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
                + "UNIQUE (" + CategoryContract.CategoryEntry.ID + "))");

        sqLiteDatabase.execSQL("CREATE TABLE Item ("
                + ItemContract.ItemEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ItemContract.ItemEntry.NAME + " TEXT NOT NULL,"
                + ItemContract.ItemEntry.PICTUREURL + " TEXT,"
                + ItemContract.ItemEntry.CATEGORY_ID + " INTEGER,"
                + "FOREIGN KEY("+ItemContract.ItemEntry.CATEGORY_ID+") REFERENCES Type("+CategoryContract.CategoryEntry.ID+"),"
                + "UNIQUE (" + ItemContract.ItemEntry.ID + "))");

        populate(sqLiteDatabase);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Type");
        db.execSQL("DROP TABLE IF EXISTS Category");
        db.execSQL("DROP TABLE IF EXISTS Item");
        onCreate(db);
    }

    private void populate(SQLiteDatabase sqLiteDatabase) {
        addType(sqLiteDatabase, new Type("1", "Texto", "palabras.jpeg"));
        addType(sqLiteDatabase, new Type("2","Dibujos", "dibujos.jpg"));
        addType(sqLiteDatabase, new Type("3","Imagen", "imagen.jpg"));

        addCategory(sqLiteDatabase,"4", "Colegio", "colegio.jpg", "3");
        addCategory(sqLiteDatabase,"5", "Familia", "familia.jpg", "3");
        addCategory(sqLiteDatabase,"6", "Casa", "casa.jpg", "3");

        addItem(sqLiteDatabase,"7", "Pizarra", "pizarra.jpg", "4");
        addItem(sqLiteDatabase,"8", "Pupitre", "pupitre.jpg", "4");
        addItem(sqLiteDatabase,"9", "Estuche", "estuche.jpg", "4");
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

    public void addItem(SQLiteDatabase db, String id, String name, String url, String categoryId) {
        db.execSQL("INSERT INTO Item (id, name, pictureUrl, category_id) VALUES('"+id+"', '"+name+"', '"+url+"', '"+categoryId+"')");
    }
}
