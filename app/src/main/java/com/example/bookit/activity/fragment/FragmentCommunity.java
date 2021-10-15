package com.example.bookit.activity.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.bookit.R;
import com.example.bookit.activity.helper.Util;

public class FragmentCommunity extends Fragment {
    private View view;
    private FragmentActivity fragmentActivity;
    private FragmentMarket fragmentMarket;
    private TextView debate;
    private TextView market;

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
        debate = view.findViewById(R.id.debate);
        market = view.findViewById(R.id.market);

        //Util.transactionFragment(fragmentActivity, R.id.communityFrameLayout, fragmentMarket);
        selectedDebateButton();
    }

    private void bindEvents() {
        debate.setOnClickListener(v -> {
            //Util.transactionFragment(fragmentActivity, R.id.communityFrameLayout, fragmentMarket);
            selectedDebateButton();
        });

        market.setOnClickListener(v -> {
            Util.transactionFragment(fragmentActivity, R.id.communityFrameLayout, fragmentMarket);
            selectedMarketButton();
        });
    }

    private void resetButtons() {
        debate.setBackground(ContextCompat.getDrawable(fragmentActivity, R.drawable.layout_border_bottom));
        debate.setTextColor(Color.rgb(0x9e, 0x9e, 0x9e));
        market.setBackground(ContextCompat.getDrawable(fragmentActivity, R.drawable.layout_border_bottom));
        market.setTextColor(Color.rgb(0x9e, 0x9e, 0x9e));
    }

    private void selectedDebateButton() {
        resetButtons();
        debate.setBackground(ContextCompat.getDrawable(fragmentActivity, R.drawable.layout_border_bottom_color));
        debate.setTextColor(Color.rgb(0xff, 0xd1, 0x8d));
    }

    private void selectedMarketButton() {
        resetButtons();
        market.setBackground(ContextCompat.getDrawable(fragmentActivity, R.drawable.layout_border_bottom_color));
        market.setTextColor(Color.rgb(0xff, 0xd1, 0x8d));
    }
}
