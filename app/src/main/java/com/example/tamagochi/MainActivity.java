package com.example.tamagochi;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {
    ImageView img1, img2, img3;
    TextView tv;
    Button bt;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img1 = (ImageView) findViewById(R.id.imageView1);
        img2 = (ImageView) findViewById(R.id.imageView2);
        img3 = (ImageView) findViewById(R.id.imageView3);
        tv = (TextView) findViewById(R.id.tv);
        bt = (Button) findViewById(R.id.b);
    }
        public void onClick (View view){
            Intent intent = new Intent(this, LiliActivity.class);
            startActivity(intent);

        }

}



