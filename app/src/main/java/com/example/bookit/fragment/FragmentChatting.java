package com.example.bookit.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.bookit.R;
import com.example.bookit.adapter.ChattingRoomListAdapter;
import com.example.bookit.domain.Chatting;
import com.example.bookit.domain.ChattingRoom;
import com.example.bookit.domain.User;

import java.util.ArrayList;
import java.util.List;

public class FragmentChatting extends Fragment {
    private Activity activity;

    public FragmentChatting(Activity activity) {
        this.activity = activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chatting, container, false);

        initList(view);

        return view;
    }

    private void initList(View view) {
        List<Chatting> chattings = new ArrayList<>();
        chattings.add(new Chatting(new User("user"), "message"));

        List<ChattingRoom> chattingRoomList = new ArrayList<>();
        chattingRoomList.add(new ChattingRoom(new User("김선린"), "책 잘 받았습니다 감사합니다.", chattings));
        chattingRoomList.add(new ChattingRoom(new User("박선린"), "상태 어떤가요?", chattings));
        chattingRoomList.add(new ChattingRoom(new User("임선린"), "다음달 독서 토론은 줌으로!", chattings));
        chattingRoomList.add(new ChattingRoom(new User("독서왕"), "저도 그렇게 생각해요^^", chattings));
        chattingRoomList.add(new ChattingRoom(new User("김선린"), "책 잘 받았습니다 감사합니다.", chattings));
        chattingRoomList.add(new ChattingRoom(new User("박선린"), "상태 어떤가요?", chattings));
        chattingRoomList.add(new ChattingRoom(new User("임선린"), "다음달 독서 토론은 줌으로!", chattings));
        chattingRoomList.add(new ChattingRoom(new User("독서왕"), "저도 그렇게 생각해요^^", chattings));
        chattingRoomList.add(new ChattingRoom(new User("김선린"), "책 잘 받았습니다 감사합니다.", chattings));
        chattingRoomList.add(new ChattingRoom(new User("박선린"), "상태 어떤가요?", chattings));
        chattingRoomList.add(new ChattingRoom(new User("임선린"), "다음달 독서 토론은 줌으로!", chattings));
        chattingRoomList.add(new ChattingRoom(new User("독서왕"), "저도 그렇게 생각해요^^", chattings));
        chattingRoomList.add(new ChattingRoom(new User("김선린"), "책 잘 받았습니다 감사합니다.", chattings));
        chattingRoomList.add(new ChattingRoom(new User("박선린"), "상태 어떤가요?", chattings));
        chattingRoomList.add(new ChattingRoom(new User("임선린"), "다음달 독서 토론은 줌으로!", chattings));
        chattingRoomList.add(new ChattingRoom(new User("독서왕"), "저도 그렇게 생각해요^^", chattings));
        chattingRoomList.add(new ChattingRoom(new User("김선린"), "책 잘 받았습니다 감사합니다.", chattings));
        chattingRoomList.add(new ChattingRoom(new User("박선린"), "상태 어떤가요?", chattings));
        chattingRoomList.add(new ChattingRoom(new User("임선린"), "다음달 독서 토론은 줌으로!", chattings));
        chattingRoomList.add(new ChattingRoom(new User("독서왕"), "저도 그렇게 생각해요^^", chattings));

        ListView listView = view.findViewById(R.id.chattingList);
        listView.setAdapter(new ChattingRoomListAdapter(activity, chattingRoomList));
    }
}
