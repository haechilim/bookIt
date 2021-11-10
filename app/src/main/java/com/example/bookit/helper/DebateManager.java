package com.example.bookit.helper;

import android.graphics.Color;
import android.widget.TextView;

import com.example.bookit.domain.Debate;

public class DebateManager {
    public static TextView agree;
    public static TextView disagree;

    public static void changeVote(boolean isAgree) {
        if(agree == null || disagree == null) return;

        resetVote(agree);
        resetVote(disagree);

        if(isAgree) clickVote(agree);
        else clickVote(disagree);
    }

    public static void clickEvents(Debate debate, TextView agree, TextView disagree) {
        agree.setOnClickListener(v -> {
            resetVote(disagree);
            clickVote(agree);
            debate.setAgree(true);
            debate.setDisagree(false);

            changeVote(true);
        });

        disagree.setOnClickListener(v -> {
            resetVote(agree);
            clickVote(disagree);
            debate.setAgree(false);
            debate.setDisagree(true);

            changeVote(true);
        });
    }

    public static void clickVote(TextView view) {
        view.setTextColor(Color.rgb(0xff, 0xff, 0xff));
        view.setBackgroundColor(Color.rgb(0xff, 0xd7, 0x9c));
    }

    public static void resetVote(TextView view) {
        view.setTextColor(Color.rgb(0x00, 0x00, 0x00));
        view.setBackgroundColor(Color.rgb(0xff, 0xff, 0xff));
    }
}
