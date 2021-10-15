package com.example.bookit.activity.helper;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import com.example.bookit.R;

public class Util {
    public static void transactionFragment(FragmentActivity activity, Fragment fragment) {
        activity.getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, fragment).commitAllowingStateLoss();
    }
}
