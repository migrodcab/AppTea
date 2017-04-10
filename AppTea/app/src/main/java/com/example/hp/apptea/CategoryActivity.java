package com.example.hp.apptea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.hp.apptea.data.category.AdapterCategory;
import com.example.hp.apptea.data.category.Category;
import com.example.hp.apptea.data.category.CategoryRepo;
import com.example.hp.apptea.data.type.AdapterType;
import com.example.hp.apptea.data.type.Type;

import java.util.ArrayList;

public class CategoryActivity extends AppCompatActivity implements AdapterView.OnItemClickListener {

    private CategoryRepo categoryRepo = new CategoryRepo(this);

    private ArrayList<Category> categories = new ArrayList<Category>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        ListView lv = (ListView) findViewById(R.id.listCategory);

        Bundle bundle = getIntent().getExtras();
        String typeId=bundle.getString("typeId");

        categories = categoryRepo.getCategoriesByTypeId(typeId);

        AdapterCategory adapter = new AdapterCategory(this, categories);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String categoryId;
        Intent i;

        Category category = (Category) parent.getItemAtPosition(position);
        i = new Intent(this, ItemActivity.class);
        categoryId = category.getId().toString();

        i.putExtra("categoryId", categoryId);

        startActivity(i);
    }
}
