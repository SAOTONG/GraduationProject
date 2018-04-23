package com.example.sao.graduationproject.main.model;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.sao.graduationproject.R;

import java.util.ArrayList;

/**
 * Created by SAO on 2018/4/20.
 */

public class MyAdapter extends BaseAdapter {

    ArrayList<CarBean.Car> data;
    Context context;

    public MyAdapter(ArrayList<CarBean.Car> data, Context context) {
        super();
        this.data = data;
        this.context = context;
    }

    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        //初始化holder对象
        ViewHold holder;
        if(convertView == null){
            //把条目布局转化为view对象
            convertView = View.inflate(context, R.layout.item, null);
            //初始化holder对象，并初始化holder中的控件
            holder = new ViewHold();
            holder.tv_title = (TextView) convertView.findViewById(R.id.tv_title);
            holder.tv_date = (TextView) convertView.findViewById(R.id.tv_date);
            //给当前view做个标记，并把数据存到该tag中
            convertView.setTag(holder);

        }else {
            //如果当前view存在，则直接从中取出其保存的控件及数据
            holder = (ViewHold) convertView.getTag();
        }
        //通过position获取当前item的car数据，从car数据中取出title、pubDate
        CarBean.Car car = data.get(position);
        holder.tv_title.setText(car.title);
        holder.tv_date.setText(car.pubDate);
        return convertView;
    }

    /*
     * 用来存放item布局中控件的holder类
     */
    class ViewHold{
        TextView tv_title; //显示标题的控件
        TextView tv_date;  //显示日期的控件
    }
}
