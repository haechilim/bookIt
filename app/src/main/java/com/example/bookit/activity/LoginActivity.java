package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import com.example.bookit.R;
import com.example.bookit.helper.Util;
import com.example.bookit.manager.ApiManager;

public class LoginActivity extends AppCompatActivity {
    private EditText inputId;
    private EditText inputPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        init();
        bindEvents();
    }

    private void init() {
        inputId = findViewById(R.id.inputId);
        inputPassword = findViewById(R.id.inputPassword);
    }

    private void bindEvents() {
        findViewById(R.id.login).setOnClickListener(v -> {
            String id = inputId.getText().toString().trim();
            String password = inputPassword.getText().toString().trim();

            if(id.isEmpty() || password.isEmpty()) return;

            ApiManager.login(id, password, user -> {
                if(user != null) Util.startActivity(this, MainActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP);
                else {
                    initInput();
                    Util.toast(this, "아이디나 비밀번호가 일치하지 않습니다.", false);
                }
            });
        });

        findViewById(R.id.signup).setOnClickListener(v -> Util.startActivity(this, SignupActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }

    private void initInput() {
        inputId.setText("");
        inputPassword.setText("");
    }
}