package com.rayhung.actest1.UI;

import android.databinding.DataBindingUtil;
import android.support.annotation.Nullable;
import android.support.v7.util.DiffUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.rayhung.actest1.Model.News;
import com.rayhung.actest1.R;
import com.rayhung.actest1.databinding.MainCustomListitemBinding;

import java.util.List;
import java.util.Objects;


/**
 * Created by rayhung on 2017/12/6.
 */

public class NewsAdapter extends RecyclerView.Adapter<NewsAdapter.NewsViewHolder>{

    List<? extends News> mNewsList;

    @Nullable
    private final NewsClickCallback mNewsClickCallback;

    public NewsAdapter(@Nullable NewsClickCallback mNewsClickCallback) {
        this.mNewsClickCallback = mNewsClickCallback;
    }

    public void setmNewsList(final List<? extends News> newsList){
        if (mNewsList == null) {
            mNewsList = newsList;
            notifyItemRangeInserted(0 , newsList.size());
        }else {
            DiffUtil.DiffResult result = DiffUtil.calculateDiff(new DiffUtil.Callback() {
                @Override
                public int getOldListSize() {
                    return mNewsList.size();
                }

                @Override
                public int getNewListSize() {
                    return newsList.size();
                }

                @Override
                public boolean areItemsTheSame(int oldItemPosition, int newItemPosition) {
                    return mNewsList.get(oldItemPosition).getId() ==
                            newsList.get(newItemPosition).getId();
                }

                @Override
                public boolean areContentsTheSame(int oldItemPosition, int newItemPosition) {
                    News newNews = newsList.get(newItemPosition);
                    News oldNews = mNewsList.get(oldItemPosition);
                    return newNews.getId() == oldNews.getId()
                            && Objects.equals(newNews.getDescription(), oldNews.getDescription())
                            && Objects.equals(newNews.getNewsTitle(), oldNews.getNewsTitle())
                            && newNews.getThumbnailsUrl() == oldNews.getThumbnailsUrl();
                }
            });
            mNewsList = newsList;
            result.dispatchUpdatesTo(this);
        }
    }

    @Override
    public NewsViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        MainCustomListitemBinding mMainCustomListitemBinding = DataBindingUtil
                .inflate(LayoutInflater.from(parent.getContext()) , R.layout.main_custom_listitem , parent , false);
        mMainCustomListitemBinding.setCallback(mNewsClickCallback);
        return new NewsViewHolder(mMainCustomListitemBinding);
    }

    @Override
    public void onBindViewHolder(NewsViewHolder holder, int position) {
        holder.mMainCustomListitemBinding.setNews(mNewsList.get(position));
        holder.mMainCustomListitemBinding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    static class NewsViewHolder extends RecyclerView.ViewHolder{

        final MainCustomListitemBinding mMainCustomListitemBinding;

        public NewsViewHolder(MainCustomListitemBinding binding){
            super(binding.getRoot());
            this.mMainCustomListitemBinding = binding;
        }
    }

}
