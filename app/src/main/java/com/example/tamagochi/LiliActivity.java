package com.example.tamagochi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;

public class LiliActivity extends AppCompatActivity {

    ProgressBar pB8;
    Button bt2, bt3, bt4, bt5, bt6;
    TextView tV8;
    ImageView sadi,si;
    private final Handler handler = new Handler();
    private int progressStatus = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lili);
        pB8 = findViewById(R.id.progressBar8);
        bt2 = findViewById(R.id.button2);
        bt3 = findViewById(R.id.button3);
        bt4 = findViewById(R.id.button4);
        bt5 = findViewById(R.id.button5);
        bt6 = findViewById(R.id.button6);
        tV8 = findViewById(R.id.textView8);
        sadi=findViewById(R.id.sadimage);
        si=findViewById(R.id.smileimage);


        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    handler.post(new Runnable() {
                        @SuppressLint("SetTextI18n")
                        public void run() {
                            pB8.setProgress(progressStatus);

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

    @SuppressLint("NonConstantResourceId")
    public void onClick2(View view) {
        Intent intent = new Intent(this, StateActivity.class);
        startActivity(intent);

        }
    }

