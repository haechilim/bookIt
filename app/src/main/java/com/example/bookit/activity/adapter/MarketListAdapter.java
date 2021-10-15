package com.example.bookit.activity.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import com.example.bookit.R;
import com.example.bookit.activity.domain.MarketBook;

import java.util.List;

public class MarketListAdapter extends BaseAdapter {
    private Activity activity;
    private List<MarketBook> marketBookList;

    public MarketListAdapter(Activity activity, List<MarketBook> marketBookList) {
        this.activity = activity;
        this.marketBookList = marketBookList;
    }

    @Override
    public int getCount() {
        return marketBookList.size();
    }

    @Override
    public Object getItem(int position) {
        return marketBookList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = ((LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_market_list_item, parent, false);

        return view;
    }
}
