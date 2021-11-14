package com.example.bookit.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.bookit.R;
import com.example.bookit.domain.Chatting;

import java.util.List;

public class ChattingListAdapter extends BaseAdapter {
    private Activity activity;
    private List<Chatting> chattingList;

    public ChattingListAdapter(Activity activity, List<Chatting> chattingList) {
        this.activity = activity;
        this.chattingList = chattingList;
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
        View view = ((LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_chatting_list_item, parent, false);
        Chatting chatting = chattingList.get(position);

        return view;
    }
}
