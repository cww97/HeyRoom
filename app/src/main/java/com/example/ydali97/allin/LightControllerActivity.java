package com.example.ydali97.allin;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import com.example.ydali97.allin.light.DeviceScanActivity;

public class LightControllerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_controller);


        ImageButton imageButtonToBack = (ImageButton)findViewById(R.id.imageButtonToBack);

        imageButtonToBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToMainActivity=new Intent(LightControllerActivity.this,DeviceScanActivity.class);
                startActivity(intentToMainActivity);

            }
        });
    }
}
