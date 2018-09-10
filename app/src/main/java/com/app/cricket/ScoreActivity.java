package com.app.cricket;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.AsyncTask;
import android.os.Handler;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import Data.ScoreUIBase;

public class ScoreActivity extends FragmentActivity implements ScoreUIBase
{
    TextView liveDescription,firstTeam,secondTeam,targetRun,currentRun,currentStatus;
    Toolbar maintoolbar;
    Context mContext;
    Handler handler;
    ImageView imageView;
    @SuppressLint({"NewApi", "ResourceType"})
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score);
        mContext=getApplicationContext();

        handler = new Handler();
        imageView=(ImageView)findViewById(R.id.toolbar_refresh);
        imageView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
            }
        });

        CricketAppManager.GetInstance().addUI(this);

        liveDescription=(TextView)findViewById(R.id.live_status);
        firstTeam=(TextView)findViewById(R.id.team1);
        secondTeam=(TextView)findViewById(R.id.team2);
        targetRun=(TextView)findViewById(R.id.runs_one);
        currentRun=(TextView)findViewById(R.id.runs_second);
        currentStatus=(TextView)findViewById(R.id.current_status);
        try {
            UsefullInfoFragment.insert();                           // Inserting new Values
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
                int oldScore=Integer.parseInt(targetRun.getText().toString());
                String newScore=String.valueOf(oldScore+1);
                targetRun.setText(newScore);
                i++;
                handler.postDelayed(this, 10000);
            }
        }
    };

    @Override
    public void refresh() {
        liveDescription.setText(CricketAppManager.GetInstance().getData("live"));
        firstTeam.setText(CricketAppManager.GetInstance().getData("team1"));
        secondTeam.setText(CricketAppManager.GetInstance().getData("team2"));
        targetRun.setText(CricketAppManager.GetInstance().getData("target"));
        currentRun.setText(CricketAppManager.GetInstance().getData("current"));
        currentStatus.setText(CricketAppManager.GetInstance().getData("status"));
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
    public static void insert1()
    {
        CricketAppManager.GetInstance().addData("batsman_one","G Gambhir* (lhb)");
        CricketAppManager.GetInstance().addData("batsman_second","Shreyas Iyer (rhb)");

        CricketAppManager.GetInstance().addData("R1","30");
        CricketAppManager.GetInstance().addData("B1","17");
        CricketAppManager.GetInstance().addData("4s1","4");
        CricketAppManager.GetInstance().addData("6s1","1");
        CricketAppManager.GetInstance().addData("SR1","152.94");

        CricketAppManager.GetInstance().addData("R2","20");
        CricketAppManager.GetInstance().addData("B2","8");
        CricketAppManager.GetInstance().addData("4s2","1");
        CricketAppManager.GetInstance().addData("6s2","1");
        CricketAppManager.GetInstance().addData("SR2","150.00");

        CricketAppManager.GetInstance().addData("bowler_one","K Jadhav (ob)");
        CricketAppManager.GetInstance().addData("bowler_second","S Thakur (lm)");

        CricketAppManager.GetInstance().addData("O1","2");
        CricketAppManager.GetInstance().addData("M1","0");
        CricketAppManager.GetInstance().addData("Run1","9");
        CricketAppManager.GetInstance().addData("W1","0");
        CricketAppManager.GetInstance().addData("Econ1","9.00");

        CricketAppManager.GetInstance().addData("O2","3");
        CricketAppManager.GetInstance().addData("M2","0");
        CricketAppManager.GetInstance().addData("Run2","20");
        CricketAppManager.GetInstance().addData("W2","1");
        CricketAppManager.GetInstance().addData("Econ2","11.00");

        CricketAppManager.GetInstance().addData("live","4th Match(N),Indian Premier League at Hyderabad, Apr 9 2018");
        CricketAppManager.GetInstance().addData("team1","DD");
        CricketAppManager.GetInstance().addData("team2","CSK");
        CricketAppManager.GetInstance().addData("target","130");
        CricketAppManager.GetInstance().addData("current","50/1* (6/20 ovr,tgt 131)");
        CricketAppManager.GetInstance().addData("status","Delhi Dare Devils requires another 81 runs with 9 wickets and 14.0 overs remaining");

    }
}
