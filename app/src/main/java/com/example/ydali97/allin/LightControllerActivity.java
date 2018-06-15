package com.example.ydali97.allin;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class LightControllerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_light_controller);


        ImageButton imageButtonToBack = (ImageButton)findViewById(R.id.imageButtonToBack);

        imageButtonToBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intentToMainActivity=new Intent(LightControllerActivity.this,LightsActivity.class);
                startActivity(intentToMainActivity);

            }
        });
    }
}
