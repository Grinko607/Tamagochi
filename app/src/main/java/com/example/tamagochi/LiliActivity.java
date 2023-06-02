package com.example.tamagochi;

import static kotlinx.coroutines.DelayKt.delay;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.os.SystemClock;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;


import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.security.auth.callback.Callback;

public class LiliActivity extends AppCompatActivity {
    ProgressBar pB8;
    TextView tV7;
    Button bt2, bt3, bt4, bt5, bt6;
    ImageView imageState;
    private final Handler handler = new Handler();
    private int progressStatus = 0;
    private boolean Lilsleep = false, eat = false, play = false, fun = false, heal = false,day=false;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.lili);
        pB8 = findViewById(R.id.progressBar);
        tV7 = findViewById(R.id.textView7);
        bt2 = findViewById(R.id.button2);
        bt3 = findViewById(R.id.button3);
        bt4 = findViewById(R.id.button4);
        bt5 = findViewById(R.id.button5);
        bt6 = findViewById(R.id.button6);
        imageState = findViewById(R.id.imageState);
//Основной цикл дня
        Lilsleep = true;
        eat = true;
        play = true;
        fun = true;
        heal = true;
        day = true;
      new Thread(new Runnable() {
            @SuppressLint("SetTextI18n")
            public void run() {
                while (Tamagochi.day < 100) {
                    Tamagochi.day++;
                    SystemClock.sleep(50000);
                    checkState();
                    handler.post(new Runnable() {
                        @SuppressLint("SetTextI18n")
                        public void run() {


                            String strProgress = Tamagochi.day + " day";
                            tV7.setText(strProgress);
                            pB8.setProgress(Tamagochi.day);
                        }
                    });

                }

                try {
                    Thread.sleep(200000L);

                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }


                Tamagochi.fatigue++;
                Tamagochi.hunger++;
                Tamagochi.disease++;
                Tamagochi.anger++;
                Tamagochi.boredom++;
                Tamagochi.day++;



                //Сделать проверку на состояние если всё плохо, то нужно добить и начать занаво
                //посмотреть что такое left dialog

            }
        }).start();
    }



    public void onClick2(View view) {
        Intent intent = new Intent(this, StateActivity.class);
        startActivity(intent);
    }

    public void PravilClick(View view) {
        Intent intent = new Intent(this, PravilaActivity.class);
        startActivity(intent);
    }

    //Дописать проверку на все состояния
    public void checkState() {
        if (Tamagochi.boredom > 80)
            imageState.setImageResource(R.drawable.bad);
        if (Tamagochi.anger > 80)
            imageState.setImageResource(R.drawable.bad);
        if (Tamagochi.disease > 80)
            imageState.setImageResource(R.drawable.bad);
        if (Tamagochi.hunger > 80)
            imageState.setImageResource(R.drawable.bad);
        if (Tamagochi.fatigue > 80)
            imageState.setImageResource(R.drawable.bad);
        if (Tamagochi.boredom < 79)
            imageState.setImageResource(R.drawable.smile);
        if (Tamagochi.anger < 79)
            imageState.setImageResource(R.drawable.smile);
        if (Tamagochi.disease < 79)
            imageState.setImageResource(R.drawable.smile);
        if (Tamagochi.hunger < 79)
            imageState.setImageResource(R.drawable.smile);
        if (Tamagochi.fatigue < 79)
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
                    Tamagochi.fatigue--;
                    try {
                        Thread.sleep(2000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (Tamagochi.fatigue < 0)
                        break;
                    if (Tamagochi.fatigue % 10 == 0) {
                        Tamagochi.boredom++;
                        Tamagochi.hunger++;
                    }
                    if (Tamagochi.boredom > 100)
                        break;
                    if (Tamagochi.hunger > 100)
                        break;
                    Log.d("SLEEP", Tamagochi.fatigue + " " + Tamagochi.boredom + " " + Tamagochi.hunger);
                }
            }
        });
        sleep.start();
    }

    public void lilFun(View view) {
        Lilsleep = false;
        eat = false;
        play = false;
        fun = true;
        heal = false;
        Thread Fun = new Thread(new Runnable() {
            @Override
            public void run() {
                while (fun) {
                    Tamagochi.anger--;
                    try {
                        Thread.sleep(6000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (Tamagochi.anger < 0)
                        break;
                    if (Tamagochi.anger % 10 == 0) {
                        Tamagochi.fatigue++;
                        Tamagochi.boredom++;
                    }
                    if (Tamagochi.boredom > 100)
                        break;
                    if (Tamagochi.fatigue > 100)
                        break;
                    Log.d("Fun", Tamagochi.anger + " " + Tamagochi.fatigue + " " + Tamagochi.boredom);
                }
            }
        });
        Fun.start();
    }

    public void lilHunger(View view) {
        Lilsleep = false;
        eat = true;
        play = false;
        fun = false;
        heal = false;
        Thread Eat = new Thread(new Runnable() {
            @Override
            public void run() {
                while (eat) {
                    Tamagochi.hunger--;
                    try {
                        Thread.sleep(6000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (Tamagochi.hunger < 0)
                        break;
                    if (Tamagochi.hunger % 10 == 0) {
                        Tamagochi.anger++;
                        Tamagochi.fatigue++;
                        if (Tamagochi.anger > 100)
                            break;
                        if (Tamagochi.fatigue > 100)
                            break;
                    }
                    Log.d("Hunger", Tamagochi.hunger + " " + Tamagochi.anger + " " + Tamagochi.fatigue);
                }
            }
        });
        Eat.start();
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
                    Tamagochi.boredom--;
                    try {
                        Thread.sleep(6000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (Tamagochi.boredom < 0)
                        break;
                    if (Tamagochi.boredom % 10 == 0) {
                        Tamagochi.disease++;
                        Tamagochi.hunger++;
                    }
                    if (Tamagochi.disease > 100)
                        break;
                    if (Tamagochi.hunger > 100)
                        break;
                    Log.d("Play", Tamagochi.boredom + " " + Tamagochi.disease + " " + Tamagochi.hunger);
                }
            }
        });
        Play.start();
    }

    public void lilDisease(View view) {
        Lilsleep = false;
        eat = false;
        play = false;
        fun = false;
        heal = true;
        Thread Heal = new Thread(new Runnable() {
            @Override
            public void run() {
                while (heal) {
                    Tamagochi.disease--;
                    try {
                        Thread.sleep(6000L);
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }
                    if (Tamagochi.disease < 0)
                        break;
                    if (Tamagochi.disease % 10 == 0) {
                        Tamagochi.disease++;
                        Tamagochi.anger++;
                    }
                    if (Tamagochi.disease > 100)
                        break;
                    if (Tamagochi.anger > 100)
                        break;
                    Log.d("Heal", Tamagochi.boredom + " " + Tamagochi.disease + " " + Tamagochi.anger);
                }
            }
        });
        Heal.start();
    }
}



