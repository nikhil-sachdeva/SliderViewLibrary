package com.example.sliderviewlibrary;

import android.content.Context;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.TimerTask;

public class SliderView extends LinearLayout{
    private ArrayList<Integer> IMAGES;
    private ArrayList<String> URLs;
    TimerTask updatePage;
    SliderAdapter sliderAdapter;
    int currentPage=0;
    int mode;
    ViewPager viewPager;
    TabLayout tabDots;
    public SliderView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        inflate(getContext(),R.layout.slide_view,this);
        viewPager=findViewById(R.id.viewPager);
        tabDots=findViewById(R.id.tabDots);
        sliderAdapter = new SliderAdapter(context,viewPager,tabDots);

        tabDots.setupWithViewPager(viewPager,true);
        //sliderAdapter.execute();



    }


    public void setImages(ArrayList<Integer> IMAGES){
        this.IMAGES=IMAGES;
        sliderAdapter.setImages(IMAGES);
        viewPager.setAdapter(sliderAdapter);
    }

    public void setUrls(ArrayList<String> URLs){
        this.URLs=URLs;
        sliderAdapter.setUrls(URLs);
        viewPager.setAdapter(sliderAdapter);
        mode=1;
    }
    public TimerTask getTimerTask(){
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 3) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };
        updatePage=new TimerTask() {
            @Override
            public void run() {
                handler.post(Update);
            }
        };
        return updatePage;
    }
}
