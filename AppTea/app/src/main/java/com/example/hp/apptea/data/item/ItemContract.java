package com.example.hp.apptea.data.item;

import android.provider.BaseColumns;


/**
 * Created by HP on 14/03/2017.
 */
public class ItemContract {

    public static abstract class ItemEntry implements BaseColumns{
        public static final String TABLE_NAME ="Item";

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String RELEVANCE = "relevance";
        public static final String PICTUREURL = "pictureUrl";
        public static final String CATEGORY_ID = "category_id";
    }
}
