package com.github.footballnews.ui.newslist.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.github.footballnews.R;
import com.github.footballnews.model.NewsItemModel;
import com.makeramen.roundedimageview.RoundedImageView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Date: 30.01.2017
 * Time: 18:07
 *
 * @author Aleks Sander
 *         Project FootballNews
 */

public class NewsListAdapter extends RecyclerView.Adapter<NewsListAdapter.NewsItemHolder> {

    private List<NewsItemModel> newsItemModels;
    private final OnNewsItemClickListener clickListener;

    public NewsListAdapter(List<NewsItemModel> newsItemModels, OnNewsItemClickListener clickListener) {
        this.newsItemModels = newsItemModels;
        this.clickListener = clickListener;
    }

    @Override
    public NewsItemHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_news_list, parent, false);
        itemView.setOnClickListener(v -> clickListener.onItemClick(v, (NewsItemModel)v.getTag()));
        return new NewsItemHolder(itemView);
    }

    @Override
    public void onBindViewHolder(NewsItemHolder holder, int position) {
        NewsItemModel model = newsItemModels.get(position);
        holder.newsItemDate.setText(model.getDate());
        holder.newsItemDescription.setText(model.getDescription());
        holder.newsItemTitle.setText(model.getTitle());
        holder.itemView.setTag(model);
        Glide.with(holder.newsItemImage.getContext())
                .load(model.getImageUrl())
                .asBitmap()
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.newsItemImage);
    }

    @Override
    public int getItemCount() {
        return newsItemModels == null ? 0 : newsItemModels.size();
    }

    public void setNewsItemModels(List<NewsItemModel> newsItemModels) {
        this.newsItemModels = newsItemModels;
        notifyDataSetChanged();
    }

    static class NewsItemHolder extends RecyclerView.ViewHolder {
        @BindView(R.id.newsItemImage)
        RoundedImageView newsItemImage;
        @BindView(R.id.newsItemDate)
        TextView newsItemDate;
        @BindView(R.id.newsItemTitle)
        TextView newsItemTitle;
        @BindView(R.id.newsItemDescription)
        TextView newsItemDescription;

        NewsItemHolder(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
