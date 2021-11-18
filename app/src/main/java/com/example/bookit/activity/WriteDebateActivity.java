package com.example.bookit.activity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import com.example.bookit.R;
import com.example.bookit.domain.Category;
import com.example.bookit.fragment.FragmentDebate;
import com.example.bookit.helper.Util;
import com.example.bookit.manager.ApiManager;

import org.w3c.dom.Text;

import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;

public class WriteDebateActivity extends AppCompatActivity {
    private Spinner categorySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_write_debate);

        init();
        bindEvents();
    }

    private void init() {
        categorySpinner = findViewById(R.id.category);
        categorySpinner.setAdapter(new ArrayAdapter(this, android.R.layout.simple_spinner_item, Category.CATEGORY_LIST));
    }

    private void bindEvents() {
         findViewById(R.id.cancel).setOnClickListener(v -> finish());

         findViewById(R.id.upload).setOnClickListener(v -> {
             String title = ((EditText)findViewById(R.id.title)).getText().toString();
             int category = ((Category)categorySpinner.getSelectedItem()).getId();
             String contents = ((EditText)findViewById(R.id.contents)).getText().toString();

             try {
                 title = URLEncoder.encode(title, "utf-8").replace("+", " ");
                 contents = URLEncoder.encode(contents, "utf-8").replace("+", " ");
             } catch (UnsupportedEncodingException e) {
                 e.printStackTrace();
             }

             ApiManager.writeDebate(title, category, contents, success -> {
                 if(!success) return;

                 FragmentDebate.updateList();
                 Util.toast(this, "새로운 독서 토론이 등록 되었습니다.", true);
                 finish();
             });
         });
    }
}