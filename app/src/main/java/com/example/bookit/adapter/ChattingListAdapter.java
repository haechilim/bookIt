package com.example.bookit.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.domain.Chatting;
import com.example.bookit.domain.User;

import java.util.List;

public class ChattingListAdapter extends BaseAdapter {
    private Activity activity;
    private List<Chatting> chattingList;
    private User my;
    private User lastUser;

    public ChattingListAdapter(Activity activity, List<Chatting> chattingList, User my) {
        this.activity = activity;
        this.chattingList = chattingList;
        this.my = my;
    }

    @Override
    public int getCount() {
        return chattingList.size();
    }

    @Override
    public Object getItem(int position) {
        return chattingList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Chatting chatting = chattingList.get(position);
        View view = ((LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(chatting.getUser() == my ? R.layout.layout_chatting_list_item_my : R.layout.layout_chatting_list_item, parent, false);

        init(view, chatting);
        lastUser = chatting.getUser();

        return view;
    }

    private void init(View view, Chatting chatting) {
        view.findViewById(R.id.profileImage).setVisibility(lastUser == chatting.getUser() ? View.INVISIBLE : View.VISIBLE);
        ((TextView) view.findViewById(R.id.chattingBubble)).setText(chatting.getMessage());
    }
}
