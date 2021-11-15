package com.example.bookit.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.bookit.R;
import com.example.bookit.adapter.ChattingListAdapter;
import com.example.bookit.adapter.DebateListAdapter;
import com.example.bookit.domain.ChattingRoom;
import com.example.bookit.domain.Debate;
import com.example.bookit.domain.User;

import java.util.ArrayList;
import java.util.List;

public class ChattingActivity extends AppCompatActivity {
    private ChattingRoom chattingRoom;
    private ChattingListAdapter chattingListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chatting);

        init();
        bindEvents();
    }

    private void init() {
        initChattingRoom();
        initList();
    }

    private void initChattingRoom() {
        Intent intent = getIntent();
        chattingRoom = (ChattingRoom) intent.getSerializableExtra("chattingRoom");
        Log.d("haechilim", chattingRoom.toString());

        ((TextView)findViewById(R.id.title)).setText(chattingRoom.getUser().getName());
    }

    private void initList() {
        ListView listView = findViewById(R.id.chattingList);
        chattingListAdapter = new ChattingListAdapter(this, chattingRoom.getChattingList(), new User("임준형"));
        listView.setAdapter(chattingListAdapter);

        chattingListAdapter.notifyDataSetChanged();
    }

    private void bindEvents() {
        findViewById(R.id.back).setOnClickListener(v -> finish());

        //TODO 보내기 버튼
    }
}