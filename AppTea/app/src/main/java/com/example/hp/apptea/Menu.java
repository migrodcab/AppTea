package com.example.hp.apptea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button = (Button) findViewById(R.id.button);

        Bundle bundle = getIntent().getExtras();
        String dato=bundle.getString("text");

        button.setText(dato);

    }

    public void salir(View v) {
        finish();
    }
}
