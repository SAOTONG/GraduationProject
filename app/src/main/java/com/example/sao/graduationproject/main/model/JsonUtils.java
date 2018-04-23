package com.example.sao.graduationproject.main.model;

import com.google.gson.Gson;

/**
 * Created by SAO on 2018/4/20.
 */

public class JsonUtils {
    public static CarBean parseJson(String jsonString){
        Gson gson = new Gson();
        CarBean cb = gson.fromJson(jsonString, CarBean.class);
        return cb;
    }
}
