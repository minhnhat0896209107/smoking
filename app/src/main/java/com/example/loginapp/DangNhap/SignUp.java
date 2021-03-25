package com.example.loginapp.DangNhap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.loginapp.R;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity {
    TextView tvhaveAccount;
    Button btndangkytc;
    EditText edtUser, edtEmail, edtPassword, edtPhone;
    FirebaseAuth mAuth;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_sign_up);
        init();
        mAuth = FirebaseAuth.getInstance();

        tvhaveAccount.setOnClickListener(v -> {
            Intent i = new Intent(SignUp.this, MainActivity.class);
            startActivity(i);
        });

        btndangkytc.setOnClickListener(v -> {
            dangKy();

        });
    }
    private void init(){
        tvhaveAccount = findViewById(R.id.tv_haveAccount);
        btndangkytc = findViewById(R.id.btn_dangkytc);

        edtEmail = findViewById(R.id.edt_email);
        edtPassword = findViewById(R.id.edt_password);
        edtUser = findViewById(R.id.edt_user);
        edtPhone = findViewById(R.id.edt_phone);
    }
    private void dangKy(){
        String email = edtEmail.getText().toString();
        String password = edtPassword.getText().toString();
        String phone = edtPhone.getText().toString().trim();
        String user = edtUser.getText().toString().trim();
        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(SignUp.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (user.length() > 0){
                            if(email.contains("@gmail.com"))
                            {
                                if(password.length() > 5){
                                    if (phone.length() == 10){
                                        Toast.makeText(SignUp.this, "Register Successfully", Toast.LENGTH_SHORT).show();
                                        Intent i = new Intent(SignUp.this, MainActivity.class);
                                        startActivity(i);
                                    }else{
                                        Toast.makeText(SignUp.this, "Input phone 10 number", Toast.LENGTH_SHORT).show();
                                    }
                                }else{
                                    Toast.makeText(SignUp.this, "Password greater than 6 characters", Toast.LENGTH_SHORT).show();
                                }
                            }else{
                                Toast.makeText(SignUp.this, "email need: @gmail.com ", Toast.LENGTH_SHORT).show();
                            }
                        }else{
                            Toast.makeText(SignUp.this, "User greater than 1 characters", Toast.LENGTH_SHORT).show();
                        }
                    }
                });
    }

}