package com.example.hp.apptea.data;

import android.provider.BaseColumns;

/**
 * Created by HP on 14/03/2017.
 */
public class TypeContract {

    public static abstract class TypeyEntry implements BaseColumns{
        public static final String TABLE_NAME ="type";

        public static final String ID = "id";
        public static final String NAME = "name";
        public static final String PICTUREURL = "pictureUrl";
    }
}
