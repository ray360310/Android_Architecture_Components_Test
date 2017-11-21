package com.rayhung.actest1.Adapter;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.rayhung.actest1.Data.NewsData;
import com.rayhung.actest1.R;

import java.util.ArrayList;

/**
 * Created by rayhung on 2017/11/21.
 */

public class NewsAdapter extends BaseAdapter {

    private ArrayList<NewsData> arrayList;
    private Context mContext;

    public NewsAdapter(Context mContext, ArrayList<NewsData> arrayList) {
        this.mContext = mContext;
        this.arrayList = arrayList;
    }

    @Override
    public int getCount() {
        return arrayList.size() / 3;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Holder holder;

        if (convertView == null) {
            holder = new Holder();
            LayoutInflater myInflater = LayoutInflater.from(mContext);
            convertView = myInflater.inflate(R.layout.main_custom_listitem, null);
            holder.mainCLayout = convertView.findViewById(R.id.main_news_item_mainclayout);
            holder.titleTxw = convertView.findViewById(R.id.main_news_item_titletxw);
            holder.newsImg1 = convertView.findViewById(R.id.main_news_item_newsimg1);
            holder.newsImg2 = convertView.findViewById(R.id.main_news_item_newsimg2);
            holder.newsImg3 = convertView.findViewById(R.id.main_news_item_newsimg3);
            holder.balltypeTxw = convertView.findViewById(R.id.main_news_item_balltxw);
            holder.dateTxw = convertView.findViewById(R.id.main_news_item_timetxw);
            holder.likeCLayout = convertView.findViewById(R.id.main_news_item_likeclayout);
            holder.likeAmountTxw = convertView.findViewById(R.id.main_news_item_likeamount);
            convertView.setTag(holder);
        } else {
            holder = (Holder) convertView.getTag();
        }

        holder.titleTxw.setText(arrayList.get(position).getNewsTitle());
//        .with(mContext)
//                .asBitmap()
//                .load(arrayList.get(position).getThumbnailsUrl())
//                .into(holder.newsImg1);
        holder.newsImg2.setVisibility(View.INVISIBLE);
        holder.newsImg3.setVisibility(View.INVISIBLE);
        holder.balltypeTxw.setText("足球");

        return convertView;
    }

    class Holder {
        ConstraintLayout mainCLayout;
        TextView titleTxw;
        ImageView newsImg1;
        ImageView newsImg2;
        ImageView newsImg3;
        TextView balltypeTxw;
        TextView dateTxw;
        ConstraintLayout likeCLayout;
        TextView likeAmountTxw;
    }
}
