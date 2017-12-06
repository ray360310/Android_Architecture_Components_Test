package com.rayhung.actest1.db.dao;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;

import com.rayhung.actest1.db.entity.NewsEntity;

import java.util.List;

/**
 * Created by rayhung on 2017/12/5.
 */

@Dao
public interface NewsDao {
    @Query("SELECT * FROM news")
    LiveData<List<NewsEntity>> loadAllNews();

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<NewsEntity> news);

    @Query("select * from news where id = :newsId")
    LiveData<NewsEntity> loadNews(int newsId);

    @Query("select * from news where id = :newsId")
    NewsEntity loadNewsSync(int newsId);

}
