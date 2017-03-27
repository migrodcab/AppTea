package com.example.hp.apptea.data;

import android.content.ContentValues;

import java.util.UUID;

/**
 * Entidad Categoría
 */
public class Type {
    private String id;
    private String name;
    private String pictureUrl;

    public Type(String name, String pictureUrl) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.pictureUrl = pictureUrl;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getPictureUrl() {
        return pictureUrl;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();

        values.put(TypeContract.TypeyEntry.ID, id);
        values.put(TypeContract.TypeyEntry.NAME, name);
        values.put(TypeContract.TypeyEntry.PICTUREURL, pictureUrl);

        return values;
    }
}
