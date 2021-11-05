package com.example.bookit.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.bookit.R;
import com.example.bookit.domain.Book;
import com.example.bookit.view.BookView;

public class FragmentHome extends Fragment {
    private LinearLayout recommendedItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recommendedItems = view.findViewById(R.id.recommendedItems);

        addRecommendedContainer(inflater, "ㅇㅇ님을 위한 추천 도서");
        addRecommendedContainer(inflater, "베스트 도서");

        return view;
    }

    private void addRecommendedContainer(LayoutInflater inflater, String title) {
        View recommendedBook = inflater.inflate(R.layout.layout_recommended_item, recommendedItems, false);
        LinearLayout itemsContainer = recommendedBook.findViewById(R.id.itemsContainer);

        ((TextView) recommendedBook.findViewById(R.id.title)).setText(title);
        itemsContainer.addView(new BookView(getContext(), new Book("비전공자를")));
        itemsContainer.addView(new BookView(getContext(), new Book("위한")));
        itemsContainer.addView(new BookView(getContext(), new Book("전공 서적!")));
        itemsContainer.addView(new BookView(getContext(), new Book("책1")));
        itemsContainer.addView(new BookView(getContext(), new Book("책2")));
        itemsContainer.addView(new BookView(getContext(), new Book("책3")));

        recommendedItems.addView(recommendedBook);
    }
}
