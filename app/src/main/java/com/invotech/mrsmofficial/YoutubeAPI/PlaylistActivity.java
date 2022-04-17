package com.invotech.mrsmofficial.YoutubeAPI;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.invotech.mrsmofficial.Activities.MainActivity;
import com.invotech.mrsmofficial.R;
import com.invotech.mrsmofficial.YoutubeAPI.fragments.ChannelFragment;

public class PlaylistActivity extends AppCompatActivity {

    ImageView btnBack;
    ProgressBar pg_progress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playlist);

        btnBack = findViewById(R.id.btn_back);
        pg_progress = findViewById(R.id.pg_progress);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                pg_progress.setVisibility(View.GONE);
            }
        },2000);
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(PlaylistActivity.this,MainActivity.class));
                finish();
            }
        });
        ChannelFragment myf = new ChannelFragment();

        final FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.mainFrame,myf);
        transaction.addToBackStack(null);
        transaction.commit();


    }

    @Override
    public void onBackPressed() {

    }
}
