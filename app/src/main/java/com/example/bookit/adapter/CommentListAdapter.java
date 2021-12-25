package com.example.bookit.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.bookit.R;
import com.example.bookit.domain.Comment;
import com.example.bookit.domain.Debate;
import com.example.bookit.view.UserView;

import org.w3c.dom.Text;

import java.util.List;

public class CommentListAdapter extends BaseAdapter {
    private Activity activity;
    private List<Comment> commentList;

    public CommentListAdapter(Activity activity, List<Comment> commentList) {
        this.activity = activity;
        this.commentList = commentList;
    }

    @Override
    public int getCount() {
        return commentList.size();
    }

    @Override
    public Object getItem(int position) {
        return commentList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Comment comment = commentList.get(position);
        View view = ((LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE)).inflate(R.layout.layout_comment_list_item, parent, false);

        LinearLayout userContainer = view.findViewById(R.id.userContainer);
        TextView contents = view.findViewById(R.id.contents);

        userContainer.addView(new UserView(activity, comment.getUser(), false));
        contents.setText(comment.getContents());

        return view;
    }
}
