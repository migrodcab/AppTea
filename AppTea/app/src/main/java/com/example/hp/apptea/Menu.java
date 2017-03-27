package com.example.hp.apptea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        TextView text = (TextView) findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();
        String dato=bundle.getString("text");

        text.setText(dato);

    }


}
