package com.rayhung.actest1.db.entity;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

import com.rayhung.actest1.Model.News;

/**
 * Created by rayhung on 2017/12/5.
 */

 @Entity(tableName = "news")
public class NewsEntity implements News{

    @PrimaryKey
    private int id;
    private String newsTitle;
    private String shortTitle;
    private String publishAtTime;
    private String description;
    private String sourceID;
    private String createAtTime;
    private String updateAtTime;
    private String content;
    private String thumbnailsUrl;
    private String linkUrl;

    @Override
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle;
    }

    @Override
    public String getShortTitle() {
        return shortTitle;
    }

    public void setShortTitle(String shortTitle) {
        this.shortTitle = shortTitle;
    }

    @Override
    public String getPublishAtTime() {
        return publishAtTime;
    }

    public void setPublishAtTime(String publishAtTime) {
        this.publishAtTime = publishAtTime;
    }

    @Override
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String getSourceID() {
        return sourceID;
    }

    public void setSourceID(String sourceID) {
        this.sourceID = sourceID;
    }

    @Override
    public String getCreateAtTime() {
        return createAtTime;
    }

    public void setCreateAtTime(String createAtTime) {
        this.createAtTime = createAtTime;
    }

    @Override
    public String getUpdateAtTime() {
        return updateAtTime;
    }

    public void setUpdateAtTime(String updateAtTime) {
        this.updateAtTime = updateAtTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public String getThumbnailsUrl() {
        return thumbnailsUrl;
    }

    public void setThumbnailsUrl(String thumbnailsUrl) {
        this.thumbnailsUrl = thumbnailsUrl;
    }

    @Override
    public String getLinkUrl() {
        return linkUrl;
    }

    public void setLinkUrl(String linkUrl) {
        this.linkUrl = linkUrl;
    }

    public NewsEntity(){

    }

    public NewsEntity(int id, String newsTitle, String shortTitle, String publishAtTime, String description, String sourceID, String createAtTime, String updateAtTime, String content, String thumbnailsUrl, String linkUrl) {
        this.id = id;
        this.newsTitle = newsTitle;
        this.shortTitle = shortTitle;
        this.publishAtTime = publishAtTime;
        this.description = description;
        this.sourceID = sourceID;
        this.createAtTime = createAtTime;
        this.updateAtTime = updateAtTime;
        this.content = content;
        this.thumbnailsUrl = thumbnailsUrl;
        this.linkUrl = linkUrl;
    }

    public NewsEntity(News news) {
        this.id = news.getId();
        this.newsTitle = news.getNewsTitle();
        this.shortTitle = news.getShortTitle();
        this.publishAtTime = news.getPublishAtTime();
        this.description = news.getDescription();
        this.sourceID = news.getSourceID();
        this.createAtTime = news.getCreateAtTime();
        this.updateAtTime = news.getUpdateAtTime();
        this.content = news.getContent();
        this.thumbnailsUrl = news.getThumbnailsUrl();
        this.linkUrl = news.getLinkUrl();
    }

}
