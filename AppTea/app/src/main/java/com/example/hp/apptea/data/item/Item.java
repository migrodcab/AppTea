package com.example.hp.apptea.data.item;

import android.content.ContentValues;

public class Item {
    private String id;
    private String name;
    private String pictureUrl;
    private String categoryId;


    public Item(String id, String name, String pictureUrl, String categoryId) {
        this.id = id;
        this.name = name;
        this.pictureUrl = pictureUrl;
        this.categoryId = categoryId;
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

    public String getCategoryId() { return categoryId; }

    public ContentValues toContentValues() {
        ContentValues values = new ContentValues();

        values.put(ItemContract.ItemEntry.ID, id);
        values.put(ItemContract.ItemEntry.NAME, name);
        values.put(ItemContract.ItemEntry.PICTUREURL, pictureUrl);
        values.put(ItemContract.ItemEntry.CATEGORY_ID, categoryId);

        return values;
    }
}
