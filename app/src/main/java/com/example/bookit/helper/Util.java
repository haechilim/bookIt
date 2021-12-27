package com.example.bookit.helper;

import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.text.DecimalFormat;
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

    public static String getDateMessage(Calendar calendar) {
        long subTime = Calendar.getInstance().getTimeInMillis() - calendar.getTimeInMillis();

        if(subTime < 60000) return "방금 전";
        else if(subTime < 3600000) return subTime / 60000 + "분 전";
        else if(subTime < 86400000) return subTime / 3600000 + "시간 전";
        else if(subTime < 2592000000L) return subTime / 86400000 + "일 전";
        else if(subTime < 31104000000L) return subTime / 2592000000L + "달 전";
        else return subTime / 31104000000L + "년 전";
    }

    public static String getPriceMessage(int price) {
        return new DecimalFormat("###,### 원").format(price);
    }
}
