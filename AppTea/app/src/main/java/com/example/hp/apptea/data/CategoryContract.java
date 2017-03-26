package com.example.hp.apptea.data;

import android.provider.BaseColumns;

/**
 * Created by HP on 14/03/2017.
 */
public class CategoryContract {

    public static abstract class CategoryEntry implements BaseColumns{
        public static final String TABLE_NAME ="category";

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String PICTUREURL = "pictureUrl";
    }
}
