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

        ((TextView) view.findViewById(R.id.title)).setText(marketBook.getBook().getTitle());
        ((TextView) view.findViewById(R.id.status)).setText(getStatusMessage(marketBook.getStatus()));
        ((TextView) view.findViewById(R.id.price)).setText(getPriceMessage(marketBook.getPrice()));
        ((TextView) view.findViewById(R.id.time)).setText("10초전");

        return view;
    }

    private String getStatusMessage(int status) {
        switch (status) {
            case MarketBook.STATUS_BEST:
                return "상태: 최상";

            case MarketBook.STATUS_GOOD:
                return "상태: 상";

            case MarketBook.STATUS_AVERAGE:
                return "상태: 중";

            case MarketBook.STATUS_BAD:
                return "상태: 하";

            case MarketBook.STATUS_LOWEST:
                return "상태: 최하";
        }

        return "";
    }

    private String getPriceMessage(int price) {
        return new DecimalFormat("###,### 원").format(price);
    }
}
