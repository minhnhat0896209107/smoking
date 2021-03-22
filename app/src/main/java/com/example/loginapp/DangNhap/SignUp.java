package com.example.loginapp.DangNhap;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginapp.R;

public class SignUp extends AppCompatActivity {
    TextView tvhaveAccount;
    Button btndangkytc;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);

        tvhaveAccount = findViewById(R.id.tv_haveAccount);
        btndangkytc = findViewById(R.id.btn_dangkytc);

        tvhaveAccount.setOnClickListener(v -> {
            Intent i = new Intent(SignUp.this, MainActivity.class);
            startActivity(i);
        });

        btndangkytc.setOnClickListener(v -> {
            Intent i = new Intent(SignUp.this, HomeActivity.class);
            startActivity(i);
            Toast.makeText(SignUp.this, "Sign Up successfully", Toast.LENGTH_SHORT).show();
        });
    }
}