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

public class Ocr_infoActivity extends AppCompatActivity {

    private TextView mTextMessage;
    private List<FunText> funlist = new ArrayList<>();

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
        setContentView(R.layout.activity_ocr_info);

        mTextMessage = (TextView) findViewById(R.id.message);
        //BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        //navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        initFun();
        FunAdapter adapter = new FunAdapter(Ocr_infoActivity.this, R.layout.fun_text, funlist);
        ListView listview = (ListView) findViewById(R.id.home_list);
        listview.setAdapter(adapter);
        listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent in = new Intent(Ocr_infoActivity.this,Ocr_infoActivity.class);
                FunText funtext = funlist.get(position);
                //to jump to different Avticity
                String result = parent.getItemAtPosition(position).toString();
                if(position == 0){
                    in = new Intent(Ocr_infoActivity.this,tempActivity.class);
                }else if(position == 1){
                    in = new Intent(Ocr_infoActivity.this,tempActivity.class);
                }
                //position  2  and more is waiting for someone who can finish them
                startActivity(in);
            }
        });
    }
    private void initFun(){
        FunText Face_manage = new FunText("FaceManage",R.mipmap.face);
        funlist.add(Face_manage);
        FunText Finger_manage = new FunText("FingerManage",R.mipmap.finger);
        funlist.add(Finger_manage);
        FunText Mode_switch = new FunText("ModeSwitch",R.mipmap.mode);
        funlist.add(Mode_switch);
        FunText Danger_switch = new FunText("DangerManage",R.mipmap.tick);
        funlist.add(Danger_switch);
        FunText PowerIn = new FunText("PermissionManage",R.mipmap.power);
        funlist.add(PowerIn);
    }

}
