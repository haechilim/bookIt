package com.example.bookit.fragment;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.bumptech.glide.Glide;
import com.example.bookit.R;
import com.example.bookit.activity.EditProfileActivity;
import com.example.bookit.domain.User;
import com.example.bookit.helper.Util;
import com.example.bookit.manager.ApiManager;

import de.hdodenhof.circleimageview.CircleImageView;

public class FragmentMy extends Fragment {
    private static Activity activity;
    private static CircleImageView profileImage;
    private static TextView name;
    private static TextView loginId;

    public FragmentMy(Activity activity) {
        this.activity = activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
         View view = inflater.inflate(R.layout.fragment_my, container, false);

         init(view);
         bindEvents(view);

        return view;
    }

    public static void update() {
        User user = ApiManager.getUser();

        Glide.with(activity).load(ApiManager.HOST + user.getProfileImage()).into(profileImage);
        name.setText(user.getName());
        loginId.setText(user.getLoginId());
    }

    private void init(View view) {
        profileImage = view.findViewById(R.id.profileImage);
        name = view.findViewById(R.id.name);
        loginId = view.findViewById(R.id.loginId);

        update();
    }

    private void bindEvents(View view) {
        view.findViewById(R.id.editProfile).setOnClickListener(v -> Util.startActivity(getContext(), EditProfileActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP));
    }
}
