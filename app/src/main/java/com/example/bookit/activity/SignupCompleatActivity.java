package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import com.example.bookit.R;
import com.example.bookit.helper.Util;

public class SignupCompleatActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_compleat);

        findViewById(R.id.login).setOnClickListener(v -> Util.startActivity(this, LoginActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}