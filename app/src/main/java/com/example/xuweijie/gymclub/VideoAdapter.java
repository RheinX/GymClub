package com.example.xuweijie.gymclub;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class VideoAdapter extends BaseAdapter {
    private List<Video> videoList;
    private Context context;

    public VideoAdapter(List<Video> videoList, Context context){
        this.videoList=videoList;
        this.context=context;
    }

    @Override
    public int getCount() {
        return videoList.size();
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = LayoutInflater.from(context).inflate(R.layout.activity_videos,parent,false);
        ImageView img_icon = (ImageView) convertView.findViewById(R.id.list_image);
        TextView txt_titel = (TextView) convertView.findViewById(R.id.title);
        TextView txt_introduction = (TextView) convertView.findViewById(R.id.introduction);
        TextView txt_hit = (TextView) convertView.findViewById(R.id.hit);
        img_icon.setBackgroundResource(videoList.get(position).getUrl());
        txt_titel.setText(videoList.get(position).getTitle());
        txt_introduction.setText(videoList.get(position).getIntroduction());
        txt_hit.setText(videoList.get(position).getHit());

        convertView.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Uri uri = Uri.parse("https://s19.aconvert.com/convert/p3r68-cdx67/xy7ye-j517c.mp4");
                //  1.  先设定好Intent
                Intent intent = new Intent(Intent.ACTION_VIEW);

                //  2.  设置好 Data：播放源，是一个URI
                //      设置好 Data的Type：类型是 “video/mp4"
                intent.setDataAndType(uri,"video/*");

                //  3.  跳转：
                context.startActivity(intent);
            }
        });
        return convertView;
    }
}
