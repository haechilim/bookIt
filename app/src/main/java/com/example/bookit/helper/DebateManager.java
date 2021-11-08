package com.example.bookit.helper;

import android.graphics.Color;
import android.widget.TextView;

import com.example.bookit.domain.Debate;

public class DebateManager {
    public static void clickEvents(Debate debate, TextView agree, TextView disagree) {
        agree.setOnClickListener(v -> {
            resetVote(disagree);
            clickVote(agree);
            debate.setAgree(true);
            debate.setDisagree(false);
        });

        disagree.setOnClickListener(v -> {
            resetVote(agree);
            clickVote(disagree);
            debate.setAgree(false);
            debate.setDisagree(true);
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
