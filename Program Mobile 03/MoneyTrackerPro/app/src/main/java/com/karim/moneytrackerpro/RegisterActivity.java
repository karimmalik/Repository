package com.karim.moneytrackerpro;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {
//    databaseHelper databaseHelperr = new databaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        final EditText Semail = (EditText) findViewById(R.id.email);
        final EditText Susername = (EditText) findViewById(R.id.username);
        final EditText Spassword = (EditText) findViewById(R.id.password);
        final Button SbtnRegister = (Button) findViewById(R.id.btnRegister);
        final TextView StoLogin = (TextView) findViewById(R.id.toLogin);

        StoLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent loginIntent = new Intent(RegisterActivity.this, LoginActivity.class);
                RegisterActivity.this.startActivity(loginIntent);
            }
        });

        SbtnRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final String email = Semail.getText().toString();
                final String username = Susername.getText().toString();
                final String password = Spassword.getText().toString();

//                contoh kasus int
//                final int age = Integer.parseInt(etAge.getText().toString());
                Response.Listener<String> responseListener = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        try {
                            JSONObject jsonResponse = new JSONObject(response);
                            boolean success = jsonResponse.getBoolean("success");

                            if (success) {
                                Intent intent = new Intent(RegisterActivity.this, LoginActivity.class);
                                RegisterActivity.this.startActivity(intent);

                            } else {
                                AlertDialog.Builder builder = new AlertDialog.Builder(RegisterActivity.this);
                                builder.setMessage("Reg Failed")
                                        .setNegativeButton("Retry", null)
                                        .create()
                                        .show();
                            }

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                };

                RegisterRequest registerRequest = new RegisterRequest(email, username, password, responseListener);
                RequestQueue registerQueue = Volley.newRequestQueue(RegisterActivity.this);
                registerQueue.add(registerRequest);
            }
        });
    }
}
