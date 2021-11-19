package com.example.bookit.helper;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.util.Calendar;

public class Util {
    public static void transactionFragment(FragmentActivity activity, int id, Fragment fragment) {
        activity.getSupportFragmentManager().beginTransaction().replace(id, fragment).commitAllowingStateLoss();
    }

    public static void toast(Context context, String message, boolean isShort) {
        Toast.makeText(context, message, isShort ? Toast.LENGTH_SHORT : Toast.LENGTH_LONG).show();
    }

    public static void startActivity(Context context, Class target, int flag) {
        Intent intent = new Intent(context, target);
        intent.setFlags(flag);
        context.startActivity(intent);
    }

    public static void startActivity(Context context, Class target, int flag, String name, Serializable object) {
        Intent intent = new Intent(context, target);
        intent.setFlags(flag);
        intent.putExtra(name, object);
        context.startActivity(intent);
    }

    public static Calendar getCalenderByMillis(long millis) {
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(millis);

        return calendar;
    }

    public static String encode(String string) {
        try {
            return URLEncoder.encode(string, "utf-8").replace("+", " ");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        return "";
    }
}
