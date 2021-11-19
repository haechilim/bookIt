package com.example.bookit.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.bumptech.glide.Glide;
import com.example.bookit.R;
import com.example.bookit.domain.User;
import com.example.bookit.manager.ApiManager;

import de.hdodenhof.circleimageview.CircleImageView;

public class UserView extends LinearLayout {
    private Context context;
    private User user;

    public UserView(Context context, User user, boolean isBig) {
        super(context);

        this.context = context;
        this.user = user;

        init(isBig);
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

    private void init(boolean isBig) {
        LayoutInflater layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = layoutInflater.inflate(isBig ? R.layout.layout_user_big : R.layout.layout_user, this, true);
        CircleImageView profileImage = view.findViewById(R.id.profileImage);
        TextView name = view.findViewById(R.id.name);

        Glide.with(this).load(ApiManager.HOST + user.getProfileImage()).into(profileImage);
        name.setText(user.getName());

        view.setOnClickListener(v -> {
            /*TODO Intent intent = new Intent(context, BookDetailActivity.class); 유저 상세 페이지 생성시 확인
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            intent.putExtra("user", user);
            context.startActivity(intent);*/
        });
    }
}
