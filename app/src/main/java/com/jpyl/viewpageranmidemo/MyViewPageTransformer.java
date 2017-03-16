package com.jpyl.viewpageranmidemo;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

import com.nineoldandroids.view.ViewHelper;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by dg on 2017/3/16.
 */

public class MyViewPageTransformer extends ViewPager {
    private View leftView;
    private View rightView;
    private float scale;
    private float trans;
    private static final float MIN_SCALE = 0.5f;
    private Map<Integer, View> map = new HashMap<Integer, View>();

    public MyViewPageTransformer(Context context) {
        super(context);
    }

    public MyViewPageTransformer(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onPageScrolled(int position, float offset, int offsetPixels) {
        //Log.i("M-TAG", "position=" + position + ",offset=" + offset + ",offsetPixels=" + offsetPixels);
        leftView = map.get(position);
        rightView = map.get(position + 1);
        animWork(leftView, rightView, offset, offsetPixels);
        super.onPageScrolled(position, offset, offsetPixels);
    }


    private void animWork(View leftView, View rightView, float offset, int offsetPixels) {
        if (rightView != null) {
            scale = MIN_SCALE + (1 - MIN_SCALE) * offset;
            trans = -getWidth() - getPageMargin() + offsetPixels;
//            Log.i("M-TAG","lll"+getWidth()+" "+getPageMargin());
            Log.i("M-TAG", "" + scale + "  " + trans + " " + offsetPixels);
            ViewHelper.setScaleX(rightView, scale);
            ViewHelper.setScaleY(rightView, scale);
            ViewHelper.setTranslationX(rightView, trans);
        }
        if (leftView != null) {
            leftView.bringToFront();
        }
    }

    public void setPositionView(View view, int position) {
        map.put(position, view);
    }

    public void removePositionView(int position) {
        map.remove(position);
    }

}
