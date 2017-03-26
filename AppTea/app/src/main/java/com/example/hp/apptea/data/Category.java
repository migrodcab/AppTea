package com.example.hp.apptea.data;

import android.content.ContentValues;

import java.util.UUID;

/**
 * Entidad Categoría
 */
public class Category {
    private String id;
    private String name;
    private String pictureUrl;

    public Category(String name, String pictureUrl) {
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

        values.put(CategoryContract.CategoryEntry.ID, id);
        values.put(CategoryContract.CategoryEntry.NAME, name);
        values.put(CategoryContract.CategoryEntry.PICTUREURL, pictureUrl);

        return values;
    }
}
