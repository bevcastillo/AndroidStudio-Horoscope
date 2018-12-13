package com.example.beverly.horoscope;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    //data container
    ArrayList<Horoscope> list;
    LayoutInflater inflater;

    public CustomAdapter(Context context, ArrayList<Horoscope> list) {
        super();
        this.context = context;
        this.list = list;
        this.inflater=LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PersonHandler handler=null;
        if(convertView==null){
            convertView=inflater.inflate(R.layout.custom_layout,null);
            handler=new PersonHandler();
            handler.iv=(ImageView) convertView.findViewById(R.id.imageView);
            handler.name= (TextView) convertView.findViewById(R.id.textView1);
            handler.date= (TextView) convertView.findViewById(R.id.textView2);
            convertView.setTag(handler);
        }
        else handler=(PersonHandler) convertView.getTag();
        //fill the view elements
        handler.iv.setImageResource(list.get(position).getImg());
        handler.name.setText(list.get(position).getName());
        handler.date.setText(list.get(position).getDate());

        return convertView;
    }

    //create a static class to handle Custom layout

    static class PersonHandler{
        ImageView iv;
        TextView name,date;
    }
}