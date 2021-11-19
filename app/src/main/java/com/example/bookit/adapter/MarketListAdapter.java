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
import com.example.bookit.activity.MarketDetailActivity;
import com.example.bookit.domain.Market;
import com.example.bookit.helper.Util;

import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class MarketListAdapter extends BaseAdapter {
    private Activity activity;
    private List<Market> marketList;

    public MarketListAdapter(Activity activity, List<Market> marketList) {
        this.activity = activity;
        this.marketList = marketList;
    }

    @Override
    public int getCount() {
        return marketList.size();
    }

    @Override
    public Object getItem(int position) {
        return marketList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Market market = marketList.get(position);
        View view = ((LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_market_list_item, parent, false);

        init(view, market);
        bindEvents(view, market);

        return view;
    }

    private void init(View view, Market market) {
        ((TextView) view.findViewById(R.id.title)).setText(market.getTitle());
        ((TextView) view.findViewById(R.id.status)).setText(market.getStatus().getMessage());
        ((TextView) view.findViewById(R.id.price)).setText(getPriceMessage(market.getPrice()));
        ((TextView) view.findViewById(R.id.date)).setText(getDateMessage(market.getDate()));
    }

    private void bindEvents(View view, Market market) {
        view.setOnClickListener(v -> Util.startActivity(activity, MarketDetailActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP, "marketBook", market));
    }

    private String getDateMessage(Calendar calendar) {
        long subTime = Calendar.getInstance().getTimeInMillis() - calendar.getTimeInMillis();

        if(subTime < 60000) return "방금 전";
        else if(subTime < 3600000) return subTime / 60000 + "분 전";
        else if(subTime < 86400000) return subTime / 3600000 + "시간 전";
        else if(subTime < 2592000000L) return subTime / 86400000 + "일 전";
        else if(subTime < 31104000000L) return subTime / 2592000000L + "달 전";
        else return subTime / 31104000000L + "년 전";
    }

    private String getPriceMessage(int price) {
        return new DecimalFormat("###,### 원").format(price);
    }
}
