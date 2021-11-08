package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.domain.Debate;
import com.example.bookit.helper.DebateManager;
import com.example.bookit.view.UserView;

public class DebateDetailActivity extends AppCompatActivity {
    private Debate debate;
    private TextView agree;
    private TextView disagree;


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

        ((LinearLayout)findViewById(R.id.userContainer)).addView(new UserView(this, debate.getUser(), true));
        ((TextView)findViewById(R.id.category)).setText("분야: " + debate.getCategory());
        ((TextView)findViewById(R.id.title)).setText(debate.getTitle());
        ((TextView)findViewById(R.id.contents)).setText(debate.getContents());

        if(debate.isAgree()) DebateManager.clickVote(agree);
        else if(debate.isDisagree()) DebateManager.clickVote(disagree);
    }

    private void bindEvents() {
        DebateManager.clickEvents(debate, agree, disagree);
    }
}