package com.karim.budgettracker;

/**
 * Created by karim on 2/24/2018.
 */

public class UserInformation {

    public String name;
    public Integer target;

    public UserInformation(){

    }

    public UserInformation(String name, Integer target) {
        this.name = name;
        this.target= target;
    }
}
