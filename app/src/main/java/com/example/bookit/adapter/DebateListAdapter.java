package com.example.bookit.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.activity.BookDetailActivity;
import com.example.bookit.activity.DebateDetailActivity;
import com.example.bookit.domain.Debate;
import com.example.bookit.helper.DebateManager;
import com.example.bookit.helper.Util;
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

        initDebate(view, debate, agree, disagree);
        bindEvents(view, debate, agree, disagree);

        return view;
    }

    private void bindEvents(View view, Debate debate, TextView agree, TextView disagree) {
        view.setOnClickListener(v -> Util.startActivity(activity, DebateDetailActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP, "debate", debate));

        DebateManager.clickEvents(debate, agree, disagree);
    }

    private void initDebate(View view, Debate debate, TextView agree, TextView disagree) {
        ((TextView)view.findViewById(R.id.category)).setText("분야: " + debate.getCategory());
        ((TextView)view.findViewById(R.id.title)).setText(debate.getTitle());
        ((TextView)view.findViewById(R.id.contents)).setText(debate.getContents());

        if(debate.isAgree()) DebateManager.clickVote(agree);
        else if(debate.isDisagree()) DebateManager.clickVote(disagree);

        ((LinearLayout)view.findViewById(R.id.userContainer)).addView(new UserView(activity, debate.getUser(), false));
        //TODO 메인 댓글 표시
    }
}