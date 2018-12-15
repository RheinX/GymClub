package com.example.xuweijie.gymclub;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class ActiclesActivity extends AppCompatActivity {
    private List<Video> mData = null;
    private Context mContext;
    private VideoAdapter mAdapter = null;
    private ListView list_video;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_acticles);

        mContext = ActiclesActivity.this;
        list_video = (ListView) findViewById(R.id.list_videos);
        mData = new LinkedList<Video>();

        AppDatabase db = Room.databaseBuilder(getApplicationContext(), AppDatabase.class, "gymclub").allowMainThreadQueries().build();
        ArticleDao articleDao=db.articleDao();
        List<Article> articles=articleDao.getArticles();

        mData.add(new Video(R.mipmap.articles1, "如何提高腹肌", "我也不知道啊","点击量：11"));
        mData.add(new Video(R.mipmap.articles1, "震惊！健身中居然发送这样的事。", "到底发生了什么事呢！","点击量：10"));
        mAdapter = new VideoAdapter((LinkedList<Video>) mData, mContext);
        list_video.setAdapter(mAdapter);
    }
}
