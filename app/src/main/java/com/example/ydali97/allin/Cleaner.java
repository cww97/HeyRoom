package com.example.ydali97.allin;

import android.app.Activity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup.MarginLayoutParams;
import android.view.Window;
import android.view.WindowManager;
import android.widget.RelativeLayout;

public class Cleaner extends Activity {
    private static final String TAG = "Activity";

    void doLog(String log) {
        Log.e(TAG, log);
    }

    private RockerView rockerView1;
    private RockerView rockerView2;

    int screenWidth;
    int screenHeight;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cleaner);
        DisplayMetrics dm = getResources().getDisplayMetrics();
        screenWidth = dm.widthPixels;
        screenHeight = dm.heightPixels;

        rockerView1 = (RockerView) findViewById(R.id.rockerView1);
        rockerView2 = (RockerView) findViewById(R.id.rockerView2);

        rockerView1.setRockerChangeListener(new RockerView.RockerChangeListener() {

            @Override
            public void report(float x, float y) {
                // TODO Auto-generated method stub
                // doLog(x + "/" + y);
                setLayout(rockerView2, (int)x, (int)y);
            }
        });

        rockerView2.setRockerChangeListener(new RockerView.RockerChangeListener() {

            @Override
            public void report(float x, float y) {
                // TODO Auto-generated method stub
                // doLog(x + "/" + y);
                setLayout(rockerView1, (int)x, (int)y);
            }
        });
    }

    public void setLayout(View v, int dx, int dy) {
        int left = v.getLeft() + dx;
        int top = v.getTop() + dy;
        int right = v.getRight() + dx;
        int bottom = v.getBottom() + dy;
        if (left < 0) {
            left = 0;
            right = left + v.getWidth();
        }
        if (right > screenWidth) {
            right = screenWidth;
            left = right - v.getWidth();
        }
        if (top < 0) {
            top = 0;
            bottom = top + v.getHeight();
        }
        if (bottom > screenHeight) {
            bottom = screenHeight;
            top = bottom - v.getHeight();
        }
        v.layout(left, top, right, bottom);
    }
}