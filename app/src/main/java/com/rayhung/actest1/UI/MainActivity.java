package com.rayhung.actest1.UI;

import android.arch.lifecycle.Lifecycle;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.rayhung.actest1.Model.News;
import com.rayhung.actest1.R;
import com.rayhung.actest1.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    public static final String TAG = "NewsListViewModel";

    private NewsAdapter mNewsAdapter;

    private ActivityMainBinding mActivityMainBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mActivityMainBinding = DataBindingUtil.setContentView(this,R.layout.activity_main);
        mNewsAdapter = new NewsAdapter(mNewsClickCallback);
        mActivityMainBinding.newsList.setAdapter(mNewsAdapter);
    }

    private final NewsClickCallback mNewsClickCallback = new NewsClickCallback() {
        @Override
        public void onClick(News news) {
            if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED)) {

            }
        }
    };


}
