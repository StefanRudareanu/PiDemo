package com.example.gittry;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager2.adapter.FragmentStateAdapter;
import androidx.viewpager2.widget.ViewPager2;

import android.app.Fragment;
import android.os.Bundle;
import android.widget.TableLayout;

import com.example.gittry.FragmentsForMainAplicationPage.MainAplicationPageFrameAdaptop;
import com.google.android.material.tabs.TabLayout;

public class MainAplicationPage extends AppCompatActivity {
    TabLayout tableLayout;
    ViewPager2 pager2;
    MainAplicationPageFrameAdaptop adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_aplication_page);
        tableLayout=findViewById(R.id.Table);
        pager2=findViewById(R.id.ViepagerAM);

        FragmentManager fm= getSupportFragmentManager();
        adapter=new MainAplicationPageFrameAdaptop(fm,getLifecycle());
        pager2.setAdapter(adapter);

        tableLayout.addTab(tableLayout.newTab().setText("Home"));
        tableLayout.addTab(tableLayout.newTab().setText("Tasks"));
        tableLayout.addTab(tableLayout.newTab().setText("Progress"));

        tableLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                pager2.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        pager2.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
               tableLayout.selectTab(tableLayout.getTabAt(position));
            }
        });
    }
}