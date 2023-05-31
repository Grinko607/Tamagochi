package com.example.tamagochi;

import android.annotation.SuppressLint;
import android.app.MediaRouteButton;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
public class StateActivity extends AppCompatActivity {
    ProgressBar pB2, pB3, pB4, pB5, pB6;
    TextView tV, tV2, tV3, tV4, tV5;
    ImageView sadi, si;
    private final Handler handler = new Handler();
    private int progressStatus = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.state);
        pB2 = findViewById(R.id.progressBar2);
        pB3 = findViewById(R.id.progressBar3);
        pB4 = findViewById(R.id.progressBar4);
        pB5 = findViewById(R.id.progressBar5);
        pB6 = findViewById(R.id.progressBar6);
        tV = findViewById(R.id.textView);
        tV2 = findViewById(R.id.textView2);
        tV3 = findViewById(R.id.textView3);
        tV4 = findViewById(R.id.textView4);
        tV5 = findViewById(R.id.textView5);
        sadi = findViewById(R.id.sadimage);
        si = findViewById(R.id.smileimage);
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    handler.post(new Runnable() {
                        @SuppressLint("SetTextI18n")
                        public void run() {
                            pB2.setProgress(progressStatus);
                            pB3.setProgress(progressStatus);
                            pB4.setProgress(progressStatus);
                            pB5.setProgress(progressStatus);
                            pB6.setProgress(progressStatus);
                        }
                    });
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }
    public void onClick3(View view) {
        Intent intent = new Intent(this, LiliActivity.class);
        startActivity(intent);
        if (progressStatus> 80) {
            sadi.setVisibility(View.VISIBLE);
        }
        if (progressStatus < 80) {
            si.setVisibility(View.VISIBLE);
        }
    }
}





