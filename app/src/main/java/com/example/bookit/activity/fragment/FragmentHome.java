package com.example.bookit.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.fragment.app.Fragment;

import com.example.bookit.R;

public class FragmentHome extends Fragment {
    LinearLayout recommendedItems;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        recommendedItems = view.findViewById(R.id.recommendedItems);
        recommendedItems.addView(inflater.inflate(R.layout.layout_recommended_item, recommendedItems, false));
        recommendedItems.addView(inflater.inflate(R.layout.layout_recommended_item, recommendedItems, false));

        return view;
    }
}
