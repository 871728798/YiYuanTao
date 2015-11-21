package com.qianfeng.yiyuantao.custom;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.qianfeng.yiyuantao.R;


/**
 * Created by Administrator on 2015/11/17 0017.
 */
public class ImgNavView extends LinearLayout{

    private int count;
    private int checkedImg, unCheckedImg;
    private LayoutParams layoutParams;
    public ImgNavView(Context context, AttributeSet attrs) {
        super(context, attrs);
        parseAttr(attrs);
        init();
    }

    private void init() {
        this.removeAllViews();
        if(count > 0){
            layoutParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            layoutParams.leftMargin = 2;
            layoutParams.rightMargin = 2;
            for(int i = 0; i < count; i++){
                ImageView img = new ImageView(getContext());
                if(i == 0){
                    img.setImageResource(checkedImg);
                    img.setTag("checked");
                }else{
                    img.setImageResource(unCheckedImg);
                }
                img.setLayoutParams(layoutParams);
                this.addView(img);
            }
        }
    }

    private void parseAttr(AttributeSet attrs) {
        TypedArray typedArray = getResources().obtainAttributes(attrs, R.styleable.navproperties);
        count = typedArray.getInteger(R.styleable.navproperties_count, 0);
        checkedImg = typedArray.getResourceId(R.styleable.navproperties_checkedimg, 0);
        unCheckedImg = typedArray.getResourceId(R.styleable.navproperties_uncheckedimg, 0);
    }

    public void setCount(int count){
        this.count = count;
        init();
    }

    public void selectIndex(int index){
        ImageView img = (ImageView) this.findViewWithTag("checked");
        img.setImageResource(unCheckedImg);
        img.setTag(null);

        ImageView img2 = (ImageView) this.getChildAt(index);
        img2.setImageResource(checkedImg);
        img2.setTag("checked");
    }
}
