package com.example.tamagochi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class StateActivity extends AppCompatActivity {
    ProgressBar pB2, pB3, pB4, pB5, pB6;
    TextView tV, tV2, tV3, tV4, tV5;
    ImageView  si;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.state);
        pB2 = findViewById(R.id.progressBarUst);
        pB3 = findViewById(R.id.progressBarSkuka);
        pB4 = findViewById(R.id.progressBarGolod);
        pB5 = findViewById(R.id.progressBarGnev);
        pB6 = findViewById(R.id.progressBar6);
        tV = findViewById(R.id.textView);
        tV2 = findViewById(R.id.textView2);
        tV3 = findViewById(R.id.textView3);
        tV4 = findViewById(R.id.textView4);
        tV5 = findViewById(R.id.textView5);
        si = findViewById(R.id.imageState);
        pB2.setProgress(Tamagochi.fatigue);
        pB3.setProgress(Tamagochi.boredom);
        pB4.setProgress(Tamagochi.hunger);
        pB5.setProgress(Tamagochi.anger);
        pB6.setProgress(Tamagochi.disease);

    }
    public void onClick4(View view) {
        Intent intent = new Intent(this, LiliActivity.class);
        startActivity(intent);

    }
}





