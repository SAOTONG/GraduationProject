package com.example.sao.graduationproject.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sao.graduationproject.R;
/**
 * Created by SAO on 2018/4/24.
 */

public class CompetitionDetailsActivity extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competion);
        initViews();
    }
    protected void initViews(){
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("");
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText("竞赛详情");
        setSupportActionBar(toolbar);
        TextView tvtitle = (TextView)findViewById(R.id.cp_title);
        TextView tvdate = (TextView)findViewById(R.id.cp_date);
        Bundle bundle = getIntent().getExtras();
        String title = bundle.getString("title");
        tvtitle.setText(title);
        String date = bundle.getString("date");
        tvdate.setText(date);
        FloatingActionButton fab = (FloatingActionButton)findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CompetitionDetailsActivity.this, "选择项目进行报名", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CompetitionDetailsActivity.this, CompetitionApplyActivity.class);
                startActivity(intent);
            }
        });
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
