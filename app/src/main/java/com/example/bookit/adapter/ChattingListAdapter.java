package com.example.bookit.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.domain.ChattingRoom;

import java.util.List;

public class ChattingListAdapter extends BaseAdapter {
    private Activity activity;
    private List<ChattingRoom> chattingRoomList;

    public ChattingListAdapter(Activity activity, List<ChattingRoom> chattingRoomList) {
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
        View view = ((LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_chatting_list_item, parent, false);
        ChattingRoom chattingRoom = chattingRoomList.get(position);

        ((TextView) view.findViewById(R.id.name)).setText(chattingRoom.getName());
        ((TextView) view.findViewById(R.id.message)).setText(chattingRoom.getMessage());
        //((TextView) view.findViewById(R.id.time)).setText(chattingRoom.getTime().toTime());

        return view;
    }
}