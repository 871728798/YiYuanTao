package com.qianfeng.yiyuantao.bean;

import java.util.Arrays;

/**
 * Created by Administrator on 2015/11/23 0023.
 */
public class FirstPageEntity {
    private PrizeEntity[] prize_list;
    private Banner[] banner;

    @Override
    public String toString() {
        return "FirstPageEntity{" +
                "prize_list=" + Arrays.toString(prize_list) +
                ", banner=" + Arrays.toString(banner) +
                '}';
    }

    public FirstPageEntity() {
    }

    public FirstPageEntity(PrizeEntity[] prize_list, Banner[] banner) {

        this.prize_list = prize_list;
        this.banner = banner;
    }

    public PrizeEntity[] getPrize_list() {
        return prize_list;
    }

    public void setPrize_list(PrizeEntity[] prize_list) {
        this.prize_list = prize_list;
    }

    public Banner[] getBanner() {
        return banner;
    }

    public void setBanner(Banner[] banner) {
        this.banner = banner;
    }

    public static class Banner{

        private int prize_id;
        private int goods_id;
        private boolean showed;
        private String created;
        private String url;
        private String banner;
        private String title;
        private String modified;
        private int priority;
        private String platform;
        private String type;
        private int id;

        @Override
        public String toString() {
            return "Banner{" +
                    "prize_id=" + prize_id +
                    ", goods_id=" + goods_id +
                    ", showed=" + showed +
                    ", created='" + created + '\'' +
                    ", url='" + url + '\'' +
                    ", banner='" + banner + '\'' +
                    ", title='" + title + '\'' +
                    ", modified='" + modified + '\'' +
                    ", priority=" + priority +
                    ", platform='" + platform + '\'' +
                    ", type='" + type + '\'' +
                    ", id=" + id +
                    '}';
        }

        public void setPrize_id(int prize_id) {
            this.prize_id = prize_id;
        }

        public void setGoods_id(int goods_id) {
            this.goods_id = goods_id;
        }

        public void setShowed(boolean showed) {
            this.showed = showed;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public void setBanner(String banner) {
            this.banner = banner;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public void setModified(String modified) {
            this.modified = modified;
        }

        public void setPriority(int priority) {
            this.priority = priority;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public void setType(String type) {
            this.type = type;
        }

        public void setId(int id) {
            this.id = id;
        }

        public int getPrize_id() {
            return prize_id;
        }

        public int getGoods_id() {
            return goods_id;
        }

        public boolean isShowed() {
            return showed;
        }

        public String getCreated() {
            return created;
        }

        public String getUrl() {
            return url;
        }

        public String getBanner() {
            return banner;
        }

        public String getTitle() {
            return title;
        }

        public String getModified() {
            return modified;
        }

        public int getPriority() {
            return priority;
        }

        public String getPlatform() {
            return platform;
        }

        public String getType() {
            return type;
        }

        public int getId() {
            return id;
        }
    }
}
