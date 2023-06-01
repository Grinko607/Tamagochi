package com.example.tamagochi;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;


import androidx.appcompat.app.AppCompatActivity;

public class LiliActivity extends AppCompatActivity {

    ProgressBar pB8;
    Button bt2, bt3, bt4, bt5, bt6;
    ImageView imageState;
    private final Handler handler = new Handler();
    private int progressStatus = 0;

    private boolean Lilsleep = false, eat = false, play = false, fun = false, heal = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lili);
        pB8 = findViewById(R.id.progressBardDay);
        bt2 = findViewById(R.id.button2);
        bt3 = findViewById(R.id.button3);
        bt4 = findViewById(R.id.button4);
        bt5 = findViewById(R.id.button5);
        bt6 = findViewById(R.id.button6);
        imageState = findViewById(R.id.imageState);

//Основной цикл дня
        new Thread(new Runnable() {
            public void run() {
                while (progressStatus < 100) {
                    progressStatus += 1;
                    checkState();
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
                    Tamagochi.fatigue--;
                    Tamagochi.hunger--;
                    Tamagochi.disease--;
                    Tamagochi.anger--;
                    Tamagochi.boredom--;

                    //Сделать проверку на состояние если всё плохо, то нужно добить и начать занаво
                    //посмотреть что такое lert dialog
                }
            }
        }).start();
    }

    @SuppressLint("NonConstantResourceId")
    public void onClick2(View view) {
        Intent intent = new Intent(this, StateActivity.class);
        startActivity(intent);
    }
//Дописать проверку на все состояния
    public void checkState(){
        if(Tamagochi.boredom<80)
            imageState.setImageResource(R.drawable.bad);
        if(Tamagochi.boredom>79)
            imageState.setImageResource(R.drawable.smile);
    }
    //Пример сна(создаём цикл и уменьшаем другие показатели и увеличиваем основной)
    public void lilSleep(View view) {
        Lilsleep = true;
        eat = false;
        play = false;
        fun = false;
        heal = false;
        Thread sleep = new Thread(new Runnable() {
            @Override
            public void run() {
                while (Lilsleep) {
                    Tamagochi.fatigue++;
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (Tamagochi.fatigue > 100)
                        break;
                    if (Tamagochi.fatigue % 5 == 0) {
                        Tamagochi.disease--;
                        Tamagochi.hunger--;
                    }
                    Log.d("SLEEP", Tamagochi.fatigue + " " + Tamagochi.disease + " " + Tamagochi.hunger);
                }
            }
        });
        sleep.start();
    }

    public void lilPlay(View view) {
        Lilsleep = false;
        eat = false;
        play = true;
        fun = false;
        heal = false;
        Thread Play = new Thread(new Runnable() {
            @Override
            public void run() {
                while (play) {
                    Tamagochi.boredom++;
                    try {
                        Thread.sleep(1000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (Tamagochi.boredom > 100)
                        break;
                    if (Tamagochi.boredom % 5 == 0) {
                        Tamagochi.disease--;
                        Tamagochi.hunger--;
                    }
                    Log.d("Play", Tamagochi.boredom + " " + Tamagochi.disease + " " + Tamagochi.hunger);
                }
            }
        });
        Play.start();
    }
}

