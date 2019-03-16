package com.example.hakan.gykhaberler;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = (ListView) findViewById(R.id.listView);

        final ArrayList<Haberler> haberlerArrayList = new ArrayList<Haberler>();

        haberlerArrayList.add(new Haberler(R.drawable.sabah,"Sabah", "https://www.sabah.com.tr/"));
        haberlerArrayList.add(new Haberler(R.drawable.hurriyet, "Hürriyet","http://www.hurriyet.com.tr/"));

        CustomAdapter customAdapter = new CustomAdapter(this, haberlerArrayList);

        listView.setAdapter(customAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Main2Activity.haberUrl = haberlerArrayList.get(position).url;

                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                startActivity(intent);
            }
        });
    }
}
