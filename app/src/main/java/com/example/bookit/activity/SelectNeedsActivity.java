package com.example.bookit.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.GridView;

import com.example.bookit.R;
import com.example.bookit.adapter.SelectNeedsGridAdapter;
import com.example.bookit.domain.Category;
import com.example.bookit.helper.Util;

import java.util.ArrayList;
import java.util.List;

public class SelectNeedsActivity extends AppCompatActivity {
    private List<Category> selectedCategories = new ArrayList<>();

    private GridView selectNeedsGrid;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_needs);

        init();
        bindEvents();
    }

    private void init() {
        selectNeedsGrid = findViewById(R.id.selectNeedsGrid);

        selectNeedsGrid.setAdapter(new SelectNeedsGridAdapter(this, selectedCategories));
    }

    private void bindEvents() {
        findViewById(R.id.startButton).setOnClickListener(v -> {
            if(selectedCategories.isEmpty()) {
                Util.toast(this, "최소 1개 이상의 취향을 선택해주세요.", false);
                return;
            }

            Util.startActivity(this, SignupCompleatActivity.class, Intent.FLAG_ACTIVITY_CLEAR_TOP);
        });
    }
}