package com.karim.moneytrackerpro;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class mainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView hello = (TextView) findViewById(R.id.hello);

        Intent intent = getIntent();
        String username = intent.getStringExtra("username");

        String message = username + "welcome to your user area";
        hello.setText(message);

    }
}
