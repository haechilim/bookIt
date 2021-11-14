package com.example.bookit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookit.R;
import com.example.bookit.domain.ChattingRoom;

public class ChattingActivity extends AppCompatActivity {
    private ChattingRoom chattingRoom;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        initList();
        bindEvents();
    }

    private void initList() {
        Intent intent = getIntent();
        chattingRoom = (ChattingRoom) intent.getSerializableExtra("chattingRoom");
        Log.d("haechilim", chattingRoom.toString());

        ((TextView)findViewById(R.id.title)).setText(chattingRoom.getUser().getName());
    }

    private void bindEvents() {
        findViewById(R.id.back).setOnClickListener(v -> finish());
    }
}