package com.example.ydali97.allin;

import android.app.Activity;
import android.content.Intent;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class AirControllerActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_air_controller);


        ImageButton imageButtonToBack = (ImageButton)findViewById(R.id.imageButtonToBack);

        imageButtonToBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToMainActivity=new Intent(AirControllerActivity.this,MainActivity.class);
                startActivity(intentToMainActivity);

            }
        });
    }
}
