package com.example.bookit.view;

import android.content.Context;
import android.content.Intent;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.example.bookit.R;
import com.example.bookit.activity.BookDetailActivity;
import com.example.bookit.domain.User;

public class UserView extends LinearLayout {
    private Context context;
    private User user;

    public UserView(Context context, User user) {
        super(context);
        this.context = context;
        this.user = user;

        init();
    }

    public UserView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public UserView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public UserView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    private void init() {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(R.layout.layout_user, this, true);

        ((TextView)view.findViewById(R.id.name)).setText(user.getName());

        view.setOnClickListener(v -> {
            Log.d("haechilim", user.toString());
        });
    }
}
