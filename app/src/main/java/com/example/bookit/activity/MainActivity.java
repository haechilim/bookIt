package com.example.bookit.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.bookit.R;
import com.example.bookit.activity.fragment.FragmentHome;

public class MainActivity extends AppCompatActivity {
    private FragmentTransaction transaction;
    private FragmentHome fragmentHome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        eventsBind();
    }

    private void init() {
        fragmentHome = new FragmentHome();

        transactionFragment(fragmentHome);
    }

    private void eventsBind() {
        findViewById(R.id.homeButton).setOnClickListener(v -> transactionFragment(fragmentHome));
    }

    private void transactionFragment(Fragment fragment) {
        transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frameLayout, fragment).commitAllowingStateLoss();
    }
}