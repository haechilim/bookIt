package com.example.bookit.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.activity.ChattingActivity;
import com.example.bookit.domain.ChattingRoom;
import com.example.bookit.helper.Util;

import java.util.List;

public class ChattingRoomListAdapter extends BaseAdapter {
    private Activity activity;
    private List<ChattingRoom> chattingRoomList;

    public ChattingRoomListAdapter(Activity activity, List<ChattingRoom> chattingRoomList) {
        this.activity = activity;
        this.chattingRoomList = chattingRoomList;
    }

    @Override
    public int getCount() {
        return chattingRoomList.size();
    }

    @Override
    public Object getItem(int position) {
        return chattingRoomList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ChattingRoom chattingRoom = chattingRoomList.get(position);
        View view = ((LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_chatting_list_room_item, parent, false);

        init(view, chattingRoom);
        bindEvents(view, chattingRoom);

        return view;
    }

    private void init(View view, ChattingRoom chattingRoom) {
        ((TextView) view.findViewById(R.id.name)).setText(chattingRoom.getUser().getName());
        ((TextView) view.findViewById(R.id.message)).setText(chattingRoom.getLastMessage());
        //TODO ((TextView) view.findViewById(R.id.time)).setText(chattingRoom.getTime().toTime());
    }

    private void bindEvents(View view, ChattingRoom chattingRoom) {
        view.setOnClickListener(v -> Util.startActivity(activity, ChattingActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP, "chattingRoom", chattingRoom));
    }
}