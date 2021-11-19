package com.example.bookit.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.bookit.R;
import com.example.bookit.activity.WriteMarketActivity;
import com.example.bookit.adapter.MarketListAdapter;
import com.example.bookit.helper.Util;
import com.example.bookit.manager.ApiManager;

public class FragmentMarket extends Fragment {
    private static Activity activity;
    private static View view;

    public FragmentMarket(Activity activity) {
        this.activity = activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_market, container, false);

        updateList();
        bindEvents(view);

        return view;
    }

    public static void updateList() {
        ApiManager.getMarkets(marketList -> {
            ListView listView = view.findViewById(R.id.marketList);
            listView.setAdapter(new MarketListAdapter(activity, marketList));
        });
    }

    private void bindEvents(View view) {
        view.findViewById(R.id.addButton).setOnClickListener(v -> Util.startActivity(activity, WriteMarketActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}
