package com.jpyl.viewpageranmidemo;

import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.ArrayList;

public class Main3Activity extends AppCompatActivity {
    MyViewPageTransformer viewPageTransformer;
    private int[] imgs = {R.drawable.guide_image1, R.drawable.guide_image1, R.drawable.guide_image2, R.drawable.guide_image3};
    private ArrayList<ImageView> imageViews = new ArrayList<ImageView>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        viewPageTransformer = (MyViewPageTransformer) findViewById(R.id.mViewpager);
        for (int i : imgs) {
            ImageView imageView = new ImageView(this);
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            imageViews.add(imageView);
        }
//        viewPageTransformer
        viewPageTransformer.setAdapter(new PagerAdapter() {
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
                viewPageTransformer.setPositionView(imageView, position);
                return imageView;
            }

            @Override
            public void destroyItem(ViewGroup container, int position, Object object) {
                container.removeView(imageViews.get(position));
                viewPageTransformer.removePositionView(position);

            }
        });

    }
}
