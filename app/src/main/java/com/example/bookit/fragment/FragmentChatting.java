package com.example.bookit.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.bookit.R;
import com.example.bookit.adapter.ChattingListAdapter;
import com.example.bookit.domain.ChattingRoom;

import java.util.ArrayList;
import java.util.List;

public class FragmentChatting extends Fragment {
    private Activity activity;

    public FragmentChatting(Activity activity) {
        this.activity = activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_chatting, container, false);

        List<ChattingRoom> chattingRoomList = new ArrayList<>();
        chattingRoomList.add(new ChattingRoom("김선린", "책 잘 받았습니다 감사합니다."));
        chattingRoomList.add(new ChattingRoom("박선린", "상태 어떤가요?"));
        chattingRoomList.add(new ChattingRoom("임선린", "다음달 독서 토론은 줌으로!"));
        chattingRoomList.add(new ChattingRoom("독서왕", "저도 그렇게 생각해요^^"));
        chattingRoomList.add(new ChattingRoom("김선린", "책 잘 받았습니다 감사합니다."));
        chattingRoomList.add(new ChattingRoom("박선린", "상태 어떤가요?"));
        chattingRoomList.add(new ChattingRoom("임선린", "다음달 독서 토론은 줌으로!"));
        chattingRoomList.add(new ChattingRoom("독서왕", "저도 그렇게 생각해요^^"));
        chattingRoomList.add(new ChattingRoom("김선린", "책 잘 받았습니다 감사합니다."));
        chattingRoomList.add(new ChattingRoom("박선린", "상태 어떤가요?"));
        chattingRoomList.add(new ChattingRoom("임선린", "다음달 독서 토론은 줌으로!"));
        chattingRoomList.add(new ChattingRoom("독서왕", "저도 그렇게 생각해요^^"));
        chattingRoomList.add(new ChattingRoom("김선린", "책 잘 받았습니다 감사합니다."));
        chattingRoomList.add(new ChattingRoom("박선린", "상태 어떤가요?"));
        chattingRoomList.add(new ChattingRoom("임선린", "다음달 독서 토론은 줌으로!"));
        chattingRoomList.add(new ChattingRoom("독서왕", "저도 그렇게 생각해요^^"));
        chattingRoomList.add(new ChattingRoom("김선린", "책 잘 받았습니다 감사합니다."));
        chattingRoomList.add(new ChattingRoom("박선린", "상태 어떤가요?"));
        chattingRoomList.add(new ChattingRoom("임선린", "다음달 독서 토론은 줌으로!"));
        chattingRoomList.add(new ChattingRoom("독서왕", "저도 그렇게 생각해요^^"));

        ListView listView = view.findViewById(R.id.chattingList);
        listView.setAdapter(new ChattingListAdapter(activity, chattingRoomList));

        return view;
    }
}
