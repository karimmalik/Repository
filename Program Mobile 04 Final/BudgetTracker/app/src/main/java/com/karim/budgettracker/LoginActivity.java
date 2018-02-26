package com.karim.budgettracker;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText EDEmail;
    private EditText EDpassword;
    private Button btnLogin;
    private TextView txtToRegister;

    private ProgressDialog progressDialog;
    private FirebaseAuth firebaseAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        firebaseAuth = FirebaseAuth.getInstance();

        if(firebaseAuth.getCurrentUser()!= null){
            finish();
                startActivity(new Intent(getApplicationContext(), Home.class));
        }

        progressDialog = new ProgressDialog(this);

        EDEmail= (EditText)findViewById(R.id.EDEmail);
        EDpassword= (EditText)findViewById(R.id.EDPassword);
        btnLogin= (Button) findViewById(R.id.btnLogin);
        txtToRegister= (TextView)findViewById(R.id.txtToRegister);

        btnLogin.setOnClickListener(this);
        txtToRegister.setOnClickListener(this);
    }

    private void userLogin(){
        String email = EDEmail.getText().toString().trim();
        String password = EDpassword.getText().toString().trim();

        if(TextUtils.isEmpty(email)){
            Toast.makeText(this, "Please enter your email address", Toast.LENGTH_SHORT).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "Please enter your password", Toast.LENGTH_SHORT).show();
            return;
        }

        progressDialog.setMessage("Logging please wait");
        progressDialog.show();

        firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        progressDialog.dismiss();
//                        finish();
                        if(task.isSuccessful()){
                            startActivity(new Intent(getApplicationContext(), Home.class));
                            progressDialog.dismiss();
                        }else{
                            Toast.makeText(LoginActivity.this, "register fail", Toast.LENGTH_SHORT).show();
                            progressDialog.dismiss();
                        }
                    }
                });
    }

    @Override
    public void onClick(View view) {
        if(view == btnLogin){
            userLogin();
        }
        if (view == txtToRegister){
            finish();
            startActivity(new Intent(this, MainActivity.class));
        }
    }
}
