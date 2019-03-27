package com.example.sliderviewlibrary;

import android.content.Context;
import android.os.Handler;
import android.os.Parcelable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.TimerTask;

public class SliderAdapter extends PagerAdapter {
    private ArrayList<Integer> IMAGES;
    private ArrayList<String> URLs;
    private LayoutInflater inflater;
    private Context context;
    public Runnable Update;
    TimerTask updatePage;
    int currentPage=0;
    int mode=0;
    TabLayout tabDots;
    ViewPager viewPager;

    public SliderAdapter(Context context, ViewPager viewPager, TabLayout tabDots) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.viewPager=viewPager;
        this.tabDots=tabDots;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View) object);
    }

    @Override
    public int getCount() {
        if(mode==0) {
            return IMAGES.size();
        }
        else{
            return URLs.size();
        }
    }

    @Override
    public Object instantiateItem(ViewGroup view, int position) {
        View imageLayout = inflater.inflate(R.layout.main_slide, view, false);

        assert imageLayout != null;
        final ImageView imageView = (ImageView) imageLayout
                .findViewById(R.id.image);

        if(mode==0) {
            imageView.setImageResource(IMAGES.get(position));
        }
        if(mode==1){
            Picasso.get().load(URLs.get(position)).into(imageView);
        }


        view.addView(imageLayout, 0);


        return imageLayout;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view.equals(object);
    }

    @Override
    public void restoreState(Parcelable state, ClassLoader loader) {
    }

    @Override
    public Parcelable saveState() {
        return null;
    }

    public void setImages(ArrayList<Integer> IMAGES){
        this.IMAGES=IMAGES;
    }

    public void setUrls(ArrayList<String> URLs){
        this.URLs=URLs;
        mode=1;
    }



}
