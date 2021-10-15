package com.example.bookit.activity.helper;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

public class Util {
    public static void transactionFragment(FragmentActivity activity, int id, Fragment fragment) {
        activity.getSupportFragmentManager().beginTransaction().replace(id, fragment).commitAllowingStateLoss();
    }
}
