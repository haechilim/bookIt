package com.example.bookit.adapter;

import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.domain.Category;

import java.util.List;

public class SelectNeedsGridAdapter extends BaseAdapter {
    private Activity activity;
    private List<Category> selectedCategories;

    public SelectNeedsGridAdapter(Activity activity, List<Category> selectedCategories) {
        this.activity = activity;
        this.selectedCategories = selectedCategories;
    }

    @Override
    public int getCount() {
        return Category.CATEGORY_LIST.length;
    }

    @Override
    public Object getItem(int position) {
        return Category.CATEGORY_LIST[position];
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Category category = Category.CATEGORY_LIST[position];
        View view = ((LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_grid_book, parent, false);

        initView(view, category);
        bindEvents(view, category);

        return view;
    }

    private void initView(View view, Category category) {
        ((ImageView)view.findViewById(R.id.image)).setImageResource(activity.getResources().getIdentifier("ex_book" + category.getId(), "drawable", activity.getPackageName()));
        ((TextView)view.findViewById(R.id.category)).setText(category.getName());
    }

    private void bindEvents(View view, Category category) {
        view.setOnClickListener(v -> {
            LinearLayout selected = view.findViewById(R.id.selected);

            if(selectedCategories.contains(category)) {
                selectedCategories.remove(category);
                selected.setVisibility(View.GONE);
            }
            else {
                selectedCategories.add(category);
                selected.setVisibility(View.VISIBLE);
            }
        });
    }
}
