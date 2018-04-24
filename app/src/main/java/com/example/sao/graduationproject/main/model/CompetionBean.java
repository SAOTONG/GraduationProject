package com.example.sao.graduationproject.main.model;

import java.util.ArrayList;

/**
 * Created by SAO on 2018/4/20.
 */

public class CompetionBean {

    public ArrayList<Competion> data;

    public static class Competion{
        public String title;
        public String pubDate;
        public String getPubDate() {
            return pubDate;
        }

        public void setPubDate(String pubDate) {
            this.pubDate = pubDate;
        }

        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
    }
}