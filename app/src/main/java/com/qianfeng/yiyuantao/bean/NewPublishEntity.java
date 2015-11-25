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
    private int remain_sec;//倒计时的时间
    private int prize_id;
    private int user_id;
    private String time;
    private PrizeEntity prize_detail;
    private UserEntity user;

    public int getPrize_id() {
        return prize_id;
    }

    public void setPrize_id(int prize_id) {
        this.prize_id = prize_id;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }


    public NewPublishEntity() {
    }

    public int getRemain_sec() {
        return remain_sec;
    }

    public void setRemain_sec(int remain_sec) {
        this.remain_sec = remain_sec;
    }

    public PrizeEntity getPrize_detail() {
        return prize_detail;
    }

    public void setPrize_detail(PrizeEntity prize_detail) {
        this.prize_detail = prize_detail;
    }

    public UserEntity getUser() {
        return user;
    }

    public void setUser(UserEntity user) {
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


}
