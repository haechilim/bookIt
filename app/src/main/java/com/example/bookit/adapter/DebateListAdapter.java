package com.example.bookit.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.bookit.R;
import com.example.bookit.activity.DebateDetailActivity;
import com.example.bookit.domain.Comment;
import com.example.bookit.domain.Debate;
import com.example.bookit.manager.ApiManager;
import com.example.bookit.manager.DebateManager;
import com.example.bookit.helper.Util;
import com.example.bookit.view.UserView;

import java.io.Serializable;
import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;

public class DebateListAdapter extends BaseAdapter implements Serializable {
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

        initDebateView(view, debate, agree, disagree);
        bindEvents(view, debate, agree, disagree);

        return view;
    }

    private void initDebateView(View view, Debate debate, TextView agree, TextView disagree) {
        Glide.with(activity).load(ApiManager.HOST + debate.getUser().getProfileImage()).into((CircleImageView)view.findViewById(R.id.profileImage));
        ((TextView)view.findViewById(R.id.name)).setText(debate.getUser().getName());
        ((TextView)view.findViewById(R.id.category)).setText("분야: " + debate.getCategory());
        ((TextView)view.findViewById(R.id.title)).setText(debate.getTitle());
        ((TextView)view.findViewById(R.id.contents)).setText(debate.getContents());

        if(debate.isAgree()) DebateManager.clickedVoteButton(agree);
        else if(debate.isDisagree()) DebateManager.clickedVoteButton(disagree);

        if(!debate.getComment().getContents().isEmpty()) {
            Comment comment = debate.getComment();
            ((LinearLayout) view.findViewById(R.id.userContainer)).addView(new UserView(activity, comment.getUser(), false));
            ((TextView)view.findViewById(R.id.contentsOfComment)).setText(comment.getContents());
        }
    }

    private void bindEvents(View view, Debate debate, TextView agree, TextView disagree) {
        view.setOnClickListener(v -> Util.startActivity(activity, DebateDetailActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP, "debate", debate));

        DebateManager.clickEvents(activity, debate, agree, disagree);
    }
}
