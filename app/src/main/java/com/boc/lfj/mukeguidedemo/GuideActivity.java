package com.boc.lfj.mukeguidedemo;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import java.util.Arrays;
import java.util.List;

public class GuideActivity extends AppCompatActivity {
    private ImageView mDotOne, mDottwo, mDotThree;
    private RelativeLayout mLayoutBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guide);
        ViewPager mViewPager = (ViewPager) findViewById(R.id.viewpager);

        mDotOne = (ImageView) findViewById(R.id.guide_one);
        mDottwo = (ImageView) findViewById(R.id.guide_two);
        mDotThree = (ImageView) findViewById(R.id.guide_three);

        mLayoutBtn = (RelativeLayout) findViewById(R.id.layout_btn);

        GuideFragment fragment1 = GuideFragment.newInstance(0);
        GuideFragment fragment2 = GuideFragment.newInstance(1);
        GuideFragment fragment3 = GuideFragment.newInstance(2);

        List<? extends Fragment> mFragmentList = Arrays.asList(fragment1, fragment2, fragment3);

        GuideFragmentPagerAdapter mAdapter = new GuideFragmentPagerAdapter(getSupportFragmentManager(), mFragmentList);
        mViewPager.setAdapter(mAdapter);
        mDotOne.setImageResource(R.mipmap.ic_dot_selected);
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
               
            }

            @Override
            public void onPageSelected(int position) {
                mDotOne.setImageResource(R.mipmap.ic_dot_default);
                mDottwo.setImageResource(R.mipmap.ic_dot_default);
                mDotThree.setImageResource(R.mipmap.ic_dot_default);
                switch (position) {
                    case 0:
                        mDotOne.setImageResource(R.mipmap.ic_dot_selected);
                        break;
                    case 1:
                        mDottwo.setImageResource(R.mipmap.ic_dot_selected);
                        break;
                    case 2:
                        mDotThree.setImageResource(R.mipmap.ic_dot_selected);
                        break;
                }
                mLayoutBtn.setVisibility(position == 2 ? View.VISIBLE : View.GONE);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    public static class GuideFragmentPagerAdapter extends FragmentPagerAdapter {
        private List<? extends Fragment> fragments;

        public GuideFragmentPagerAdapter(FragmentManager fm, List<? extends Fragment> fragments) {
            super(fm);
            this.fragments = fragments;
        }

        @Override
        public int getCount() {
            return fragments.size();
        }


        @Override
        public Fragment getItem(int position) {
            return fragments.get(position);
        }
    }
}
