package com.example.bookit.activity.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.bookit.R;
import com.example.bookit.activity.domain.Debate;

import java.util.List;

public class DebateListAdapter extends BaseAdapter {
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
        View view = ((LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_debate_list_item, parent, false);

        return view;
    }
}
