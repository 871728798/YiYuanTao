package com.qianfeng.yiyuantao.util;

/**
 * Created by Administrator on 2015/11/21 0021.
 * 存储常量
 */
public interface Constants {

    interface URL {
        /**
         * 首页
         **/
        String FIRST_PAGE_URL = "http://api.zhuquzhou.com/other/index?android_version=11&android_id=b7106f9de9c59ddb&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284040537676&mac=28:D2:44:47:0D:10&os_version=4.4.2&";
        /**
         * 最新揭晓
         **/
        String NEW_PUBLISH_URL = "http://api.zhuquzhou.com/lottery/win_history_by_recent?num=20&page_no=1&android_id=b7106f9de9c59ddb&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284040537676&mac=28:D2:44:47:0D:10&os_version=4.4.2&";
        /**
         * ALL_COMMODITY全部商品
         */
        String ALL_COMMODITY_NUM1 = "http://api.zhuquzhou.com/prize/prize_list?category_id=1&page_size=20&page_no=1&android_id=b7106f9de9c59ddb&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284040537676&mac=28:D2:44:47:0D:10&os_version=4.4.2&";
        /**
         * ALL_COMMODITY十元专场
         */
        String ALL_COMMODITY_NUM2 = "http://api.zhuquzhou.com/prize/prize_list?category_id=14&page_size=20&page_no=1&android_id=b7106f9de9c59ddb&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284040537676&mac=28:D2:44:47:0D:10&os_version=4.4.2&";
        /**
         * ALL_COMMODITY手机平板
         */
        String ALL_COMMODITY_NUM3 = "http://api.zhuquzhou.com/prize/prize_list?category_id=2&page_size=20&page_no=1&android_id=b7106f9de9c59ddb&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284040537676&mac=28:D2:44:47:0D:10&os_version=4.4.2&";
        /**
         * ALL_COMMODITY电脑办公
         */
       String ALL_COMMODITY_NUM4 =  "http://api.zhuquzhou.com/prize/prize_list?category_id=3&page_size=20&page_no=1&android_id=b7106f9de9c59ddb&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284040537676&mac=28:D2:44:47:0D:10&os_version=4.4.2&";
        /**
         * ALL_COMMODITY影音数码
         */
        String ALL_COMMODITY_NUM5="http://api.zhuquzhou.com/prize/prize_list?category_id=4&page_size=20&page_no=1&android_id=b7106f9de9c59ddb&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284040537676&mac=28:D2:44:47:0D:10&os_version=4.4.2&";
        /**
         * ALL_COMMODITY零食饮料
         */
        String ALL_COMMODITY_NUM6 ="http://api.zhuquzhou.com/prize/prize_list?category_id=5&page_size=20&page_no=1&android_id=b7106f9de9c59ddb&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284040537676&mac=28:D2:44:47:0D:10&os_version=4.4.2&";
        /**
         * ALL_COMMODITY男性用品
         */
        String ALL_COMMODITY_NUM7 = "http://api.zhuquzhou.com/prize/prize_list?category_id=13&page_size=20&page_no=1&android_id=b7106f9de9c59ddb&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284040537676&mac=28:D2:44:47:0D:10&os_version=4.4.2&";
        /**
         * ALL_COMMODITY女性用品
         */
        String ALL_COMMODITY_NUM8 = "http://api.zhuquzhou.com/prize/prize_list?category_id=11&page_size=20&page_no=1&android_id=b7106f9de9c59ddb&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284040537676&mac=28:D2:44:47:0D:10&os_version=4.4.2&";
        /**
         * ALL_COMMODITY家用电脑
         */
        String ALL_COMMODITY_NUM9 = "http://api.zhuquzhou.com/prize/prize_list?category_id=6&page_size=20&page_no=1&android_id=b7106f9de9c59ddb&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284040537676&mac=28:D2:44:47:0D:10&os_version=4.4.2&";
        /**
         * ALL_COMMODITY儿童玩具
         */
        String ALL_COMMODITY_NUM10 = "http://api.zhuquzhou.com/prize/prize_list?category_id=10&page_size=20&page_no=1&android_id=b7106f9de9c59ddb&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284040537676&mac=28:D2:44:47:0D:10&os_version=4.4.2&";
        /**
         * ALL_COMMODITY虚拟产品
         */
        String ALL_COMMODITY_NUM11="http://api.zhuquzhou.com/prize/prize_list?category_id=9&page_size=20&page_no=1&android_id=b7106f9de9c59ddb&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284040537676&mac=28:D2:44:47:0D:10&os_version=4.4.2&";
        /**
         * ALL_COMMODITY户外产品
         */
        String ALL_COMMODITY_NUM12 = "http://api.zhuquzhou.com/prize/prize_list?category_id=12&page_size=20&page_no=1&android_id=b7106f9de9c59ddb&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284040537676&mac=28:D2:44:47:0D:10&os_version=4.4.2&";
        /**
         * ALL_COMMODITY其他宝贝
         */
        String ALL_COMMODITY_NUM13 = "http://api.zhuquzhou.com/prize/prize_list?category_id=8&page_size=20&page_no=1&android_id=b7106f9de9c59ddb&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284040537676&mac=28:D2:44:47:0D:10&os_version=4.4.2&";

        /**
         * 首页的搜索:
         *参数：keyword=?
         */
       String SEARCH_URL = "http://api.zhuquzhou.com/prize/prize_search?keyword=%s&page_size=20&page_no=1&android_id=657e6c60d04803fc&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284041624861&mac=3C:97:0E:6F:41:30&os_version=4.4.2&";
        /**
         * 购物车：猜你喜欢
         */
        String SHOPPING_URL = "http://api.zhuquzhou.com/prize/prize_list?page_size=10&page_no=1&order_by=level&desc=1&android_id=b7106f9de9c59ddb&platform=android&v=1.1.1&device_name=nox&s=5708&nettype=wifi&n=yyt_android&app_version=11&sim=false&device_id=352284040537676&mac=28:D2:44:47:0D:10&os_version=4.4.2&";
    }

    interface KEY {

    }
}
