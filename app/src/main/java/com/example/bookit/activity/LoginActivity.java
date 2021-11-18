package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.bookit.R;
import com.example.bookit.helper.Util;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        bindEvents();
    }

    private void bindEvents() {
        findViewById(R.id.signup).setOnClickListener(v -> Util.startActivity(this, SignupActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}