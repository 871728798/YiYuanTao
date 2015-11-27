package com.qianfeng.yiyuantao.bean;

/**
 * Created by Lee on 2015/11/26.
 */
public class ViewPagerEntity {
    /**
     * count_buyed : 1689
     * category_id : 6
     * description : 飞利浦（PHILIPS）HD9231/64 Airfryer空气炸锅 电烤炉
     * goods_id : 99
     * level : 0
     * remain_sec : 0
     * price : 1689
     * created : 2015-11-24 10:24:48
     * detail :
     * show_prize_count : 0
     * prize_id : 15381
     * peroid : 41
     * current_prize : {"prize_id":16308,"peroid":46,"showed":true}
     * thumb_home : http://7xmsv5.com2.z0.glb.qiniucdn.com/goods_1511121507109165x.jpg
     * thumb_slide : http://7xmsv5.com2.z0.glb.qiniucdn.com/goods_1511121507101780x.jpg|http://7xmsv5.com2.z0.glb.qiniucdn.com/goods_1511121507105608x.jpg|http://7xmsv5.com2.z0.glb.qiniucdn.com/goods_1511121507102266x.jpg
     * title : 飞利浦（PHILIPS）空气炸锅 电烤炉
     * count_else : 0
     * price_tag : 1
     * thumb_nail : http://7xmsv5.com2.z0.glb.qiniucdn.com/goods_151112150710342x.jpg
     */

    private int count_buyed;
    private int category_id;
    private String description;
    private int goods_id;
    private int level;
    private int remain_sec;
    private int price;
    private String created;
    private String detail;
    private int show_prize_count;
    private int prize_id;
    private int peroid;
    /**
     * prize_id : 16308
     * peroid : 46
     * showed : true
     */

    private CurrentPrizeEntity current_prize;
    private String thumb_home;
    private String thumb_slide;
    private String title;
    private int count_else;
    private int price_tag;
    private String thumb_nail;

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

    public void setRemain_sec(int remain_sec) {
        this.remain_sec = remain_sec;
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

    public void setShow_prize_count(int show_prize_count) {
        this.show_prize_count = show_prize_count;
    }

    public void setPrize_id(int prize_id) {
        this.prize_id = prize_id;
    }

    public void setPeroid(int peroid) {
        this.peroid = peroid;
    }

    public void setCurrent_prize(CurrentPrizeEntity current_prize) {
        this.current_prize = current_prize;
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

    public int getRemain_sec() {
        return remain_sec;
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

    public int getShow_prize_count() {
        return show_prize_count;
    }

    public int getPrize_id() {
        return prize_id;
    }

    public int getPeroid() {
        return peroid;
    }

    public CurrentPrizeEntity getCurrent_prize() {
        return current_prize;
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

    public static class CurrentPrizeEntity {
        private int prize_id;
        private int peroid;
        private boolean showed;

        public void setPrize_id(int prize_id) {
            this.prize_id = prize_id;
        }

        public void setPeroid(int peroid) {
            this.peroid = peroid;
        }

        public void setShowed(boolean showed) {
            this.showed = showed;
        }

        public int getPrize_id() {
            return prize_id;
        }

        public int getPeroid() {
            return peroid;
        }

        public boolean isShowed() {
            return showed;
        }

        @Override
        public String toString() {
            return "CurrentPrizeEntity{" +
                    "prize_id=" + prize_id +
                    ", peroid=" + peroid +
                    ", showed=" + showed +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "ViewPagerEntity{" +
                "count_buyed=" + count_buyed +
                ", category_id=" + category_id +
                ", description='" + description + '\'' +
                ", goods_id=" + goods_id +
                ", level=" + level +
                ", remain_sec=" + remain_sec +
                ", price=" + price +
                ", created='" + created + '\'' +
                ", detail='" + detail + '\'' +
                ", show_prize_count=" + show_prize_count +
                ", prize_id=" + prize_id +
                ", peroid=" + peroid +
                ", current_prize=" + current_prize +
                ", thumb_home='" + thumb_home + '\'' +
                ", thumb_slide='" + thumb_slide + '\'' +
                ", title='" + title + '\'' +
                ", count_else=" + count_else +
                ", price_tag=" + price_tag +
                ", thumb_nail='" + thumb_nail + '\'' +
                '}';
    }
}
