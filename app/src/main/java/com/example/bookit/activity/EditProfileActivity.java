package com.example.bookit.activity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.bookit.R;
import com.example.bookit.domain.User;
import com.example.bookit.fragment.FragmentDebate;
import com.example.bookit.fragment.FragmentMarket;
import com.example.bookit.fragment.FragmentMy;
import com.example.bookit.fragment.FragmentReadingDiary;
import com.example.bookit.manager.ApiManager;

import java.io.InputStream;

import de.hdodenhof.circleimageview.CircleImageView;

public class EditProfileActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 0;

    private User user;

    private CircleImageView profileImage;
    private EditText nameView;
    private Bitmap image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        init();
        bindEvents();
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == REQUEST_CODE) {
            if (resultCode == RESULT_OK) {
                try {
                    InputStream in = getContentResolver().openInputStream(data.getData());
                    image = BitmapFactory.decodeStream(in);
                    in.close();

                    profileImage.setImageBitmap(image);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        }
    }

    private void init() {
        user = ApiManager.getUser();
        profileImage = findViewById(R.id.profileImage);
        nameView = findViewById(R.id.name);

        Glide.with(this).load(ApiManager.HOST + user.getProfileImage()).into(profileImage);
        nameView.setText(user.getName());
    }

    private void bindEvents() {
        findViewById(R.id.back).setOnClickListener(v -> finish());

        findViewById(R.id.changeProfileImage).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent, REQUEST_CODE);
        });

        findViewById(R.id.editProfileButton).setOnClickListener(v -> {
            String name = nameView.getText().toString().trim();

            if(name.isEmpty()) return;
            else user.setName(name);

            if(image != null) {
                ApiManager.uploadImage(image, path -> {
                    user.setProfileImage(path);

                    editProfile();
                });
            }

            editProfile();
        });
    }

    private void editProfile() {
        ApiManager.editProfile(user.getProfileImage(), user.getName(), success -> {
            FragmentDebate.updateList();
            FragmentMarket.updateList();
            FragmentReadingDiary.updateList();
            FragmentMy.update();
            finish();
        });
    }
}