package com.rayhung.actest1.ViewModel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.rayhung.actest1.Data.NewsData;

import java.util.ArrayList;

/**
 * Created by rayhung on 2017/11/21.
 */

public class NewsDataViewModel extends ViewModel {

    private MutableLiveData<ArrayList<NewsData>> newsData;
    public LiveData<ArrayList<NewsData>> getNewsData() {
        if (newsData == null) {
            newsData = new MutableLiveData<ArrayList<NewsData>>();
            loadNewsData();
        }
        return newsData;
    }

    private void loadNewsData(){
        // Do an asyncronous operation to fetch newsData.
    }
}
