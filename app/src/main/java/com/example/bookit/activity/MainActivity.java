package com.example.bookit.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import com.example.bookit.R;
import com.example.bookit.domain.Book;
import com.example.bookit.fragment.FragmentChatting;
import com.example.bookit.fragment.FragmentCommunity;
import com.example.bookit.fragment.FragmentHome;
import com.example.bookit.fragment.FragmentMy;
import com.example.bookit.fragment.FragmentReadingDiary;
import com.example.bookit.helper.Util;
import com.example.bookit.manager.ApiManager;

import java.util.List;

public class MainActivity extends AppCompatActivity {
    private FragmentHome fragmentHome;
    private FragmentCommunity fragmentCommunity;
    private FragmentReadingDiary fragmentReadingDiary;
    private FragmentChatting fragmentChatting;
    private FragmentMy fragmentMy;

    private ImageView icHome;
    private ImageView icCommunity;
    private ImageView icReadingDiary;
    private ImageView icChatting;
    private ImageView icMy;

    private LinearLayout frameHome;
    private LinearLayout frameCommunity;
    private LinearLayout frameReadingDiary;
    private LinearLayout frameChatting;
    private LinearLayout frameMy;

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
        fragmentMy = new FragmentMy(this);

        icHome = findViewById(R.id.icHome);
        icCommunity = findViewById(R.id.icCommunity);
        icReadingDiary = findViewById(R.id.icReadingDiary);
        icChatting = findViewById(R.id.icChatting);
        icMy = findViewById(R.id.icMy);

        frameHome = findViewById(R.id.frameHome);
        frameCommunity = findViewById(R.id.frameCommunity);
        frameReadingDiary = findViewById(R.id.frameReadingDiary);
        frameChatting = findViewById(R.id.frameChatting);
        frameMy = findViewById(R.id.frameMy);

        Util.transactionFragment(this, R.id.frameHome, fragmentHome);
        Util.transactionFragment(this, R.id.frameCommunity, fragmentCommunity);
        Util.transactionFragment(this, R.id.frameReadingDiary, fragmentReadingDiary);
        Util.transactionFragment(this, R.id.frameChatting, fragmentChatting);
        Util.transactionFragment(this, R.id.frameMy, fragmentMy);

        showFrameHome();
    }

    private void eventsBind() {
        findViewById(R.id.homeButton).setOnClickListener(v -> {
            showFrameHome();
            selectedHomeButton();
        });

        findViewById(R.id.communityButton).setOnClickListener(v -> {
            showFrameCommunity();
            selectedCommunityButton();
        });

        findViewById(R.id.readingDiaryButton).setOnClickListener(v -> {
            showFrameReadingDiary();
            selectedReadingDiaryButton();
        });

        findViewById(R.id.chattingButton).setOnClickListener(v -> {
            showFrameChatting();
            selectedChattingButton();
        });

        findViewById(R.id.myButton).setOnClickListener(v -> {
            showFrameMy();
            selectedMyButton();
        });
    }

    private void showFrameHome() {
        resetFrames();
        frameHome.setVisibility(View.VISIBLE);
    }

    private void showFrameCommunity() {
        resetFrames();
        frameCommunity.setVisibility(View.VISIBLE);
    }

    private void showFrameReadingDiary() {
        resetFrames();
        frameReadingDiary.setVisibility(View.VISIBLE);
    }

    private void showFrameChatting() {
        resetFrames();
        frameChatting.setVisibility(View.VISIBLE);
    }

    private void showFrameMy() {
        resetFrames();
        frameMy.setVisibility(View.VISIBLE);
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

    private void selectedChattingButton() {
        resetButtons();
        icChatting.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_chatting_color));
    }

    private void selectedMyButton() {
        resetButtons();
        icMy.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_my_color));
    }

    private void resetFrames() {
        frameHome.setVisibility(View.INVISIBLE);
        frameCommunity.setVisibility(View.INVISIBLE);
        frameReadingDiary.setVisibility(View.INVISIBLE);
        frameChatting.setVisibility(View.INVISIBLE);
        frameMy.setVisibility(View.INVISIBLE);
    }

    private void resetButtons() {
        icHome.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_home));
        icCommunity.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_community));
        icReadingDiary.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_reading_diary));
        icChatting.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_chatting));
        icMy.setBackground(ContextCompat.getDrawable(this, R.drawable.ic_my));
    }
}