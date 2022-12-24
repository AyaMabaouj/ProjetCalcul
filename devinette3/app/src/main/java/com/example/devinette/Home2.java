package com.example.devinette;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Home2 extends AppCompatActivity {
    Button entrer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        entrer = findViewById(R.id.btnEntrerH);

        entrer.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent i1 = new Intent(Home2.this, GameHard2.class);
                startActivity(i1);
               /* Intent i2 = new Intent(MainActivity.this,ListActivity.class);
                i2.putExtra("nom", nom.getText().toString());
                i2.putExtra("prenom", nom.getText().toString());
                startActivity(i2);*/
            }});
    }
    }
