package com.example.ydali97.allin;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class LightsActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private List<Light_item> lightlist = new ArrayList<>();

    //private String[] function = {"Controller","Key"};
    /*
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }
    };*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lights);

        mTextMessage = (TextView) findViewById(R.id.message);
        //BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initFun();
        LightAdapter adapter = new LightAdapter(LightsActivity.this, R.layout.light_item, lightlist);
        ListView listview = (ListView) findViewById(R.id.light_list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(LightsActivity.this,LightsActivity.class);
                Light_item lightitem = lightlist.get(position);
                //to jump to different Avticity
                String result = parent.getItemAtPosition(position).toString();
                if(position == 0){
                    in = new Intent(LightsActivity.this,LightControllerActivity.class);
                }else if(position == 1){
                    in = new Intent(LightsActivity.this,LightControllerActivity.class);
                }
                //position  2  and more is waiting for someone who can finish them
                startActivity(in);
            }
        });
    }
    private void initFun(){
        Light_item Livingroom = new Light_item("Living room",R.mipmap.face);
        lightlist.add(Livingroom);
        Light_item kitchen = new Light_item("Kitchen",R.mipmap.finger);
        lightlist.add(kitchen);
        Light_item bedroom = new Light_item("Bedroom",R.mipmap.mode);
        lightlist.add(bedroom);
        Light_item bathroom = new Light_item("Bathroom",R.mipmap.tick);
        lightlist.add(bathroom);
    }

}
