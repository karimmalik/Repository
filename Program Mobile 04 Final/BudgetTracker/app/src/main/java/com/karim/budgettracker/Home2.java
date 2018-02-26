package com.karim.budgettracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Home2 extends AppCompatActivity{

    EditText EDTotal;
    Spinner SpinnerCat;
    Button btnSaveData;

    ListView listViewIncome;
    DatabaseReference databaseIncome;

    List<Income> incomeList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);

        databaseIncome = FirebaseDatabase.getInstance().getReference("incomes");

        EDTotal = (EditText) findViewById(R.id.EDTotal);
        SpinnerCat = (Spinner) findViewById(R.id.SpinnerCat);
        btnSaveData = (Button) findViewById(R.id.btnSaveData);
        listViewIncome = (ListView) findViewById(R.id.listViewIncome);
        btnSaveData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpense();
            }
        });
        incomeList = new ArrayList<>();
    }
    private void addExpense(){

        Long total =Long.parseLong(EDTotal.getText().toString().trim());
        String category = SpinnerCat.getSelectedItem().toString();

        String incomeId = databaseIncome.push().getKey();
        Income income = new Income(incomeId, category, total);
        databaseIncome.child(incomeId).setValue(income);

        Toast.makeText(this, "Information Saved", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseIncome.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                incomeList.clear();
                for (DataSnapshot incomeSnapshoot: dataSnapshot.getChildren()){
                    Income income = incomeSnapshoot.getValue(Income.class);
                    incomeList.add(income);
                }
                IncomeList adapter = new IncomeList(Home2.this, incomeList);
                listViewIncome.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }
}
