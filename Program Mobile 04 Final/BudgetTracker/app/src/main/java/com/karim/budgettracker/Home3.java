package com.karim.budgettracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
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

public class Home3 extends AppCompatActivity {

    EditText EDTotal2;
    Spinner SpinnerCat2;
    Button btnSaveData2;

    ListView listViewExpense;
    DatabaseReference databaseExpense;

    List<Expense> expenseList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home3);

        databaseExpense = FirebaseDatabase.getInstance().getReference("expenses");

        EDTotal2 = (EditText) findViewById(R.id.EDTotal2);
        SpinnerCat2 = (Spinner) findViewById(R.id.SpinnerCat2);
        btnSaveData2 = (Button) findViewById(R.id.btnSaveData2);
        listViewExpense = (ListView) findViewById(R.id.listViewExpense);
        btnSaveData2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpense();
            }
        });
        expenseList = new ArrayList<>();
    }

    private void addExpense(){

        Long total =Long.parseLong(EDTotal2.getText().toString().trim());
        String category = SpinnerCat2.getSelectedItem().toString();

        String ExpenseId = databaseExpense.push().getKey();
        Expense expense= new Expense(ExpenseId, category, total);
        databaseExpense.child(ExpenseId).setValue(expense);

        Toast.makeText(this, "Information Saved", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();

        databaseExpense.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                expenseList.clear();
                for (DataSnapshot expenseSnapshoot: dataSnapshot.getChildren()){
                    Expense expense = expenseSnapshoot.getValue(Expense.class);
                    expenseList.add(expense);
                }
                ExpenseList adapter = new ExpenseList(Home3.this, expenseList);
                listViewExpense.setAdapter(adapter);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
    }

}
