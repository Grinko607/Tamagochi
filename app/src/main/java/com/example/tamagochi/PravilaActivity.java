package com.example.tamagochi;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class PravilaActivity extends AppCompatActivity {
    TextView textView;
    ImageView imageView1,img2;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pravila);
        textView = findViewById(R.id.textView6);
        imageView1=findViewById(R.id.imageView);
        img2=findViewById(R.id.imageView4);

    }
}

