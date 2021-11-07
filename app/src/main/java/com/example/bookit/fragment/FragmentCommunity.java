package com.example.bookit.fragment;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.content.ContextCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.bookit.R;
import com.example.bookit.helper.Util;

public class FragmentCommunity extends Fragment {
    private View view;

    private FragmentActivity fragmentActivity;
    private FragmentMarket fragmentMarket;
    private FragmentDebate fragmentDebate;

    private LinearLayout frameDebate;
    private LinearLayout frameMarket;

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
        fragmentDebate = new FragmentDebate(fragmentActivity);
        fragmentMarket = new FragmentMarket(fragmentActivity);

        frameDebate = view.findViewById(R.id.frameDebate);
        frameMarket = view.findViewById(R.id.frameMarket);

        debate = view.findViewById(R.id.debate);
        market = view.findViewById(R.id.market);

        Util.transactionFragment(fragmentActivity, R.id.frameDebate, fragmentDebate);
        Util.transactionFragment(fragmentActivity, R.id.frameMarket, fragmentMarket);

        clickedDebate();
    }

    private void bindEvents() {
        debate.setOnClickListener(v -> clickedDebate());

        market.setOnClickListener(v -> clickedMarket());
    }

    private void clickedDebate() {
        showFrameDebate();
        selectedDebateButton();
    }

    private void clickedMarket() {
        showFrameMarket();
        selectedMarketButton();
    }

    private void showFrameDebate() {
        resetFrames();
        frameDebate.setVisibility(View.VISIBLE);
    }

    private void showFrameMarket() {
        resetFrames();
        frameMarket.setVisibility(View.VISIBLE);
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

    private void resetFrames() {
        frameDebate.setVisibility(View.INVISIBLE);
        frameMarket.setVisibility(View.INVISIBLE);
    }

    private void resetButtons() {
        debate.setBackground(ContextCompat.getDrawable(fragmentActivity, R.drawable.layout_border_bottom));
        debate.setTextColor(Color.rgb(0x9e, 0x9e, 0x9e));
        market.setBackground(ContextCompat.getDrawable(fragmentActivity, R.drawable.layout_border_bottom));
        market.setTextColor(Color.rgb(0x9e, 0x9e, 0x9e));
    }
}
