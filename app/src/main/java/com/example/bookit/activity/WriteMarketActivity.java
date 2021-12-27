package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Fragment;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.example.bookit.R;
import com.example.bookit.domain.Category;
import com.example.bookit.domain.Market;
import com.example.bookit.domain.StatusBook;
import com.example.bookit.fragment.FragmentMarket;
import com.example.bookit.helper.Util;
import com.example.bookit.manager.ApiManager;

import java.io.InputStream;

public class WriteMarketActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 0;

    private EditText titleView;
    private Spinner categorySpinner;
    private Spinner statusSpinner;
    private EditText priceView;
    private EditText contentsView;

    private ImageView[] imageViews = new ImageView[3];
    private int currentImageViewIndex = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_market);

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
                    Bitmap img = BitmapFactory.decodeStream(in);
                    in.close();
                    addImage(img);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        }
    }

    private void init() {
        imageViews[0] = findViewById(R.id.image1);
        imageViews[1] = findViewById(R.id.image2);
        imageViews[2] = findViewById(R.id.image3);

        titleView = findViewById(R.id.title);
        categorySpinner = findViewById(R.id.category);
        statusSpinner = findViewById(R.id.status);
        priceView = findViewById(R.id.price);
        contentsView = findViewById(R.id.contents);

        categorySpinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, Category.CATEGORY_LIST));
        statusSpinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, Market.STATUS_LIST));
    }

    private void bindEvents() {
        findViewById(R.id.cancel).setOnClickListener(v -> {
            FragmentMarket.updateList();
            finish();
        });

        findViewById(R.id.addImage).setOnClickListener(v -> {
            if(currentImageViewIndex >= imageViews.length) {
                Util.toast(this, "사진은 최대 3장만 업로드 할 수 있습니다.", false);
                return;
            }

            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent, REQUEST_CODE);
        });

        findViewById(R.id.upload).setOnClickListener(v -> {
            Bitmap bitmap = null;
            if(imageViews[0].getDrawable() != null) bitmap = ((BitmapDrawable)imageViews[0].getDrawable()).getBitmap();
            String title = titleView.getText().toString().trim();
            Category category = (Category)categorySpinner.getSelectedItem();
            StatusBook status = (StatusBook)statusSpinner.getSelectedItem();
            int price = priceView.getText().toString().trim().isEmpty() ? 0 : Integer.parseInt(priceView.getText().toString().trim());
            String contents = contentsView.getText().toString().trim();

            if(bitmap == null) Util.toast(this, "이미지를 업로드 해주세요.", true);
            else if(title.isEmpty()) Util.toast(this, "제목을 입력해주세요.", true);
            else if(price == 0) Util.toast(this, "가격을 입력해주세요.", true);
            else if(contents.isEmpty()) Util.toast(this, "내용을 입력해주세요.", true);
            else {
                ApiManager.uploadMarketImage(bitmap, path -> ApiManager.writeMarket(path, title, category, status, price, contents, success -> FragmentMarket.updateList()));
                finish();
            }
        });
    }

    private void addImage(Bitmap img) {
        if(currentImageViewIndex < imageViews.length) {
            imageViews[currentImageViewIndex].setImageBitmap(img);
            imageViews[currentImageViewIndex++].setVisibility(View.VISIBLE);
        }
    }
}