package com.karim.moneytrackerpro;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by karim on 2/13/2018.
 */

public class LoginRequest extends StringRequest{


    private static final String LoginRequest_URL = "https://rkarimmalik1206.000webhostapp.com/Login.php";
    private Map<String, String> params;

    public LoginRequest(String username, String password, Response.Listener<String> listener){
        super(Request.Method.POST, LoginRequest_URL, listener, null);
        params = new HashMap<>();
        params.put("username", username);
        params.put("password", password);
//        Contoh kasus tipe int
//        params.put("umur", umur + "");
    }

    public Map<String, String> getParams(){
        return params;
    }

}
