package com.jpyl.viewpageranmidemo;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.ImageView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ViewPagerCompat viewPager;
    private int[] imgs = {R.drawable.guide_image1, R.drawable.guide_image1, R.drawable.guide_image2, R.drawable.guide_image3};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        viewPager = (ViewPagerCompat) findViewById(R.id.viewpager);
        //Viewpager3.0+可用，ViewPagerCompat配合nineoldandroids-2.4.0.jar，兼容3.0以下的Viewpager
        viewPager.setPageTransformer(true, new RotateOutTransformer());
        MyPagerAdapter myPagerAdapter = new MyPagerAdapter(imgs);
        viewPager.setAdapter(myPagerAdapter);
    }

    class MyPagerAdapter extends PagerAdapter {
        private int[] imgs;
        private ArrayList<ImageView> imageViews;

        public MyPagerAdapter(int[] imgs) {
            this.imgs = imgs;
            initImageViews();


        }

        private void initImageViews() {
            imageViews = new ArrayList<ImageView>();
            for (int i = 0; i < imgs.length; i++) {
                ImageView imageView = new ImageView(MainActivity.this);
                imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                imageViews.add(imageView);
            }
        }

        @Override
        public int getCount() {
            return imgs.length;
        }

        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            ImageView imageView = imageViews.get(position);
            imageView.setImageResource(imgs[position]);
            container.addView(imageView);
            Log.i("M-TAG", "" + imageViews.size());
            return imageView;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            container.removeView(imageViews.get(position));
        }
    }
}
