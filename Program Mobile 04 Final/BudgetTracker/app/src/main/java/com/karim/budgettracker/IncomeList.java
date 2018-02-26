package com.karim.budgettracker;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by karim on 2/25/2018.
 */

public class IncomeList extends ArrayAdapter<Income> {
    private Activity context;
    private List<Income> incomeList;

    public IncomeList(Activity context, List<Income> incomeList){
        super(context, R.layout.list_layout,incomeList);

        this.context = context;
        this.incomeList = incomeList;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView,  ViewGroup parent) {
        LayoutInflater inflater = context.getLayoutInflater();

        View listViewItem = inflater.inflate(R.layout.list_layout, null, true);
        TextView EDCategory = (TextView) listViewItem.findViewById(R.id.EDCategory);
        TextView EDTotal = (TextView) listViewItem.findViewById(R.id.EDTotal);

        Income income = incomeList.get(position);

        EDCategory.setText(income.getCategory());
        EDTotal.setText(String.valueOf(income.getTotal()));

        return listViewItem;
    }
}
