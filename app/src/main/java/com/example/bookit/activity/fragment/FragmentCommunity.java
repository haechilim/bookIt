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
    private FragmentActivity fragmentActivity;
    private FragmentMarket fragmentMarket;

    public FragmentCommunity(FragmentActivity fragmentActivity) {
        this.fragmentActivity = fragmentActivity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_community, container, false);

        fragmentMarket = new FragmentMarket();

        Util.transactionFragment(fragmentActivity, fragmentMarket);


        return view;
    }
}
