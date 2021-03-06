package com.example.sao.graduationproject.main.ui;

import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import com.example.sao.graduationproject.R;
import com.example.sao.graduationproject.main.model.*;
import com.example.sao.graduationproject.main.model.MyAdapter;
import android.content.Intent;
import java.util.ArrayList;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, PullRefreshLayout.OnRefreshListener {

    private PullRefreshLayout mPullRefreshLayout;
    private ListView mListView;
    private ArrayList<CompetionBean.Competion> data;
    private MyAdapter myAdapter;
    private int pageNo = 1;
    private ExecutorService es;
    private CompetionBean.Competion competion;

    private Handler mHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            if (msg.what == 1) {
                data.clear();
                pageNo = 1;
                new DownAsynctask(data, myAdapter, MainActivity.this).executeOnExecutor(es, "http://mrobot.pcauto.com.cn/v2/cms/channels/3?pageNo=" + pageNo + "&pageSize=20&v=4.0.0");
                mPullRefreshLayout.refreshFinished();
            } else if (msg.what == 2) {
                pageNo += 1;
                new DownAsynctask(data, myAdapter, MainActivity.this).executeOnExecutor(es, "http://mrobot.pcauto.com.cn/v2/cms/channels/3?pageNo=" + pageNo + "&pageSize=20&v=4.0.0");
                mPullRefreshLayout.loadMoreFinished();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mPullRefreshLayout = (PullRefreshLayout) findViewById(R.id.main_pullrefresh_layout);
        mPullRefreshLayout.setRefreshListener(this);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("");
        setSupportActionBar(toolbar);
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();
        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        View drawview = navigationView.inflateHeaderView(R.layout.nav_header_main);
        drawview.findViewById(R.id.imageView).setOnClickListener(mOnClickListener);
        drawview.findViewById(R.id.textView).setOnClickListener(mOnClickListener);

        initListView();

    }

    private void initListView() {
        mListView = (ListView) findViewById(R.id.main_listview);
        data = new ArrayList<CompetionBean.Competion>();
        myAdapter = new MyAdapter(data, this);
        mListView.setAdapter(myAdapter);
        es = Executors.newFixedThreadPool(10);
        new DownAsynctask(data, myAdapter, this).executeOnExecutor(es, "http://mrobot.pcauto.com.cn/v2/cms/channels/3?pageNo=" + pageNo + "&pageSize=20&v=4.0.0");
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                competion = data.get(position);
                Bundle bundle = new Bundle();
                bundle.putString("title",competion.getTitle());
                bundle.putString("date",competion.getPubDate());
                Intent intent = new Intent(MainActivity.this,CompetitionDetailsActivity.class);
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });
    }

    //    跳转不消毁activity
    private View.OnClickListener mOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            switch (v.getId()) {
                case R.id.imageView:
                    Intent intent = new Intent(MainActivity.this, UserActivity.class);
                    startActivity(intent);
                    break;
                case R.id.textView:
                    Intent intent2 = new Intent(MainActivity.this, UserActivity.class);
                    startActivity(intent2);
                    break;
            }
        }
    };

    public void refreshFinished() {
        mHandler.sendEmptyMessageDelayed(1, 3 * 1000);
    }

    @Override
    public void loadMoreFinished() {
        mHandler.sendEmptyMessageDelayed(2, 3 * 1000);

    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_competition) {
            Intent intent3 = new Intent(MainActivity.this, MyCompetitionActivity.class);
            startActivity(intent3);
        } else if (id == R.id.nav_project) {
            Intent intent4 = new Intent(MainActivity.this, MyProjectActivity.class);
            startActivity(intent4);
        } else if (id == R.id.nav_achievement) {
            Intent intent5 = new Intent(MainActivity.this, MyAchievementActivity.class);
            startActivity(intent5);
        }

//        } else if (id == R.id.nav_manage) {
//
//        } else if (id == R.id.nav_share) {
//
//        } else if (id == R.id.nav_send) {
//
//        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    //按系统返回键不消毁当前activity
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            moveTaskToBack(false);
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }

}
