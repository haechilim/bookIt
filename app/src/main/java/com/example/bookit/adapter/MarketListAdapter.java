package com.example.bookit.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.domain.MarketBook;

import java.text.DecimalFormat;
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
        MarketBook marketBook = marketBookList.get(position);
        View view = ((LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_market_list_item, parent, false);

        init(view, marketBook);
        bindEvents(view);

        return view;
    }

    private void init(View view, MarketBook marketBook) {
        ((TextView) view.findViewById(R.id.title)).setText(marketBook.getBook().getTitle());
        ((TextView) view.findViewById(R.id.status)).setText(marketBook.getStatus().getMessage());
        ((TextView) view.findViewById(R.id.price)).setText(getPriceMessage(marketBook.getPrice()));
        ((TextView) view.findViewById(R.id.time)).setText("10초전"); //TODO 시간 가져오기
    }

    private void bindEvents(View view) {
        view.setOnClickListener(v -> {

        });
    }

    private String getPriceMessage(int price) {
        return new DecimalFormat("###,### 원").format(price);
    }
}
