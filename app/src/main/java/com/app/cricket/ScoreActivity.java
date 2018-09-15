package com.app.cricket;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

import Data.DownloadManager;
import Data.ScoreCardData;
import Data.ScoreData;
import Data.ScoreUIBase;

public class ScoreActivity extends FragmentActivity implements ScoreUIBase
{
    TextView liveDescription,firstTeam,secondTeam,targetRun,currentRun,currentStatus;
    String url="https://api.myjson.com/bins/krp00";
    String Url="https://api.myjson.com/bins/f7ct4";
    Context mContext;
    Handler handler;
    ImageView imageView;
    public static List<ScoreCardData> scoreModels;
    @SuppressLint({"NewApi", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        mContext=getApplicationContext();
        handler = new Handler();
        imageView=(ImageView)findViewById(R.id.toolbar_refresh);
        CricketAppManager.GetInstance().addUI(this);

        liveDescription=(TextView)findViewById(R.id.live_status);
        firstTeam=(TextView)findViewById(R.id.team1);
        secondTeam=(TextView)findViewById(R.id.team2);
        targetRun=(TextView)findViewById(R.id.runs_one);
        currentRun=(TextView)findViewById(R.id.runs_second);
        currentStatus=(TextView)findViewById(R.id.current_status);
        try {
            CricketAppManager.GetInstance().downloadScoreCard(Url,mContext);
            CricketAppManager.GetInstance().refresh();
            LiveFragment.insert();
            handler.post(updateView);
            CricketAppManager.GetInstance().refresh();

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
    private Runnable updateView = new Runnable()
    {
        private int i = 1;
        @Override
        public void run() {
            if(i <= 50)
            {
                CricketAppManager.GetInstance().download(url,mContext);
                if(DownloadManager.mDownload.equals(ScoreData.mScoreData)){}
                else
                {
                    //CricketAppManager.GetInstance().clear();
                    ScoreData.mScoreData.putAll(DownloadManager.mDownload);
                    CricketAppManager.GetInstance().refresh();
                }
                handler.postDelayed(this, 10000);
            }
        }
    };

    @Override
    public void refresh()
    {
        liveDescription.setText(CricketAppManager.GetInstance().getData("match_description"));
        firstTeam.setText(CricketAppManager.GetInstance().getData("team_one"));
        secondTeam.setText(CricketAppManager.GetInstance().getData("team_two"));
        targetRun.setText(CricketAppManager.GetInstance().getData("target_run"));
        currentRun.setText(CricketAppManager.GetInstance().getData("current_run"));
        currentStatus.setText(CricketAppManager.GetInstance().getData("match_status"));
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

    PagerAdapter adapter;
    private void setupViewPager(ViewPager viewPager) {
        adapter = new PagerAdapter(getSupportFragmentManager());
        adapter.addFragment(new LiveFragment(),"Live");
        adapter.addFragment(new ScoreCardFragment(),"ScoreCard");
        adapter.addFragment(new LiveFragment(),"Report");
        adapter.addFragment(new LiveFragment(),"Commentary");
        viewPager.setAdapter(adapter);
    }
    public static void insert1()
    {
        CricketAppManager.GetInstance().addData("name_one","G Gambhir* (lhb)");
        CricketAppManager.GetInstance().addData("name_two","Shreyas Iyer (rhb)");

        CricketAppManager.GetInstance().addData("runs_one","30");
        CricketAppManager.GetInstance().addData("balls_one","17");
        CricketAppManager.GetInstance().addData("4s_one","4");
        CricketAppManager.GetInstance().addData("6s_one","1");
        CricketAppManager.GetInstance().addData("strikerate_one","152.94");

        CricketAppManager.GetInstance().addData("runs_two","20");
        CricketAppManager.GetInstance().addData("balls_two","8");
        CricketAppManager.GetInstance().addData("4s_two","1");
        CricketAppManager.GetInstance().addData("6s_two","1");
        CricketAppManager.GetInstance().addData("strikerate_two","150.00");

        CricketAppManager.GetInstance().addData("name1","K Jadhav (ob)");
        CricketAppManager.GetInstance().addData("name2","S Thakur (lm)");

        CricketAppManager.GetInstance().addData("over1","2");
        CricketAppManager.GetInstance().addData("maiden1","0");
        CricketAppManager.GetInstance().addData("runs1","9");
        CricketAppManager.GetInstance().addData("wicket1","0");
        CricketAppManager.GetInstance().addData("economy1","9.00");

        CricketAppManager.GetInstance().addData("over2","3");
        CricketAppManager.GetInstance().addData("maiden2","0");
        CricketAppManager.GetInstance().addData("runs2","20");
        CricketAppManager.GetInstance().addData("wicket2","1");
        CricketAppManager.GetInstance().addData("economy2","11.00");

        CricketAppManager.GetInstance().addData("match_description","4th Match(N),Indian Premier League at Hyderabad, Apr 9 2018");
        CricketAppManager.GetInstance().addData("team_one","DD");
        CricketAppManager.GetInstance().addData("team_two","CSK");
        CricketAppManager.GetInstance().addData("target_run","130");
        CricketAppManager.GetInstance().addData("current_run","50/1* (6/20 ovr,tgt 131)");
        CricketAppManager.GetInstance().addData("match_status","Delhi Dare Devils requires another 81 runs with 9 wickets and 14.0 overs remaining");

    }
    public void update()
    {
        try {
           adapter.mFragmentList.get(1).onResume();
           adapter.notifyDataSetChanged();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
