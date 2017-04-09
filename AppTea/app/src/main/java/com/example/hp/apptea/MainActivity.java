package com.example.hp.apptea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hp.apptea.data.type.AdapterType;
import com.example.hp.apptea.data.type.Type;
import com.example.hp.apptea.data.type.TypeRepo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener  {

    private TypeRepo typeRepo = new TypeRepo(this);

    private ArrayList<Type> types = new ArrayList<Type>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.list1);

        types = typeRepo.getTypes();

        AdapterType adapter = new AdapterType(this, types);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String typeId;
        Intent i;

        Type type = (Type) parent.getItemAtPosition(position);
        i = new Intent(this, Menu.class);
        typeId = type.getId().toString();

        i.putExtra("typeId", typeId);

        startActivity(i);
    }
}
