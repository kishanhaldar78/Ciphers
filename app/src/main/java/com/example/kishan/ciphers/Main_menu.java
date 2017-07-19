package com.example.kishan.ciphers;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class Main_menu extends AppCompatActivity {
 ActionBar actionBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
    }

    public void encrypt(View view) {
        Intent i=new Intent(this,Msg_pass.class);
        i.putExtra("msg","Enter your Encryption Message ");
        i.putExtra("msg1","Encrypt");
        startActivity(i);
    }

    public void decrypt(View view) {
        Intent i=new Intent(this,Msg_pass.class);
        i.putExtra("msg","Enter your Decryption Message ");
        i.putExtra("msg1","Decrypt");
        startActivity(i);
    }

    public void onBackPressed()
    {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

}
