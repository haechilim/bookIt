package com.example.bookit.helper;

import android.graphics.Color;
import android.widget.TextView;

import com.example.bookit.domain.Debate;

public class DebateManager {
    public static void clickEvents(Debate debate, TextView agree, TextView disagree) {
        agree.setOnClickListener(v -> clickVote(debate, agree, disagree, true));

        disagree.setOnClickListener(v -> clickVote(debate, agree, disagree, false));
    }

    private static void clickVote(Debate debate, TextView agree, TextView disagree, boolean isAgree) {
        resetVoteButton(isAgree ? disagree : agree);
        clickedVoteButton(isAgree ? agree : disagree);
        debate.setAgree(isAgree);
        debate.setDisagree(!isAgree);
    }

    public static void clickedVoteButton(TextView view) {
        view.setTextColor(Color.rgb(0xff, 0xff, 0xff));
        view.setBackgroundColor(Color.rgb(0xff, 0xd7, 0x9c));
    }

    public static void resetVoteButton(TextView view) {
        view.setTextColor(Color.rgb(0x00, 0x00, 0x00));
        view.setBackgroundColor(Color.rgb(0xff, 0xff, 0xff));
    }
}
