package com.example.hakan.gykhaberler;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class CustomAdapter extends BaseAdapter {

    Context context;
    ArrayList<Haberler> haberlerArrayList;

    public CustomAdapter(Context context, ArrayList<Haberler> haberlerArrayList) {
        this.context = context;
        this.haberlerArrayList = haberlerArrayList;
    }

    @Override
    public int getCount() {
        return haberlerArrayList.size();
    }

    @Override
    public Object getItem(int position) {
        return haberlerArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final View v = View.inflate(context, R.layout.haberler_satir, null);

        ImageView imageView = v.findViewById(R.id.imageView);
        TextView textView = v.findViewById(R.id.textView);

        imageView.setImageResource(haberlerArrayList.get(position).haberlerFoto);
        textView.setText(haberlerArrayList.get(position).isim);

        return v;
    }
}
