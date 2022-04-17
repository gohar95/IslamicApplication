package com.invotech.mrsmofficial.Activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.res.Configuration;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.invotech.mrsmofficial.R;

import pl.droidsonroids.gif.GifImageView;

public class CompassActivity extends AppCompatActivity implements SensorEventListener {
    ImageView ic_compass;
    private static SensorManager sensorManager;
    private static Sensor sensor;
    private float currentDegree;
    ImageView btnBack;
    /*GifImageView gifImageView;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_compass);
        ic_compass = findViewById(R.id.ic_compass);
        btnBack = findViewById(R.id.btn_back);
        /*gifImageView = findViewById(R.id.gif_rotate);*/
        /*int orientation = getResources().getConfiguration().orientation;
        if (orientation == Configuration.ORIENTATION_LANDSCAPE) {
            gifImageView.setVisibility(View.GONE);
        } else {
            gifImageView.setVisibility(View.VISIBLE);
        }*/
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(CompassActivity.this, MainActivity.class));
                finish();
            }
        });
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        sensor = sensorManager.getDefaultSensor(Sensor.TYPE_ORIENTATION);
        if (sensor != null) {
            sensorManager.registerListener( this, sensor, SensorManager.SENSOR_DELAY_FASTEST);
        } else {
            Toast.makeText(this, "not Supported", Toast.LENGTH_SHORT).show();
        }

    }


    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        int degree = Math.round(sensorEvent.values[0]);
        RotateAnimation animation = new RotateAnimation(currentDegree, -degree, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        animation.setDuration(500);
        animation.setFillAfter(true);
        ic_compass.setAnimation(animation);
        currentDegree = -degree;

    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {

    }

    @Override
    public void onBackPressed() {

    }
}