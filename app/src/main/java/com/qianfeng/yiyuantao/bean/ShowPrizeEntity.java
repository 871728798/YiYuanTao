package com.qianfeng.yiyuantao.bean;

import java.util.List;

/**
 * Created by Administrator on 2015/11/25 0025.
 */
public class ShowPrizeEntity {

    private String good_id;
    private String title;
    private String well;
    private String price_name;
    private String content;
    private String price_id;
    private String create_time;
    private String comment_no;
    private String praise;
    private String time;
    private String popular;
    private UserEntity user;

    @Override
    public String toString() {
        return "ShowPrizeEntity{" +
                "good_id='" + good_id + '\'' +
                ", title='" + title + '\'' +
                ", well='" + well + '\'' +
                ", price_name='" + price_name + '\'' +
                ", content='" + content + '\'' +
                ", price_id='" + price_id + '\'' +
                ", create_time='" + create_time + '\'' +
                ", comment_no='" + comment_no + '\'' +
                ", praise='" + praise + '\'' +
                ", time='" + time + '\'' +
                ", popular='" + popular + '\'' +
                ", user=" + user +
                ", id='" + id + '\'' +
                ", images=" + images +
                ", thumbs=" + thumbs +
                '}';
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    private String id;
    private List<String> images;
    private List<String> thumbs;

    public void setGood_id(String good_id) {
        this.good_id = good_id;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setWell(String well) {
        this.well = well;
    }

    public void setPrice_name(String price_name) {
        this.price_name = price_name;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setPrice_id(String price_id) {
        this.price_id = price_id;
    }

    public void setCreate_time(String create_time) {
        this.create_time = create_time;
    }

    public void setComment_no(String comment_no) {
        this.comment_no = comment_no;
    }

    public void setPraise(String praise) {
        this.praise = praise;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public void setPopular(String popular) {
        this.popular = popular;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void setImages(List<String> images) {
        this.images = images;
    }

    public void setThumbs(List<String> thumbs) {
        this.thumbs = thumbs;
    }

    public String getGood_id() {
        return good_id;
    }

    public String getTitle() {
        return title;
    }

    public String getWell() {
        return well;
    }

    public String getPrice_name() {
        return price_name;
    }

    public String getContent() {
        return content;
    }

    public String getPrice_id() {
        return price_id;
    }

    public String getCreate_time() {
        return create_time;
    }

    public String getComment_no() {
        return comment_no;
    }

    public String getPraise() {
        return praise;
    }

    public String getTime() {
        return time;
    }

    public String getPopular() {
        return popular;
    }

    public String getId() {
        return id;
    }

    public List<String> getImages() {
        return images;
    }

    public List<String> getThumbs() {
        return thumbs;
    }
}
