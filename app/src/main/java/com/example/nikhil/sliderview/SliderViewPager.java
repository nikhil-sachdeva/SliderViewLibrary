package com.example.nikhil.sliderview;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;

public class SliderViewPager extends ViewPager {
    int currentPage;
    public SliderViewPager(@NonNull Context context) {
        super(context);
        currentPage=0;
    }

    @Override
    public void setCurrentItem(int item) {
        super.setCurrentItem(item);
        item=currentPage++;
    }
}
