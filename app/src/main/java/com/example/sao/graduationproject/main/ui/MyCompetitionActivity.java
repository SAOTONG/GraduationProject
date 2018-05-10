package com.example.sao.graduationproject.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.sao.graduationproject.R;
import com.example.sao.graduationproject.main.model.CompetionBean;
import com.example.sao.graduationproject.main.model.DownAsynctask;
import com.example.sao.graduationproject.main.model.MyAdapter;

import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by SAO on 2018/5/9.
 */

public class MyCompetitionActivity extends AppCompatActivity {
//    private ListView mcListView;
//    private ArrayList<CompetionBean.Competion> data;
//    private MyAdapter myAdapter;
//    private ExecutorService es;
//    private int pageNo = 1;
//    private CompetionBean.Competion competion;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mycompetition);
        initViews();
    }
    protected void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("");
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText("我的赛事");
        setSupportActionBar(toolbar);
//        mcListView = (ListView)findViewById(R.id.mycompetition_listview);
//        data = new ArrayList<CompetionBean.Competion>();
//        myAdapter = new MyAdapter(data, this);
//        mcListView.setAdapter(myAdapter);
//        es = Executors.newFixedThreadPool(10);
//        new DownAsynctask(data, myAdapter, this).executeOnExecutor(es, "http://mrobot.pcauto.com.cn/v2/cms/channels/3?pageNo=" + pageNo + "&pageSize=20&v=4.0.0");
//        mcListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                competion = data.get(position);
//                Bundle bundle = new Bundle();
//                bundle.putString("title",competion.getTitle());
//                bundle.putString("date",competion.getPubDate());
//                Intent intent = new Intent(MyCompetitionActivity.this, MyCompetitionDetailsActivity.class);
//                startActivity(intent);
//            }
//        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                finish();
                break;
        }
        return true;
    }
}
