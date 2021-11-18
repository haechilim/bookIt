package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.domain.Category;
import com.example.bookit.domain.MarketBook;
import com.example.bookit.domain.StatusBook;
import com.example.bookit.manager.ApiManager;

import org.w3c.dom.Text;

import java.io.InputStream;
import java.util.Collections;

public class WriteMarketActivity extends AppCompatActivity {
    private static final int REQUEST_CODE = 0;

    private ImageView image1;
    private ImageView image2;
    private ImageView image3;

    private EditText titleView;
    private Spinner categorySpinner;
    private Spinner statusSpinner;
    private EditText priceView;
    private EditText contentsView;


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
                    Log.d("haechilim", img.toString());

                    image1.setImageBitmap(img);
                } catch (Exception e) {
                    e.getStackTrace();
                }
            }
        }
    }

    private void init() {
        image1 = findViewById(R.id.image1);
        image2 = findViewById(R.id.image2);
        image3 = findViewById(R.id.image3);

        titleView = findViewById(R.id.title);
        categorySpinner = findViewById(R.id.category);
        statusSpinner = findViewById(R.id.status);
        priceView = findViewById(R.id.price);
        contentsView = findViewById(R.id.contents);

        categorySpinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, Category.CATEGORY_LIST));
        statusSpinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, MarketBook.STATUS_LIST));
    }

    private void bindEvents() {
        findViewById(R.id.cancel).setOnClickListener(v -> finish());

        findViewById(R.id.addImage).setOnClickListener(v -> {
            Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
            intent.setType("image/*");
            startActivityForResult(intent, REQUEST_CODE);
        });

        findViewById(R.id.upload).setOnClickListener(v -> {
            String title = titleView.getText().toString().trim();
            Category category = (Category)categorySpinner.getSelectedItem();
            StatusBook status = (StatusBook)statusSpinner.getSelectedItem();
            int price = Integer.parseInt(priceView.getText().toString().trim());
            String contents = contentsView.getText().toString().trim();

            ApiManager.writeMarket(title, category, status, price, contents, success -> {
                finish();
            });
        });
    }
}