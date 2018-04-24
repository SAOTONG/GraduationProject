package com.example.sao.graduationproject.main.model;

import com.google.gson.Gson;

/**
 * Created by SAO on 2018/4/20.
 */

public class JsonUtils {
    public static CompetionBean parseJson(String jsonString){
        Gson gson = new Gson();
        CompetionBean cb = gson.fromJson(jsonString, CompetionBean.class);
        return cb;
    }
}
