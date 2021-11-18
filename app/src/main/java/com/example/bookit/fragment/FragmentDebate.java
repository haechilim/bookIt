package com.example.bookit.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.bookit.R;
import com.example.bookit.activity.WriteDebateActivity;
import com.example.bookit.adapter.DebateListAdapter;
import com.example.bookit.domain.Debate;
import com.example.bookit.domain.User;
import com.example.bookit.helper.Util;
import com.example.bookit.manager.ApiManager;

import java.util.ArrayList;
import java.util.List;

public class FragmentDebate extends Fragment {
    private Activity activity;

    public FragmentDebate(Activity activity) {
        this.activity = activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_debate, container, false);

        initList(view);
        bindEvents(view);

        return view;
    }

    private void initList(View view) {
        ApiManager.getDebates(debateList -> {
            Log.d("haechilim", debateList.toString());

            ListView listView = view.findViewById(R.id.debateList);
            DebateListAdapter adapter = new DebateListAdapter(activity, debateList);
            listView.setAdapter(adapter);
        });
    }

    private void bindEvents(View view) {
        view.findViewById(R.id.addButton).setOnClickListener(v -> Util.startActivity(activity, WriteDebateActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}
