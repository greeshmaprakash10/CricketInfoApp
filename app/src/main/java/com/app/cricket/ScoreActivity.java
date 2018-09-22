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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import Data.DownloadManager;
import Model.ScoreCardData;
import Data.ScoreData;
import Data.ScoreUIBase;

public class ScoreActivity extends FragmentActivity implements ScoreUIBase
{
    TextView liveDescription,firstTeam,secondTeam,targetRun,currentRun,currentStatus;
    String url="http://139.59.3.107/cricket/cricket_data.json";
    String Url="http://139.59.3.107/cricket/score_card.json";
    Context mContext;
    Handler handler;
    ImageView imageView;
    String status;
    public static ArrayList<ScoreCardData> scoreModels;
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
        try
        {
            CricketAppManager.GetInstance().download(url,mContext);
            handler.post(updateView);
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
    public Runnable updateView = new Runnable()
    {
        private int i = 1;
        @Override
        public void run()
        {
            if(i <= 50)
            {
//                CricketAppManager.GetInstance().download(url,mContext);
//                long startTime=System.currentTimeMillis();
//                while(CricketAppManager.GetInstance().isReady()==true&&(System.currentTimeMillis()-startTime)<10000)
//                {
                    CricketAppManager.GetInstance().downloadScoreCard(Url,mContext);
//                }

            }
        }
    };

    @Override
    public void refresh()
    {
        liveDescription.setText(scoreModels.get(0).getMatch_description());
        //firstTeam.setText(scoreModels.get(0).getTeam_bat());
        //secondTeam.setText(scoreModels.get(0).getTeam_ball());
        targetRun.setText(scoreModels.get(0).getTarget_run());
        currentRun.setText(scoreModels.get(0).getCurrent_run());
        currentStatus.setText(scoreModels.get(0).getMatch_status());
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
        adapter.addFragment(new ReportFragment(),"Report");
        adapter.addFragment(new CommentaryFragment(),"Commentary");
        viewPager.setAdapter(adapter);
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
