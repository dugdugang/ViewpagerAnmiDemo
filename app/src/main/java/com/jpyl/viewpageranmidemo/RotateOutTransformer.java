package com.jpyl.viewpageranmidemo;

import android.support.v4.view.ViewPager;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

/**
 * Created by dg on 2017/3/16.
 */

public class RotateOutTransformer implements ViewPager.PageTransformer {
    private final static float MAX_ROTATE = 10f;//旋转角大角度

    @Override
    public void transformPage(View page, float position) {
        int width = page.getWidth();//view的宽度
        if (position<-1){
            ViewHelper.setTranslationX(page,-1);
        }else if (position<=0){ //A页0->-1
            float rotate=MAX_ROTATE*position;
            page.setPivotX(width/2);
            page.setPivotY(page.getHeight());
            ViewHelper.setRotation(page,rotate);
        }else if (position<=1) {//B页1->0
            float rotate=MAX_ROTATE*position;
            page.setPivotX(width/2);
            page.setPivotY(page.getHeight());
            ViewHelper.setRotation(page,rotate);
        }else {//1+
            ViewHelper.setTranslationX(page,1);

        }
    }
}
