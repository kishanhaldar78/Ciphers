package com.example.kishan.ciphers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class Msg_disp extends AppCompatActivity {
String msg1,msg2;
    ActionBar actionBar;
    TextView t3,t4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_msg_disp);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        t3=(TextView)findViewById(R.id.tv3);
        t4=(TextView)findViewById(R.id.tv4);

        Bundle extras = getIntent().getExtras();
        msg1 = extras.getString("msg1");
        msg2=extras.getString("msg2");
        t3.setText(msg1);
        t4.setText(msg2);


    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void share(View view) {
        Intent intent=new Intent(Intent.ACTION_SEND);
        intent.setType("text/plain");
        intent.putExtra(intent.EXTRA_TEXT,msg2);
        startActivity(intent);

    }

    public void onBackPressed()
    {
            Intent intent = new Intent(Intent.ACTION_MAIN);
            intent.addCategory(Intent.CATEGORY_HOME);
            intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
    }

    public void main(View view) {
        Intent i=new Intent(this,Main_menu.class);
        startActivity(i);
    }
}
