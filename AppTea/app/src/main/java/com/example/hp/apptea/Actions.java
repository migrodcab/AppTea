package com.example.hp.apptea;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Actions extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);

        Button button1 = (Button) findViewById(R.id.button1);
        Button button2 = (Button) findViewById(R.id.button2);
        TextView text = (TextView) findViewById(R.id.textView);

        Bundle bundle = getIntent().getExtras();
        String typeId=bundle.getString("typeId");

        text.setText(typeId);
    }

    public void cargaComunicacion(View view) {
        TextView text = (TextView) findViewById(R.id.textView);
        String typeId;
        Intent i;

        i = new Intent(this, CategoryActivity.class );
        typeId = text.getText().toString();

        i.putExtra("typeId", typeId);

        startActivity(i);
    }


}
