package com.qianfeng.yiyuantao.bean;

/**
 * Created by Lee on 2015/11/26.
 */
public class PrizeDetailEntity {
    /**
     * status : 4
     * count : 163
     * user_id : 15869
     * remain_sec : 0
     * luck_num : 10001144
     * prize_id : 15381
     * user : {"city":"湖北荆门","ip":"183.92.53.157","phone":"迷幻星云","avatar":"http://7xmsv5.com2.z0.glb.qiniucdn.com/accounts-avatar-15869-1443888839-avatar.thumbnail?","nickname":"迷幻星云","id":15869}
     * time : 2015-11-24 16:49:15:199
     */

    private int status;
    private int count;
    private int user_id;
    private int remain_sec;
    private int luck_num;
    private String prize_id;
    /**
     * city : 湖北荆门
     * ip : 183.92.53.157
     * phone : 迷幻星云
     * avatar : http://7xmsv5.com2.z0.glb.qiniucdn.com/accounts-avatar-15869-1443888839-avatar.thumbnail?
     * nickname : 迷幻星云
     * id : 15869
     */

    private User user;
    private String time;

    public void setStatus(int status) {
        this.status = status;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setRemain_sec(int remain_sec) {
        this.remain_sec = remain_sec;
    }

    public void setLuck_num(int luck_num) {
        this.luck_num = luck_num;
    }

    public void setPrize_id(String prize_id) {
        this.prize_id = prize_id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public int getStatus() {
        return status;
    }

    public int getCount() {
        return count;
    }

    public int getUser_id() {
        return user_id;
    }

    public int getRemain_sec() {
        return remain_sec;
    }

    public int getLuck_num() {
        return luck_num;
    }

    public String getPrize_id() {
        return prize_id;
    }

    public User getUser() {
        return user;
    }

    public String getTime() {
        return time;
    }

    public static class User {
        private String city;
        private String ip;
        private String phone;
        private String avatar;
        private String nickname;
        private int id;

        public void setCity(String city) {
            this.city = city;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getCity() {
            return city;
        }

        public String getIp() {
            return ip;
        }

        public String getPhone() {
            return phone;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getNickname() {
            return nickname;
        }

        public int getId() {
            return id;
        }

        @Override
        public String toString() {
            return "User{" +
                    "city='" + city + '\'' +
                    ", ip='" + ip + '\'' +
                    ", phone='" + phone + '\'' +
                    ", avatar='" + avatar + '\'' +
                    ", nickname='" + nickname + '\'' +
                    ", id=" + id +
                    '}';
        }
    }

    @Override
    public String toString() {
        return "PrizeDetailEntity{" +
                "status=" + status +
                ", count=" + count +
                ", user_id=" + user_id +
                ", remain_sec=" + remain_sec +
                ", luck_num=" + luck_num +
                ", prize_id='" + prize_id + '\'' +
                ", user=" + user +
                ", time='" + time + '\'' +
                '}';
    }
}
