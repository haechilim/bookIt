package com.example.bookit.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.bookit.R;

public class FragmentHome extends Fragment {
    LinearLayout recommendedItems;

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
        itemsContainer.addView(inflater.inflate(R.layout.layout_book, itemsContainer, false));
        itemsContainer.addView(inflater.inflate(R.layout.layout_book, itemsContainer, false));
        itemsContainer.addView(inflater.inflate(R.layout.layout_book, itemsContainer, false));
        itemsContainer.addView(inflater.inflate(R.layout.layout_book, itemsContainer, false));
        itemsContainer.addView(inflater.inflate(R.layout.layout_book, itemsContainer, false));
        itemsContainer.addView(inflater.inflate(R.layout.layout_book, itemsContainer, false));

        recommendedItems.addView(recommendedBook);
    }
}
