package com.karim.moneytrackerpro;

/**
 * Created by karim on 2/5/2018.
 */

public class User {
    int id_user;
    String target;
    String username;
    String password;
    String email;

    public User() {
        this.id_user = id_user;
        this.target = target;
        this.username = username;
        this.password = password;
        this.email = email;
    }

    public int getId_user() {
        return id_user;
    }

    public void setId_user(int id_user)
    {
        this.id_user = id_user;
    }

    public String getTarget() {
        return target;
    }

    public void setTarget(String target) {
        this.target = target;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
