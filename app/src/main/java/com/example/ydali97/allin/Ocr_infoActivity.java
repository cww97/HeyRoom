package com.example.ydali97.allin;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;

import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;

public class Ocr_infoActivity extends Activity {

    private TextView mTextMessage;
    private List<FunText> funlist = new ArrayList<>();
    private ImageView imageView;

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
        imageView=findViewById(R.id.pic_user);
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
                startActivityForResult(in,1);
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
@Override
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch (requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    Uri uri=data.getData();
                    try {
                        Bitmap bitmap = BitmapFactory.decodeStream(getContentResolver().openInputStream(uri));
                        Matrix matrix = new Matrix();
                        matrix.setRotate(180, bitmap.getWidth() / 2, bitmap.getHeight() / 2);
                        Bitmap bmp = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
                        imageView.setImageBitmap(bmp);
                        ViewGroup.MarginLayoutParams margin9 = new ViewGroup.MarginLayoutParams(
                                imageView.getLayoutParams());
                        margin9.setMargins(650, 10, 0, 0);//在左边距400像素，顶边距10像素的位置显示图片
                        RelativeLayout.LayoutParams layoutParams9 = new RelativeLayout.LayoutParams(margin9);
                        layoutParams9.height = 600;//设置图片的高度
                        layoutParams9.width = 800; //设置图片的宽度
                        imageView.setLayoutParams(layoutParams9);
                    }catch (FileNotFoundException E){
                        E.printStackTrace();
                    }
                }
        }
}
}
