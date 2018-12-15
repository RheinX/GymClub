package com.example.xuweijie.gymclub;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

@Database(entities = {Article.class},version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract ArticleDao articleDao();
}
