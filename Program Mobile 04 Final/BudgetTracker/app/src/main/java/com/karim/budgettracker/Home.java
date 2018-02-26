package com.karim.budgettracker;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class Home extends AppCompatActivity implements View.OnClickListener{

    private FirebaseAuth firebaseAuth;
    private TextView txtUserMail;
    private Button btnLogout;
//    private DatabaseReference databaseReference;
//    private EditText EDUsername, EDTarget;
//    private Button btnSave;

    private DatabaseReference databaseReference;
    private EditText EDUsername, EDTarget;
    private Button btnSave;
    private Button btnExpense;
    private Button btnIncome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
        if (firebaseAuth.getCurrentUser()==null){
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        databaseReference = FirebaseDatabase.getInstance().getReference();
//
//        EDUsername = (EditText) findViewById(R.id.EDUsername);
//        EDTarget = (EditText) findViewById(R.id.EDTarget);
//        btnSave = (Button) findViewById(R.id.btnSaveData);
//        databaseReference = FirebaseDatabase.getInstance().getReference();
        FirebaseUser user = firebaseAuth.getCurrentUser();

        EDUsername = (EditText) findViewById(R.id.EDUsername);
        EDTarget = (EditText) findViewById(R.id.EDTarget);
        btnSave = (Button) findViewById(R.id.btnSave);
        btnLogout = (Button) findViewById(R.id.btnLogout);
        txtUserMail = (TextView) findViewById(R.id.UserEmail);
        txtUserMail.setText("Welcome " + user.getEmail());
        btnExpense = (Button) findViewById(R.id.btnExpense);
        btnIncome = (Button) findViewById(R.id.btnIncome);

        btnLogout.setOnClickListener(this);
        btnExpense.setOnClickListener(this);
        btnIncome.setOnClickListener(this);
        btnSave.setOnClickListener(this);
    }

    private void saveUserInformation(){
        String name = EDUsername.getText().toString().trim();
        Integer target = Integer.parseInt(EDTarget.getText().toString().trim());

        UserInformation userInformation = new UserInformation(name,target);

        FirebaseUser user = firebaseAuth.getInstance().getCurrentUser();
        if(user!=null) {
            databaseReference.child(user.getUid()).setValue(userInformation);
            Toast.makeText(this, "Information saved", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "ERROR", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onClick(View view) {
        if(view==btnLogout){
            FirebaseAuth firebaseAuth = FirebaseAuth.getInstance();
            FirebaseAuth.getInstance().signOut();
            finish();
            startActivity(new Intent(this, LoginActivity.class));
        }

        if(view == btnSave){
            if (TextUtils.isEmpty(EDUsername.getText())){
                Toast.makeText(this, "Please enter your username", Toast.LENGTH_SHORT).show();
            }
            if (TextUtils.isEmpty(EDTarget.getText())){
                Toast.makeText(this, "Please enter your target expense / month", Toast.LENGTH_SHORT).show();
            }
            else{
            saveUserInformation();


            }
        }
        if(view == btnExpense){
            startActivity(new Intent(this, Home2.class));
        }
        if(view == btnIncome){
            startActivity(new Intent(this, Home3.class));
        }
    }
}