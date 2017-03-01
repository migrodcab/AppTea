package com.example.hp.apptea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button simbolos;
    private Button texto;
    private Button prueba;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        simbolos = (Button)findViewById(R.id.simbolos);
        texto = (Button)findViewById(R.id.texto);
        prueba = (Button)findViewById(R.id.prueba);
    }

    public void cargaMenuSimbolos(View view) {
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
    }


}
