package com.example.sao.graduationproject.main.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.sao.graduationproject.R;

/**
 * Created by SAO on 2018/5/9.
 */

public class CompetitionApplyActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_competion_apply);
        initViews();
    }

    protected void initViews() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar2);
        toolbar.setTitle("");
        TextView textView = (TextView) findViewById(R.id.textView2);
        TextView tcTextView =(TextView)findViewById(R.id.textView3);
        tcTextView.setVisibility(View.VISIBLE);
        textView.setText("赛事报名");
        setSupportActionBar(toolbar);
        tcTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(CompetitionApplyActivity.this, "报名成功", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(CompetitionApplyActivity.this, ApplySuccessActivity.class);
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
