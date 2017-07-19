package com.example.kishan.ciphers;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class Msg_pass extends AppCompatActivity {
    ActionBar actionBar;
    TextView tv;
    Button b1;
    EditText e1, e2;
    String msg1, msg2, mymsg, key, output;
    Integer key1, a_num, A_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        actionBar = getSupportActionBar();
        actionBar.setDisplayHomeAsUpEnabled(true);
        setContentView(R.layout.pass_msg);
        tv = (TextView) findViewById(R.id.tv1);
        b1 = (Button) findViewById(R.id.bt);
        e1 = (EditText) findViewById(R.id.et1);
        e2 = (EditText) findViewById(R.id.et2);
        Bundle extras = getIntent().getExtras();
        msg1 = extras.getString("msg");
        msg2 = extras.getString("msg1");
        tv.setText(msg1);
        b1.setText(msg2);

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                this.finish();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onBackPressed() {
        Intent intent = new Intent(Intent.ACTION_MAIN);
        intent.addCategory(Intent.CATEGORY_HOME);
        intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }


    public void result(View view) {
        mymsg = e1.getText().toString();
        key = e2.getText().toString();
        Intent intent = new Intent(this, Msg_disp.class);

        if (mymsg.length() == 0 || key.length() == 0) {
            if (mymsg.length() == 0) {
                e1.setError("Message is required!");
            }
            if (key.length() == 0) {
                e2.setError("Key Value is required!");
            }

        } else {
            key1 = Integer.parseInt(key);

            if (key1 % 26 == 0) {
                if (key1 % 26 == 0) {
                    e2.setError("Try Another Key Value");
                }
            } else {
                a_num = (int) 'a';
                A_num = (int) 'A';
                output = "";
                if (msg2.equals("Encrypt")) {
                    for (int i = 0; i < mymsg.length(); i++) {
                        int cur = (int) mymsg.charAt(i);
                        // check if lowercase or uppercase
                        if (cur >= a_num && cur < a_num + 26) {
                            output += Character.toString
                                    ((char) ((((cur - a_num) + key1) % 26) + a_num));
                        } else if (cur >= A_num && cur < A_num + 26) {
                            output += Character.toString
                                    ((char) ((((cur - A_num) + key1) % 26) + A_num));
                        } else {
                            output += (char) cur;
                        }
                    }
                    intent.putExtra("msg1", "Your Encrypted Message are :");
                    ;
                }

                if (msg2.equals("Decrypt")) {
                    for (int i = 0; i < mymsg.length(); i++) {
                        int cur = (int) mymsg.charAt(i);
                        if (cur >= a_num && cur < a_num + 26) {
                            int check = ((cur - a_num) - key1) % 26;
                            if (check < 0) {
                                output += Character.toString((char) ((check + 26) + a_num));
                            } else {
                                output += Character.toString((char) (check + a_num));
                            }
                        } else if (cur >= A_num && cur < A_num + 26) {
                            int check1 = ((cur - A_num) - key1) % 26;
                            if (check1 < 0) {
                                output += Character.toString((char) ((check1 + 26) + A_num));

                            } else {
                                output += Character.toString((char) (check1 + A_num));
                            }
                        } else {
                            output += (char) cur;
                        }
                    }

                    intent.putExtra("msg1", "Your Decrypted Message are :");
                    ;
                }
                intent.putExtra("msg2", output);
                startActivity(intent);

            }

        }
    }
}
