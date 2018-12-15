package com.example.xuweijie.gymclub;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import java.util.List;

@Dao
public interface ArticleDao {
    @Query("select * from article")
    List<Article> getArticles();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertProduct(Article product);

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAllProducts(List<Article> products);

    @Delete
    void deleteProduct(Article product);

}
