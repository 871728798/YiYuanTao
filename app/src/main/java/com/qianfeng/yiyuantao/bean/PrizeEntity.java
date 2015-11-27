package com.qianfeng.yiyuantao.bean;

import java.io.Serializable;

/**
 * Created by Administrator on 2015/11/23 0023.
 * 商品信息的实体类
 */
public class PrizeEntity{

    private int count_buyed;//已经购买的数量
    private int category_id;//商品的类型（比如十元专区）
    private String description;
    private int goods_id;
    private int level;
    private int price;//价格
    private String created;//本期参与的开始时间
    private String detail;
    private int prize_id;//奖品ID
    private int peroid;//第几期的期数
    private String thumb_home;//商品大图
    private String thumb_slide;//商品详情页广告位
    private String title;//商品名字
    private int count_else;
    private int price_tag;
    private String thumb_nail;//商品小图

    @Override
    public String toString() {
        return "PrizeEntity{" +
                "count_buyed=" + count_buyed +
                ", category_id=" + category_id +
                ", description='" + description + '\'' +
                ", goods_id=" + goods_id +
                ", level=" + level +
                ", price=" + price +
                ", created='" + created + '\'' +
                ", detail='" + detail + '\'' +
                ", prize_id=" + prize_id +
                ", peroid=" + peroid +
                ", thumb_home='" + thumb_home + '\'' +
                ", thumb_slide='" + thumb_slide + '\'' +
                ", title='" + title + '\'' +
                ", count_else=" + count_else +
                ", price_tag=" + price_tag +
                ", thumb_nail='" + thumb_nail + '\'' +
                '}';
    }

    public void setCount_buyed(int count_buyed) {
        this.count_buyed = count_buyed;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setGoods_id(int goods_id) {
        this.goods_id = goods_id;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public void setCreated(String created) {
        this.created = created;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }

    public void setPrize_id(int prize_id) {
        this.prize_id = prize_id;
    }

    public void setPeroid(int peroid) {
        this.peroid = peroid;
    }

    public void setThumb_home(String thumb_home) {
        this.thumb_home = thumb_home;
    }

    public void setThumb_slide(String thumb_slide) {
        this.thumb_slide = thumb_slide;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setCount_else(int count_else) {
        this.count_else = count_else;
    }

    public void setPrice_tag(int price_tag) {
        this.price_tag = price_tag;
    }

    public void setThumb_nail(String thumb_nail) {
        this.thumb_nail = thumb_nail;
    }

    public int getCount_buyed() {
        return count_buyed;
    }

    public int getCategory_id() {
        return category_id;
    }

    public String getDescription() {
        return description;
    }

    public int getGoods_id() {
        return goods_id;
    }

    public int getLevel() {
        return level;
    }

    public int getPrice() {
        return price;
    }

    public String getCreated() {
        return created;
    }

    public String getDetail() {
        return detail;
    }

    public int getPrize_id() {
        return prize_id;
    }

    public int getPeroid() {
        return peroid;
    }

    public String getThumb_home() {
        return thumb_home;
    }

    public String getThumb_slide() {
        return thumb_slide;
    }

    public String getTitle() {
        return title;
    }

    public int getCount_else() {
        return count_else;
    }

    public int getPrice_tag() {
        return price_tag;
    }

    public String getThumb_nail() {
        return thumb_nail;
    }
}
