package com.example.bookit.activity.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.bookit.R;
import com.example.bookit.activity.adapter.MarketListAdapter;
import com.example.bookit.activity.domain.Book;
import com.example.bookit.activity.domain.MarketBook;

import java.util.ArrayList;
import java.util.List;

public class FragmentMarket extends Fragment {
    private Activity activity;
    private ListView listView;

    public FragmentMarket(Activity activity) {
        this.activity = activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_market, container, false);

        List<MarketBook> marketBookList = new ArrayList<>();
        marketBookList.add(new MarketBook(new Book("비전공자를 위한 이해할 수 있는 IT 지식", "최원영", "9791196918033", "T.W.I.G"), 1, 8000));
        marketBookList.add(new MarketBook(new Book("비전공자를 위한 이해할 수 있는 IT 지식", "최원영", "9791196918033", "T.W.I.G"), 1, 8000));
        marketBookList.add(new MarketBook(new Book("비전공자를 위한 이해할 수 있는 IT 지식", "최원영", "9791196918033", "T.W.I.G"), 1, 8000));
        marketBookList.add(new MarketBook(new Book("비전공자를 위한 이해할 수 있는 IT 지식", "최원영", "9791196918033", "T.W.I.G"), 1, 8000));
        marketBookList.add(new MarketBook(new Book("비전공자를 위한 이해할 수 있는 IT 지식", "최원영", "9791196918033", "T.W.I.G"), 1, 8000));
        marketBookList.add(new MarketBook(new Book("비전공자를 위한 이해할 수 있는 IT 지식", "최원영", "9791196918033", "T.W.I.G"), 1, 8000));

        listView = view.findViewById(R.id.marketList);
        listView.setAdapter(new MarketListAdapter(activity, marketBookList));

        return view;
    }
}
