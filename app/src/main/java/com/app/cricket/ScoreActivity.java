package com.app.cricket;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Data.MatchData;
import Data.ScoreData;

public class ScoreActivity extends FragmentActivity
{
    TextView liveDescription,firstTeam,secondTeam,targetRun,currentRun,currentStatus;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);

        liveDescription=(TextView)findViewById(R.id.live_status);
        firstTeam=(TextView)findViewById(R.id.team1);
        secondTeam=(TextView)findViewById(R.id.team2);
        targetRun=(TextView)findViewById(R.id.runs_one);
        currentRun=(TextView)findViewById(R.id.runs_second);
        currentStatus=(TextView)findViewById(R.id.current_status);
        try {

            UsefullInfoFragment.insert();
            liveDescription.setText(CricketAppManager.GetInstance().getData("live"));
            firstTeam.setText(CricketAppManager.GetInstance().getData("team1"));
            secondTeam.setText(CricketAppManager.GetInstance().getData("team2"));
            targetRun.setText(CricketAppManager.GetInstance().getData("target"));
            currentRun.setText(CricketAppManager.GetInstance().getData("current"));
            currentStatus.setText(CricketAppManager.GetInstance().getData("status"));

            ViewPager viewPager = (ViewPager) findViewById(R.id.viewpager);
            setupViewPager(viewPager);

            // Give the TabLayout the ViewPager
            TabLayout tabLayout = (TabLayout) findViewById(R.id.sliding_tabs);
            tabLayout.setSelectedTabIndicatorColor(Color.RED);
            tabLayout.setTabTextColors(Color.BLACK,Color.BLACK);
            tabLayout.setupWithViewPager(viewPager);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    class PagerAdapter extends FragmentPagerAdapter
    {

        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<String>();

        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }
        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }
        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }
    }

    private void setupViewPager(ViewPager viewPager) {
        PagerAdapter adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new UsefullInfoFragment(),"Live");
        adapter.addFragment(new ScoreFragment(),"ScoreCard");
        adapter.addFragment(new UsefullInfoFragment(),"Report");
        adapter.addFragment(new UsefullInfoFragment(),"Commentary");
        viewPager.setAdapter(adapter);
    }


}
