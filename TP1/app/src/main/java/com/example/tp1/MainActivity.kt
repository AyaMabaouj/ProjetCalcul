package com.example.tp1

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        b = findViewById(R.id.count);
        t = findViewById(R.id.view);
        tt = findViewById(R.id.toast);
        final int[] i = {0};
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i[0]++;
                t.setText(String.valueOf(i[0]));
            }
        });

        tt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast toast= Toast. makeText(getApplicationContext(), R.string.hw,Toast. LENGTH_SHORT);
                toast. show();
            }
        });

    }
}