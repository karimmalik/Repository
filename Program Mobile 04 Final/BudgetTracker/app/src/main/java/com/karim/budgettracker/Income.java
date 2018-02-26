package com.karim.budgettracker;

/**
 * Created by karim on 2/25/2018.
 */

public class Income {
    String incomeId, category;
    Long total;

    public Income(){

    }

    public String getIncomeId() {
        return incomeId;
    }

    public String getCategory() {
        return category;
    }

    public Long getTotal() {
        return total;
    }

    public Income(String incomeId, String category, Long total) {
        this.incomeId = incomeId;
        this.category = category;
        this.total = total;
    }
}
