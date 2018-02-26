package com.karim.budgettracker;

/**
 * Created by karim on 2/26/2018.
 */

public class Expense {
    String expenseId, category;
    Long total;

    public Expense(){

    }

    public String getIncomeId() {
        return expenseId;
    }

    public String getCategory() {
        return category;
    }

    public Long getTotal() {
        return total;
    }

    public Expense(String expenseId, String category, Long total) {
        this.expenseId = expenseId;
        this.category = category;
        this.total = total;
    }
}
