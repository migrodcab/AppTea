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
                + CategoryContract.CategoryEntry.RELEVANCE + " INTEGER,"
                + CategoryContract.CategoryEntry.PICTUREURL + " TEXT,"
                + CategoryContract.CategoryEntry.TYPE_ID + " INTEGER,"
                + "FOREIGN KEY("+CategoryContract.CategoryEntry.TYPE_ID+") REFERENCES Type("+TypeContract.TypeyEntry.ID+"),"
                + "UNIQUE (" + CategoryContract.CategoryEntry.ID + "),"
                + "CONSTRAINT " + CategoryContract.CategoryEntry.RELEVANCE + "_Ck CHECK (" + CategoryContract.CategoryEntry.RELEVANCE
                + " IN (1,2,3,4,5,6,7,8,9,10)))");

        sqLiteDatabase.execSQL("CREATE TABLE Item ("
                + ItemContract.ItemEntry.ID + " INTEGER PRIMARY KEY AUTOINCREMENT,"
                + ItemContract.ItemEntry.NAME + " TEXT NOT NULL,"
                + ItemContract.ItemEntry.RELEVANCE + " INTEGER,"
                + ItemContract.ItemEntry.PICTUREURL + " TEXT,"
                + ItemContract.ItemEntry.CATEGORY_ID + " INTEGER,"
                + "FOREIGN KEY("+ItemContract.ItemEntry.CATEGORY_ID+") REFERENCES Type("+ItemContract.ItemEntry.ID+"),"
                + "UNIQUE (" + ItemContract.ItemEntry.ID + "),"
                + "CONSTRAINT " + ItemContract.ItemEntry.RELEVANCE + "_Ck CHECK (" + ItemContract.ItemEntry.RELEVANCE
                + " IN (1,2,3,4,5,6,7,8,9,10)))");

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

        addCategory(sqLiteDatabase,"4", "Colegio", 9 , "colegio.jpg", "3");
        addCategory(sqLiteDatabase,"5", "Familia", 10 , "familia.jpg", "3");
        addCategory(sqLiteDatabase,"6", "Casa", 8 , "casa.jpg", "3");

        addItem(sqLiteDatabase,"7", "Pizarra", 8, "pizarra.jpg", "4");
        addItem(sqLiteDatabase,"8", "Pupitre", 2, "pupitre.jpg", "4");
        addItem(sqLiteDatabase,"9", "Estuche", 4, "estuche.jpg", "4");
    }

    public long addType(SQLiteDatabase db, Type type) {
        return db.insert(
                TypeContract.TypeyEntry.TABLE_NAME,
                null,
                type.toContentValues());
    }

    public void addCategory(SQLiteDatabase db, String id, String name, int relevance, String url, String typeId) {
        db.execSQL("INSERT INTO Category (id, name, relevance, pictureUrl, type_id) VALUES('"+id+"', '"+name+"', "+relevance+", '"+ url+"', '"+typeId+"')");
    }

    public void addItem(SQLiteDatabase db, String id, String name, int relevance, String url, String categoryId) {
        db.execSQL("INSERT INTO Item (id, name, relevance, pictureUrl, category_id) VALUES('"+id+"', '"+name+"', "+relevance+", '"+ url+"', '"+categoryId+"')");
    }
}
