package com.example.bookit.manager;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.widget.TextView;

import androidx.core.content.ContextCompat;

import com.example.bookit.R;
import com.example.bookit.domain.Debate;

public class DebateManager {
    public static void clickEvents(Context context, Debate debate, TextView agree, TextView disagree) {
        agree.setOnClickListener(v -> clickVote(context, debate, agree, disagree, true));

        disagree.setOnClickListener(v -> clickVote(context, debate, agree, disagree, false));
    }

    private static void clickVote(Context context, Debate debate, TextView agree, TextView disagree, boolean isAgree) {
        resetVoteButton(context, isAgree ? disagree : agree);
        clickedVoteButton(isAgree ? agree : disagree);
        debate.setAgree(isAgree);
        debate.setDisagree(!isAgree);
    }

    public static void clickedVoteButton(TextView view) {
        view.setTextColor(Color.rgb(0xff, 0xff, 0xff));
        view.setBackgroundColor(Color.rgb(0xff, 0xd7, 0x9c));
    }

    public static void resetVoteButton(Context context, TextView view) {
        view.setTextColor(Color.rgb(0x00, 0x00, 0x00));
        view.setBackground(ContextCompat.getDrawable(context, R.drawable.layout_border_top_bottom));
    }
}
