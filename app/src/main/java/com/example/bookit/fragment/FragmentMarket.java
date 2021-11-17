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
import com.example.bookit.domain.Book;
import com.example.bookit.domain.MarketBook;
import com.example.bookit.domain.User;
import com.example.bookit.helper.Util;

import java.util.ArrayList;
import java.util.List;

public class FragmentMarket extends Fragment {
    private Activity activity;

    public FragmentMarket(Activity activity) {
        this.activity = activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_market, container, false);

        initList(view);
        bindEvents(view);

        return view;
    }

    private void initList(View view) {
        List<MarketBook> marketBookList = new ArrayList<>();
        /*marketBookList.add(new MarketBook(new User("임준형"), new Book("비전공자를 위한 이해할 수 있는 IT 지식", "최원영", "9791196918033", "T.W.I.G"), MarketBook.STATUS_LIST[1], 10));
        marketBookList.add(new MarketBook(new User("임준형"), new Book("비전공자를 위한 이해할 수 있는 IT 지식", "최원영", "9791196918033", "T.W.I.G"), MarketBook.STATUS_LIST[1], 100));
        marketBookList.add(new MarketBook(new User("임준형"), new Book("비전공자를 위한 이해할 수 있는 IT 지식", "최원영", "9791196918033", "T.W.I.G"), MarketBook.STATUS_LIST[1], 8999000));
        marketBookList.add(new MarketBook(new User("임준형"), new Book("비전공자를 위한 이해할 수 있는 IT 지식", "최원영", "9791196918033", "T.W.I.G"), MarketBook.STATUS_LIST[1], 6000));
        marketBookList.add(new MarketBook(new User("임준형"), new Book("비전공자를 위한 이해할 수 있는 IT 지식", "최원영", "9791196918033", "T.W.I.G"), MarketBook.STATUS_LIST[1], 12000));
        marketBookList.add(new MarketBook(new User("임준형"), new Book("비전공자를 위한 이해할 수 있는 IT 지식", "최원영", "9791196918033", "T.W.I.G"), MarketBook.STATUS_LIST[1], 16000));*/

        ListView listView = view.findViewById(R.id.marketList);
        listView.setAdapter(new MarketListAdapter(activity, marketBookList));
    }

    private void bindEvents(View view) {
        view.findViewById(R.id.addButton).setOnClickListener(v -> Util.startActivity(activity, WriteMarketActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}
