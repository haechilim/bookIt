package com.example.bookit.activity.activity;

import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.bookit.R;
import com.example.bookit.activity.fragment.FragmentChatting;
import com.example.bookit.activity.fragment.FragmentCommunity;
import com.example.bookit.activity.fragment.FragmentHome;
import com.example.bookit.activity.fragment.FragmentReadingDiary;
import com.example.bookit.activity.helper.Util;

public class MainActivity extends AppCompatActivity {
    private FragmentHome fragmentHome;
    private FragmentCommunity fragmentCommunity;
    private FragmentReadingDiary fragmentReadingDiary;
    private FragmentChatting fragmentChatting;
    private ImageView icHome;
    private ImageView icCommunity;
    private ImageView icReadingDiary;
    private ImageView icChatting;
    private ImageView icMy;

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
        fragmentReadingDiary = new FragmentReadingDiary(this);
        fragmentChatting = new FragmentChatting(this);
        icHome = findViewById(R.id.icHome);
        icCommunity = findViewById(R.id.icCommunity);
        icReadingDiary = findViewById(R.id.icReadingDiary);
        icChatting = findViewById(R.id.icChatting);
        icMy = findViewById(R.id.icMy);

        Util.transactionFragment(this, R.id.frameLayout, fragmentHome);
    }

    private void eventsBind() {
        findViewById(R.id.homeButton).setOnClickListener(v -> {
            Util.transactionFragment(this, R.id.frameLayout,  fragmentHome);
            selectedHomeButton();
        });

        findViewById(R.id.communityButton).setOnClickListener(v -> {
            Util.transactionFragment(this, R.id.frameLayout, fragmentCommunity);
            selectedCommunityButton();
        });

        findViewById(R.id.readingDiaryButton).setOnClickListener(v -> {
            Util.transactionFragment(this, R.id.frameLayout, fragmentReadingDiary);
            selectedReadingDiaryButton();
        });

        findViewById(R.id.chattingButton).setOnClickListener(v -> {
            Util.transactionFragment(this, R.id.frameLayout, fragmentChatting);
            selectedRChattingButton();
        });
    }

    private void resetButtons() {
        icHome.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_home));
        icCommunity.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_community));
        icReadingDiary.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_reading_diary));
        icChatting.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_chatting));
        icMy.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_my));
    }

    private void selectedHomeButton() {
        resetButtons();
        icHome.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_home_color));
    }

    private void selectedCommunityButton() {
        resetButtons();
        icCommunity.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_community_color));
    }

    private void selectedReadingDiaryButton() {
        resetButtons();
        icReadingDiary.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_reading_diary_color));
    }

    private void selectedRChattingButton() {
        resetButtons();
        icChatting.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_chatting_color));
    }
}