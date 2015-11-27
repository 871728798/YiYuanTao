package com.qianfeng.yiyuantao.bean;

/**
 * Created by Lee on 2015/11/26.
 */
public class CommentEntity {
    /**
     * count : 99
     * city : 青海西宁
     * user_id : 140651
     * ip : 61.133.239.20
     * datetime : 2015-11-24 16:49:15:135
     * user : {"id":140651,"ip":"61.133.239.20","nickname":"奔放稳妥你疼g,","avatar":"http://7xmsv5.com2.z0.glb.qiniucdn.com/accounts-avatar-140651-1447900483-avatar.thumbnail?","phone":"奔放稳妥你疼g,"}
     */

    private int count;
    private String city;
    private int user_id;
    private String ip;
    private String datetime;
    /**
     * id : 140651
     * ip : 61.133.239.20
     * nickname : 奔放稳妥你疼g,
     * avatar : http://7xmsv5.com2.z0.glb.qiniucdn.com/accounts-avatar-140651-1447900483-avatar.thumbnail?
     * phone : 奔放稳妥你疼g,
     */

    private UserEntity user;

    public void setCount(int count) {
        this.count = count;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public void setIp(String ip) {
        this.ip = ip;
    }

    public void setDatetime(String datetime) {
        this.datetime = datetime;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    public String getCity() {
        return city;
    }

    public int getUser_id() {
        return user_id;
    }

    public String getIp() {
        return ip;
    }

    public String getDatetime() {
        return datetime;
    }

    public UserEntity getUser() {
        return user;
    }

    public static class UserEntity {
        private int id;
        private String ip;
        private String nickname;
        private String avatar;
        private String phone;

        public void setId(int id) {
            this.id = id;
        }

        public void setIp(String ip) {
            this.ip = ip;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }

        public void setPhone(String phone) {
            this.phone = phone;
        }

        public int getId() {
            return id;
        }

        public String getIp() {
            return ip;
        }

        public String getNickname() {
            return nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public String getPhone() {
            return phone;
        }
    }

    @Override
    public String toString() {
        return "CommentEntity{" +
                "count=" + count +
                ", city='" + city + '\'' +
                ", user_id=" + user_id +
                ", ip='" + ip + '\'' +
                ", datetime='" + datetime + '\'' +
                ", user=" + user +
                '}';
    }
}
