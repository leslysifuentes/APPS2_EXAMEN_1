package com.example.exa_1_tabulador;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button b_shuttle, b_ares, b_falcon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b_shuttle = findViewById(R.id.b_shuttle);
        b_ares = findViewById(R.id.b_ares);
        b_falcon = findViewById(R.id.b_falcon);

        b_shuttle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                ShuttleFragment shuttleFragment = new ShuttleFragment();
                ft.replace(R.id.fl_dinamico, shuttleFragment);
                ft.commit();
            }
        });

        b_ares.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                AresFragment aresFragment = new AresFragment();
                ft.replace(R.id.fl_dinamico, aresFragment);
                ft.commit();
            }
        });

        b_falcon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentTransaction ft = getSupportFragmentManager().beginTransaction();
                FalconFragment falconFragment = new FalconFragment();
                ft.replace(R.id.fl_dinamico, falconFragment);
                ft.commit();

            }
        });

    }
}