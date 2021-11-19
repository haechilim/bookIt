package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.domain.Debate;
import com.example.bookit.fragment.FragmentDebate;
import com.example.bookit.helper.Util;
import com.example.bookit.manager.ApiManager;
import com.example.bookit.manager.DebateManager;
import com.example.bookit.view.UserView;

public class DebateDetailActivity extends AppCompatActivity {
    private Debate debate;
    private TextView agree;
    private TextView disagree;
    private EditText edit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_debate_detail);

        init();
        bindEvents();
    }

    private void init() {
        Intent intent = getIntent();
        debate = (Debate) intent.getSerializableExtra("debate");
        agree = findViewById(R.id.agree);
        disagree = findViewById(R.id.disagree);
        edit = findViewById(R.id.message);

        ((LinearLayout)findViewById(R.id.userContainer)).addView(new UserView(this, debate.getUser(), true));
        ((TextView)findViewById(R.id.category)).setText("분야: " + debate.getCategory());
        ((TextView)findViewById(R.id.title)).setText(debate.getTitle());
        ((TextView)findViewById(R.id.contents)).setText(debate.getContents());

        if(debate.isAgree()) DebateManager.clickedVoteButton(agree);
        else if(debate.isDisagree()) DebateManager.clickedVoteButton(disagree);
    }

    private void bindEvents() {
        findViewById(R.id.back).setOnClickListener(v -> {
            FragmentDebate.updateList();
            finish();
        });

        DebateManager.clickEvents(this, debate, agree, disagree);

        findViewById(R.id.sendButton).setOnClickListener(v -> {
            String message = edit.getText().toString().trim();

            if(message.isEmpty()) return;
            else {
                ApiManager.writeComment(debate.getId(), message, success -> {
                    if(success) {
                        //TODO 리스트 갱신
                        edit.setText("");
                    }
                    else Util.toast(this, "댓글을 작성 할 수 없습니다.", false);
                });
            }
        });
    }
}