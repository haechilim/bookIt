package com.example.bookit.activity.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.bookit.R;
import com.example.bookit.activity.helper.Util;

public class FragmentCommunity extends Fragment {
    private View view;
    private FragmentActivity fragmentActivity;
    private FragmentMarket fragmentMarket;

    public FragmentCommunity(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_community, container, false);

        init();
        bindEvents();

        return view;
    }

    private void init() {
        fragmentMarket = new FragmentMarket(fragmentActivity);

        //Util.transactionFragment(fragmentActivity, R.id.communityFrameLayout, fragmentMarket);
    }

    private void bindEvents() {
        view.findViewById(R.id.market).setOnClickListener(v -> Util.transactionFragment(fragmentActivity, R.id.communityFrameLayout, fragmentMarket));
    }
}
