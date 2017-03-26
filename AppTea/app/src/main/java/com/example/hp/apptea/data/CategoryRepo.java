package com.example.hp.apptea.data;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.provider.BaseColumns;

import java.util.ArrayList;

/**
 * Created by HP on 14/03/2017.
 */
public class CategoryRepo {
    private AppTeaDbHelper dbHelper;

    public CategoryRepo(Context context) {
        dbHelper = new AppTeaDbHelper(context);
    }

    public ArrayList<Category> getCategories() {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "Select * From Category";

        ArrayList<Category> categories = new ArrayList<Category>();

        Cursor cursor = db.rawQuery(selectQuery, null);

        if (cursor.moveToFirst()) {
            do {
                Category category;
                String name, picture;

                name = cursor.getString(cursor.getColumnIndex("name"));
                picture = cursor.getString(cursor.getColumnIndex("pictureUrl"));
                category = new Category(name, picture);

                categories.add(category);

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return categories;

    }

    /*public Student getStudentById(int Id){
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        String selectQuery =  "SELECT  " +
                Student.KEY_ID + "," +
                Student.KEY_name + "," +
                Student.KEY_email + "," +
                Student.KEY_age +
                " FROM " + Student.TABLE
                + " WHERE " +
                Student.KEY_ID + "=?";// It's a good practice to use parameter ?, instead of concatenate string

        int iCount =0;
        Student student = new Student();

        Cursor cursor = db.rawQuery(selectQuery, new String[] { String.valueOf(Id) } );

        if (cursor.moveToFirst()) {
            do {
                student.student_ID =cursor.getInt(cursor.getColumnIndex(Student.KEY_ID));
                student.name =cursor.getString(cursor.getColumnIndex(Student.KEY_name));
                student.email  =cursor.getString(cursor.getColumnIndex(Student.KEY_email));
                student.age =cursor.getInt(cursor.getColumnIndex(Student.KEY_age));

            } while (cursor.moveToNext());
        }

        cursor.close();
        db.close();
        return student;
    }*/
}
