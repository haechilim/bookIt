package com.example.bookit.activity;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import com.example.bookit.R;
import com.example.bookit.activity.fragment.FragmentCommunity;
import com.example.bookit.activity.fragment.FragmentHome;
import com.example.bookit.activity.helper.Util;

public class MainActivity extends AppCompatActivity {
    private FragmentHome fragmentHome;
    private FragmentCommunity fragmentCommunity;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
        eventsBind();
    }

    private void init() {
        fragmentHome = new FragmentHome();
        fragmentCommunity = new FragmentCommunity(this);

        Util.transactionFragment(this, R.id.frameLayout, fragmentHome);
    }

    private void eventsBind() {
        findViewById(R.id.homeButton).setOnClickListener(v -> Util.transactionFragment(this, R.id.frameLayout,  fragmentHome));

        findViewById(R.id.communityButton).setOnClickListener(v -> Util.transactionFragment(this, R.id.frameLayout, fragmentCommunity));
    }
}