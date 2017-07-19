package com.example.kishan.ciphers;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                final Intent mainIntent=new Intent(MainActivity.this,Main_menu.class);
                MainActivity.this.startActivity(mainIntent);
                MainActivity.this.finish();
            }
        },3000);
    }
}
