package com.example.nikhil.sliderview;

import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.design.widget.TabLayout;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
ViewPager viewPager;
ArrayList<Integer> images = new ArrayList<>();
    ArrayList<String> Urls = new ArrayList<>();
int currentPage=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager=findViewById(R.id.viewPager);
        SliderAdapter sliderAdapter = new SliderAdapter(getApplicationContext(),viewPager);
        images.add(R.drawable.alt);
        images.add(R.drawable.amat);
        images.add(R.drawable.college);


        Urls.add("https://cdn140.picsart.com/257737415006202.jpg?c256x256");
        Urls.add("https://stephanianforum.files.wordpress.com/2015/07/holi-celbration.jpg?w=256&h=256&crop=1");
        Urls.add("https://static-s.aa-cdn.net/img/ios/1175689019/5f18f297b9258db5c13af41d70309379?v=1");

        TabLayout tabLayout = findViewById(R.id.tabDots);
       // sliderAdapter.setImages(images);
        sliderAdapter.setUrls(Urls);
        viewPager.setAdapter(sliderAdapter);
//        final Handler handler = new Handler();
//        final Runnable Update = new Runnable() {
//            public void run() {
//                if (currentPage == 3) {
//                    currentPage = 0;
//                }
//                viewPager.setCurrentItem(currentPage++, true);
//            }
//        };
//       TimerTask updatePage=new TimerTask() {
//            @Override
//            public void run() {
//                handler.post(Update);
//            }
//        };
        TimerTask task = sliderAdapter.getTimerTask();
       Timer timer = new Timer();
        tabLayout.setupWithViewPager(viewPager, true);
       timer.schedule(task,5000,5000);
    }
}
