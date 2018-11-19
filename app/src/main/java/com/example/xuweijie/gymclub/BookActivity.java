package com.example.xuweijie.gymclub;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class BookActivity extends AppCompatActivity {
    private List<Video> mData = null;
    private Context mContext;
    private VideoAdapter mAdapter = null;
    private ListView list_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book);

        mContext = BookActivity.this;
        list_video = (ListView) findViewById(R.id.list_videos);
        mData = new LinkedList<Video>();
        mData.add(new Video(R.mipmap.video0, "一个喝酒的沉默男人", "喝酒","点击量：1"));
        mData.add(new Video(R.mipmap.video1, "致命暗杀", "暗杀","点击量：10"));
        mAdapter = new VideoAdapter((LinkedList<Video>) mData, mContext);
        list_video.setAdapter(mAdapter);
    }
}
