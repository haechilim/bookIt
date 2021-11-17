package com.example.bookit.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.bookit.R;
import com.example.bookit.domain.Book;
import com.example.bookit.manager.ApiManager;
import com.example.bookit.view.BookView;

import java.util.List;

public class FragmentHome extends Fragment {
    public static final int BOOK_COUNT_PER_LIST = 15;

    private LinearLayout recommendedItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recommendedItems = view.findViewById(R.id.recommendedItems);

        addRecommendedContainer(inflater, ApiManager.getUser().getName() + "님을 위한 추천 도서");
        addRecommendedContainer(inflater, "베스트 도서");

        return view;
    }

    private void addRecommendedContainer(LayoutInflater inflater, String title) {
        View recommendedBook = inflater.inflate(R.layout.layout_recommended_item, recommendedItems, false);
        LinearLayout itemsContainer = recommendedBook.findViewById(R.id.itemsContainer);

        ((TextView) recommendedBook.findViewById(R.id.title)).setText(title);

        ApiManager.bestSeller(BOOK_COUNT_PER_LIST, (bookList) -> {
            for(int i = 0; i < bookList.size(); i++) {
                itemsContainer.addView(new BookView(getContext(), bookList.get(i)));
            }
        });

        recommendedItems.addView(recommendedBook);
    }
}
