package com.example.bookit.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.bookit.R;
import com.example.bookit.adapter.DebateListAdapter;
import com.example.bookit.domain.Comment;
import com.example.bookit.domain.Debate;
import com.example.bookit.domain.User;

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
        debateList.add(new Debate(new User("임준형"), 1, "aaa", "contents", false, false));
        debateList.add(new Debate(new User("아이유"), 1, "asasass", "contents", false, false));
        debateList.add(new Debate(new User("임준형"), 1, "aaa", "contents", false, false));
        debateList.add(new Debate(new User("임준형"), 1, "aaa", "contents", false, false));
        debateList.add(new Debate(new User("임준형"), 1, "aaa", "contents", false, false));
        debateList.add(new Debate(new User("임준형"), 1, "aaa", "contents", false, false));

        ListView listView = view.findViewById(R.id.debateList);
        listView.setAdapter(new DebateListAdapter(activity, debateList));

        return view;
    }
}
