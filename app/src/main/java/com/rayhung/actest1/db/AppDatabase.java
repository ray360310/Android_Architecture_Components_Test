package com.rayhung.actest1.db;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.TypeConverters;
import android.content.Context;
import android.support.annotation.NonNull;

import com.rayhung.actest1.AppExecutors;
import com.rayhung.actest1.db.converter.DateConverter;
import com.rayhung.actest1.db.dao.NewsDao;
import com.rayhung.actest1.db.entity.NewsEntity;

import java.util.List;


/**
 * Created by rayhung on 2017/12/5.
 */

@Database(entities = {NewsEntity.class} , version = 1)
@TypeConverters(DateConverter.class)
public abstract class AppDatabase extends RoomDatabase{

    private static AppDatabase sInstance;

    public static final String DATABASE_NAME = "news-sample-db";

    public abstract NewsDao newsDao();

    private final MutableLiveData<Boolean> mIsDatabaseCreated = new MutableLiveData<>();

    public static AppDatabase getInstance(final Context context, final AppExecutors executors){
        if (sInstance == null) {
            synchronized (AppDatabase.class){
                if (sInstance == null) {
                }
            }
        }
        return sInstance;
    }

    /**
     * Build the database. {@link Builder#build()} only sets up the database configuration and
     * creates a new instance of the database.
     * The SQLite database is only created when it's accessed for the first time.
     */
    private static AppDatabase buildDatabase(final Context appContext,
                                             final AppExecutors executors){
        return Room.databaseBuilder(appContext, AppDatabase.class, DATABASE_NAME)
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        executors.diskIO().execute(() -> {
                            // Add a delay to simulate a long-running operation
                            addDelay();
                            // Generate the data for pre-population
                            AppDatabase database = AppDatabase.getInstance(appContext, executors);
                            database.setDatabaseCreated();
                        });
                    }
                }).build();
    }

    /**
     * Check whether the database already exists and expose it via {@link #getDatabaseCreated()}
     */
    private void updateDatabaseCreated(final Context context){
        if (context.getDatabasePath(DATABASE_NAME).exists()) {
            setDatabaseCreated();
        }
    }

    private void setDatabaseCreated(){
        mIsDatabaseCreated.postValue(true);
    }

    private static void insertData(final AppDatabase database, final List<NewsEntity> news){
        database.runInTransaction(() -> {
            database.newsDao().insertAll(news);
        });
    }

    private static void addDelay(){
        try {
            Thread.sleep(4000);
        }catch (InterruptedException ignored){

        }
    }

    public LiveData<Boolean> getDatabaseCreated(){
        return mIsDatabaseCreated;
    }

}
