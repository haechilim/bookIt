package com.example.bookit.activity.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.bookit.R;
import com.example.bookit.activity.adapter.DebateListAdapter;
import com.example.bookit.activity.domain.Comment;
import com.example.bookit.activity.domain.Debate;
import com.example.bookit.activity.domain.User;

import java.util.ArrayList;
import java.util.List;

public class FragmentDebate extends Fragment {
    private Activity activity;

    public FragmentDebate(Activity activity) {
        this.activity = activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_debate, container, false);

        List<Debate> debateList = new ArrayList<>();
        debateList.add(new Debate(new User(), 1, "aaa", "contents", 11, 2));
        debateList.add(new Debate(new User(), 1, "aaa", "contents", 11, 2));
        debateList.add(new Debate(new User(), 1, "aaa", "contents", 11, 2));
        debateList.add(new Debate(new User(), 1, "aaa", "contents", 11, 2));
        debateList.add(new Debate(new User(), 1, "aaa", "contents", 11, 2));

        ListView listView = view.findViewById(R.id.debateList);
        listView.setAdapter(new DebateListAdapter(activity, debateList));

        return view;
    }
}