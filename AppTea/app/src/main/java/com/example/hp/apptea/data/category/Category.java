package com.example.hp.apptea.data.category;

import android.content.ContentValues;

import com.example.hp.apptea.data.type.Type;
import com.example.hp.apptea.data.type.TypeContract;

import java.util.UUID;

public class Category {
    private String id;
    private String name;
    private int relevance;
    private String pictureUrl;
    private String typeId;

    public Category(String id, String name, int relevance, String pictureUrl, String typeId) {
        this.id = id;
        this.name = name;
        this.relevance = relevance;
        this.pictureUrl = pictureUrl;
        this.typeId = typeId;
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

    public int getRelevance() { return relevance; }

    public String getTypeId() {
        return typeId;
    }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();

        values.put(CategoryContract.CategoryEntry.ID, id);
        values.put(CategoryContract.CategoryEntry.NAME, name);
        values.put(CategoryContract.CategoryEntry.RELEVANCE, relevance);
        values.put(CategoryContract.CategoryEntry.PICTUREURL, pictureUrl);
        values.put(CategoryContract.CategoryEntry.TYPE_ID, typeId);

        return values;
    }
}
