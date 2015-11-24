package com.qianfeng.yiyuantao.bean;


/**
 * Created by Lee on 2015/11/23.
 */
public class NewPublishEntity {
    /* {
         "count": 4,
             "user_id": 116258,
             "remain_sec": 0,
             "luck_num": 10000153,
             "prize_id": 14863,
             "prize_detail": {
         "count_buyed": 168,
                 "thumb_slide": "http://7xmsv5.com2.z0.glb.qiniucdn.com/goods_1511131434027371x.jpg|http://7xmsv5.com2.z0.glb.qiniucdn.com/goods_151113143402830x.jpg|http://7xmsv5.com2.z0.glb.qiniucdn.com/goods_1511131434028781x.jpg",
                 "price_tag": 1,
                 "description": "罗技（Logitech）无线鼠标M238",
                 "goods_id": 119,
                 "created": "2015-11-23 08:18:49",
                 "price": 168,
                 "level": 0,
                 "detail": "",
                 "prize_id": 14863,
                 "peroid": 48,
                 "thumb_home": "http://7xmsv5.com2.z0.glb.qiniucdn.com/goods_1511131434021551x.jpg",
                 "title": "罗技无线鼠标 （款式包装随机）",
                 "count_else": 0,
                 "category_id": 2,
                 "thumb_nail": "http://7xmsv5.com2.z0.glb.qiniucdn.com/goods_1511131434025356x.jpg"
     },
         "user": {
         "id": 116258,
                 "ip": "218.27.6.30",
                 "nickname": "〆 奋斗吧、小青年°",
                 "avatar": "http://7xmsv5.com2.z0.glb.qiniucdn.com/accounts-avatar-116258-1447569093-avatar.thumbnail?",
                 "phone": "〆 奋斗吧、小青年°"
     },
         "time": "2015-11-23 14:30:26:424"
     },*/
    private int count; //本期夺宝人次
    private int luck_num;//幸运号码
    private int remain_sec;
    private Prize_detail prize_detail;
    private User user;

    @Override
    public String toString() {
        return "NewPublishEntity{" +
                "count=" + count +
                ", remain_sec=" + remain_sec +
                ", luck_num=" + luck_num +
                ", prize_detail=" + prize_detail +
                ", user=" + user +
                '}';
    }

    public NewPublishEntity() {
    }

    public int getRemain_sec() {
        return remain_sec;
    }

    public void setRemain_sec(int remain_sec) {
        this.remain_sec = remain_sec;
    }

    public Prize_detail getPrize_detail() {
        return prize_detail;
    }

    public void setPrize_detail(Prize_detail prize_detail) {
        this.prize_detail = prize_detail;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getLuck_num() {
        return luck_num;
    }

    public void setLuck_num(int luck_num) {
        this.luck_num = luck_num;
    }


   public class Prize_detail {
        public String thumb_nail;//商品图片
        public int price;//商品价格
        public String title;//商品名称

        public String getThumb_nail() {
            return thumb_nail;
        }

        public void setThumb_nail(String thumb_nail) {
            this.thumb_nail = thumb_nail;
        }

        public int getPrice() {
            return price;
        }

        public void setPrice(int price) {
            this.price = price;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }
    }


   public static class User {
        public int id;
        public String ip;
        public String nickname;//用户昵称
        public String avatar;//用户头像



       public int getId() {
           return id;
       }

       public void setId(int id) {
           this.id = id;
       }

       public String getIp() {
           return ip;
       }

       public void setIp(String ip) {
           this.ip = ip;
       }

       public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
