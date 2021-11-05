package com.example.bookit.fragment;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import androidx.fragment.app.Fragment;

import com.example.bookit.R;
import com.example.bookit.adapter.ReadingDiaryListAdepter;
import com.example.bookit.domain.ReadingDiary;

import java.util.ArrayList;
import java.util.List;

public class FragmentReadingDiary extends Fragment {
    private Activity activity;

    public FragmentReadingDiary(Activity activity) {
        this.activity = activity;
    }

    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_reading_diary, container, false);

        List<ReadingDiary> readingDiaryList = new ArrayList<>();
        readingDiaryList.add(new ReadingDiary("트렌코리아", "디자이너로서 트렌드를 파악하는 것이 중요하다고 생각해서 매년 버전이 나올 때마다 읽고 있다. 트렌드는 어떤가"));
        readingDiaryList.add(new ReadingDiary("트렌드코리아", "생각해서 매년 버전이 나올 때마다 읽고 있다. 트렌드는 어떤가 디자이너로서 트렌드를 파악하는 것이 중요하다고"));
        readingDiaryList.add(new ReadingDiary("트렌드코리아", "디자이너로서 트렌드를 파악하는 것이 중요하다고 생각해서 매년 버전이 나올 때마다 읽고 있다. 트렌드는 어떤가"));
        readingDiaryList.add(new ReadingDiary("트렌드코리아", "디자이너로서 트렌드를 파악하는 것이 중요하다고 생각해서 매년 버전이 나올 때마다 읽고 있다. 트렌드는 어떤가"));
        readingDiaryList.add(new ReadingDiary("트렌드코리아", "디자이너로서 트렌드를 파악하는 것이 중요하다고 생각해서 매년 버전이 나올 때마다 읽고 있다. 트렌드는 어떤가"));
        readingDiaryList.add(new ReadingDiary("트렌드코리아", "디자이너로서 트렌드를 파악하는 것이 중요하다고 생각해서 매년 버전이 나올 때마다 읽고 있다. 트렌드는 어떤가"));

        ListView listView = view.findViewById(R.id.readingDiaryList);
        listView.setAdapter(new ReadingDiaryListAdepter(activity, readingDiaryList));

        return view;
    }
}
