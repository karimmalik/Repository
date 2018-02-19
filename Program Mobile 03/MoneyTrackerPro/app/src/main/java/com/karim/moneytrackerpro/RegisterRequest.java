package com.karim.moneytrackerpro;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by karim on 2/6/2018.
 */

public class RegisterRequest extends StringRequest {

    private static final String RegisterRequest_URL = "https://rkarimmalik1206.000webhostapp.com/register.php";
    private Map<String, String> params;

    public RegisterRequest(String email, String username, String password, Response.Listener<String> listener){
        super(Method.POST, RegisterRequest_URL, listener, null);
        params = new HashMap<>();
        params.put("email", email);
        params.put("username", username);
        params.put("password", password);
//        Contoh kasus tipe int
//        params.put("umur", umur,"");
    }

    public Map<String, String> getParams(){
        return params;
    }
}
