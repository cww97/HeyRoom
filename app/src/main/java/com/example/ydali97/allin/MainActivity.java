package com.example.ydali97.allin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

public class MainActivity extends AppCompatActivity {
    private ImageButton OCR;
    private ImageButton AIR;
    private ImageButton LIGHT;
    private ImageButton CLEAN;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        OCR = (ImageButton) findViewById(R.id.bt_faceid);
        OCR.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, Ocr_infoActivity.class);

                startActivity(intent);
            }
        }
        );

        AIR = (ImageButton) findViewById(R.id.bt_air);
        AIR.setOnClickListener(new View.OnClickListener(){
                                   public void onClick(View v) {
                                       Intent intent = new Intent(MainActivity.this, AirControllerActivity.class);

                                       startActivity(intent);
                                   }
                               }
                               );

        LIGHT = (ImageButton) findViewById(R.id.bt_light);
        LIGHT.setOnClickListener(new View.OnClickListener(){
                                   public void onClick(View v) {
                                       Intent intent = new Intent(MainActivity.this, LightsActivity.class);

                                       startActivity(intent);
                                   }
                               }
        );

        CLEAN = (ImageButton) findViewById(R.id.bt_celan);
        CLEAN.setOnClickListener(new View.OnClickListener(){
                                   public void onClick(View v) {
                                       Intent intent = new Intent(MainActivity.this, Cleaner.class);

                                       startActivity(intent);
                                   }
                               }
        );

        Init();
    }
    private void Init(){


    }
    public void toFace(View view){
        Intent in = new Intent();
        in.setClass(this,Ocr_infoActivity.class);
    }


}
