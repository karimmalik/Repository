package com.karim.moneytrackerpro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class signup extends AppCompatActivity {
    databaseHelper databaseHelperr = new databaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);
    }

    public void signUpOnClick(View view){
        EditText Semail = (EditText)findViewById(R.id.signup_email);
        EditText Susername = (EditText)findViewById(R.id.signup_username);
        EditText Spassword = (EditText)findViewById(R.id.signup_password);
        EditText Starget = (EditText)findViewById(R.id.signup_target);

        String email = Semail.getText().toString();
        String username = Susername.getText().toString();
        String password = Spassword.getText().toString();
        String target = Starget.getText().toString();

        User user = new User();
        user.setEmail(email);
        user.setUsername(username);
        user.setPassword(password);
        user.setTarget(target);

        databaseHelper.insertUser();
    }
}
