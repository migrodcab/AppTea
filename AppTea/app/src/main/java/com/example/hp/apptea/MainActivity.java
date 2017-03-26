package com.example.hp.apptea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.hp.apptea.data.AdapterCategory;
import com.example.hp.apptea.data.Category;
import com.example.hp.apptea.data.CategoryRepo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener  {

    private CategoryRepo categoryRepo = new CategoryRepo(this);

    private ArrayList<Category> categories = new ArrayList<Category>();
    private Button simbolos;
    private Button texto;
    private Button prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView lv = (ListView) findViewById(R.id.list1);

        categories = categoryRepo.getCategories();

        AdapterCategory adapter = new AdapterCategory(this, categories);

        lv.setAdapter(adapter);
        lv.setOnItemClickListener(this);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        String text;
        Intent i;

        Category category = (Category) parent.getItemAtPosition(position);
        i = new Intent(this, Menu.class );
        text = category.getName();
        i.putExtra("text", text);

        startActivity(i);
    }

    /*public void cargaMenuSimbolos(View view) {
        String text;
        Intent i;

        i = new Intent(this, Menu.class );
        text = simbolos.getText().toString();

        i.putExtra("text", text);

        startActivity(i);
    }

    public void cargaMenuTexto(View view) {
        String text;
        Intent i;

        i = new Intent(this, Menu.class );
        text = texto.getText().toString();

        i.putExtra("text", text);

        startActivity(i);
    }

    public void cargaMenuPrueba(View view) {
        String text;
        Intent i;

        i = new Intent(this, Menu.class );
        text = prueba.getText().toString();

        i.putExtra("text", text);

        startActivity(i);
    }*/


}
