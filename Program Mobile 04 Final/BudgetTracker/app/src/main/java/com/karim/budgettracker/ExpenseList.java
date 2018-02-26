package com.karim.budgettracker;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by karim on 2/26/2018.
 */

public class ExpenseList extends ArrayAdapter<Expense>{


    private Activity context;
    private List<Expense> expenseList;

    public ExpenseList(Activity context, List<Expense> expenseList){
        super(context, R.layout.list_layout2,expenseList);

        this.context = context;
        this.expenseList= expenseList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout2, null, true);
        TextView EDCategory2 = (TextView) listViewItem.findViewById(R.id.EDCategory2);
        TextView EDTotal2 = (TextView) listViewItem.findViewById(R.id.EDTotal2);

        Expense expense= expenseList.get(position);

        EDCategory2.setText(expense.getCategory());
        EDTotal2.setText(String.valueOf(expense.getTotal()));

        return listViewItem;
    }

}
