package com.example.hp.apptea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

import com.example.hp.apptea.data.item.AdapterItem;
import com.example.hp.apptea.data.item.Item;
import com.example.hp.apptea.data.item.ItemRepo;

import java.util.ArrayList;

public class ItemActivity extends AppCompatActivity {

    private ItemRepo itemRepo = new ItemRepo(this);

    private ArrayList<Item> items = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        ListView lv = (ListView) findViewById(R.id.listItem);

        Bundle bundle = getIntent().getExtras();
        String categoryId=bundle.getString("categoryId");

        items = itemRepo.getItemsByCategoryId(categoryId);

        AdapterItem adapter = new AdapterItem(this, items);

        lv.setAdapter(adapter);
        //lv.setOnItemClickListener(this);
    }
}
