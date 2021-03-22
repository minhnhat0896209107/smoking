package com.example.loginapp.Home;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.example.loginapp.DangNhap.HomeActivity;
import com.example.loginapp.R;

public class Chat extends AppCompatActivity {
    ImageView imgBack;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_chat);

        imgBack = findViewById(R.id.img_backchat);
        imgBack.setOnClickListener(v -> {
            Intent intent = new Intent(Chat.this, HomeActivity.class);
            startActivity(intent);
        });
    }
}