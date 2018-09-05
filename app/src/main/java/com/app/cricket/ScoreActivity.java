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
            MatchData dMatchData=new MatchData();
            dMatchData.addMatch("live","4th Match(N),Indian Premier League at Hyderabad, Apr 9 2018");
            dMatchData.addMatch("team1","RR");
            dMatchData.addMatch("team2","SRH");
            dMatchData.addMatch("target","125/9");
            dMatchData.addMatch("current","45/1* (5/20 ovr,tgt 126)");
            dMatchData.addMatch("status","Sunrisers Hyderabad requires another 81 runs with 9 wickets and 15.0 overs remaining");

            liveDescription.setText(dMatchData.getMatch("live"));
            firstTeam.setText(dMatchData.getMatch("team1"));
            secondTeam.setText(dMatchData.getMatch("team2"));
            targetRun.setText(dMatchData.getMatch("target"));
            currentRun.setText(dMatchData.getMatch("current"));
            currentStatus.setText(dMatchData.getMatch("status"));

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
