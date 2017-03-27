package com.example.hp.apptea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.example.hp.apptea.data.AdapterType;
import com.example.hp.apptea.data.Type;
import com.example.hp.apptea.data.TypeRepo;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemClickListener  {

    private TypeRepo typeRepo = new TypeRepo(this);

    private ArrayList<Type> types = new ArrayList<Type>();
    private Button simbolos;
    private Button texto;
    private Button prueba;

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
        String text;
        Intent i;

        Type type = (Type) parent.getItemAtPosition(position);
        i = new Intent(this, Menu.class );
        text = type.getName();
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
