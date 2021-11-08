package com.example.bookit.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.os.DeadObjectException;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.domain.Debate;
import com.example.bookit.view.UserView;

import java.util.List;

public class DebateListAdapter extends BaseAdapter {
    private Activity activity;
    private List<Debate> debateList;

    public DebateListAdapter(Activity activity, List<Debate> debateList) {
        this.activity = activity;
        this.debateList = debateList;
    }

    @Override
    public int getCount() {
        return debateList.size();
    }

    @Override
    public Object getItem(int position) {
        return debateList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Debate debate = debateList.get(position);
        View view = ((LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_debate_list_item, parent, false);
        TextView agree = view.findViewById(R.id.agree);
        TextView disagree = view.findViewById(R.id.disagree);

        newDebate(view, agree, disagree, debate);
        bindEvents(debate, agree, disagree);

        return view;
    }

    private void bindEvents(Debate debate, TextView agree, TextView disagree) {
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

    private void newDebate(View view, TextView agree, TextView disagree, Debate debate) {
        ((TextView)view.findViewById(R.id.category)).setText("분야: " + debate.getCategory());
        ((TextView)view.findViewById(R.id.title)).setText(debate.getTitle());
        ((TextView)view.findViewById(R.id.contents)).setText(debate.getContents());

        if(debate.isAgree()) clickVote(agree);
        else if(debate.isDisagree()) clickVote(disagree);

        ((LinearLayout)view.findViewById(R.id.userContainer)).addView(new UserView(activity, debate.getUser()));
    }

    private void clickVote(TextView view) {
        view.setTextColor(Color.rgb(0xff, 0xff, 0xff));
        view.setBackgroundColor(Color.rgb(0xff, 0xd7, 0x9c));
    }

    private void resetVote(TextView view) {
        view.setTextColor(Color.rgb(0x00, 0x00, 0x00));
        view.setBackgroundColor(Color.rgb(0xff, 0xff, 0xff));
    }
}
