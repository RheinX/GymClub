package com.example.xuweijie.gymclub;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

import java.util.LinkedList;
import java.util.List;

public class TrainerInfoActivity extends AppCompatActivity {
    private List<Video> mData = null;
    private Context mContext;
    private VideoAdapter mAdapter = null;
    private ListView list_video;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trainer_info);

        mContext = TrainerInfoActivity.this;
        list_video = (ListView) findViewById(R.id.list_videos);
        mData = new LinkedList<Video>();

        mData.add(new Video(R.mipmap.articles2, "腹肌训练初级", "此教程适合想要训练初步训练腹肌的人","参加人数：11"));
        mData.add(new Video(R.mipmap.articles2, "二头肌训练初级", "此教程适合想要训练初步训练二头肌的人","参加人数：102"));
        mAdapter = new VideoAdapter((LinkedList<Video>) mData, mContext);
        list_video.setAdapter(mAdapter);
    }
}
