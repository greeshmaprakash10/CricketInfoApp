package com.app.cricket;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import Data.ScoreData;
import Data.ScoreUIBase;

public class UsefullInfoFragment extends Fragment implements ScoreUIBase
{
    public UsefullInfoFragment(){}
    
    TextView firstBatsman,secondBatsman,firstBowler,SecondBowler;
    TextView firstRuns,secondRuns,firstBalls,secondBalls,firstFours,secondFours,firstSixers,secondSixers,firstSr,secondSr;
    TextView firstOver,secondOver,firstOverRuns,secondOverRuns,firstMaiden,secondMaiden,firstWicket,secondWicket,firstEco,secondEco;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_usefull_info, container, false);

        CricketAppManager.GetInstance().addUI(this);

        try
        {
            firstBatsman=rootView.findViewById(R.id.first_bat);
            firstRuns=rootView.findViewById(R.id.first_run);
            firstBalls=rootView.findViewById(R.id.first_ball);
            firstFours=rootView.findViewById(R.id.first_fours);
            firstSixers=rootView.findViewById(R.id.first_sixer);
            firstSr=rootView.findViewById(R.id.first_strike_rate);

            secondBatsman=rootView.findViewById(R.id.second_bats);
            secondRuns=rootView.findViewById(R.id.second_runs);
            secondBalls=rootView.findViewById(R.id.second_balls);
            secondFours=rootView.findViewById(R.id.second_fours);
            secondSixers=rootView.findViewById(R.id.second_sixer);
            secondSr=rootView.findViewById(R.id.second_strike_rate);

            firstBowler=rootView.findViewById(R.id.first_bowler);
            firstOver=rootView.findViewById(R.id.first_over);
            firstMaiden=rootView.findViewById(R.id.first_maiden);
            firstOverRuns=rootView.findViewById(R.id.first_over_run);
            firstWicket=rootView.findViewById(R.id.first_wicket);
            firstEco=rootView.findViewById(R.id.first_eco);

            SecondBowler=rootView.findViewById(R.id.second_bowler);
            secondOver=rootView.findViewById(R.id.second_over);
            secondMaiden=rootView.findViewById(R.id.second_maiden);
            secondOverRuns=rootView.findViewById(R.id.second_over_run);
            secondWicket=rootView.findViewById(R.id.second_wicket);
            secondEco=rootView.findViewById(R.id.second_econ);

            //CricketAppManager.GetInstance().clear();
            refresh();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rootView;
    }

    public static void insert()
    {
        CricketAppManager.GetInstance().addData("name_one","S Dhawan* (lhb)");
        CricketAppManager.GetInstance().addData("name_two","KS Williamson (rhb)");

        CricketAppManager.GetInstance().addData("runs_one","26");
        CricketAppManager.GetInstance().addData("balls_one","17");
        CricketAppManager.GetInstance().addData("4s_one","4");
        CricketAppManager.GetInstance().addData("6s_one","1");
        CricketAppManager.GetInstance().addData("strikerate_one","152.94");

        CricketAppManager.GetInstance().addData("runs_two","12");
        CricketAppManager.GetInstance().addData("balls_two","8");
        CricketAppManager.GetInstance().addData("4s_two","1");
        CricketAppManager.GetInstance().addData("6s_two","1");
        CricketAppManager.GetInstance().addData("strikerate_two","150.00");

        CricketAppManager.GetInstance().addData("name1","K Gowtham (ob)");
        CricketAppManager.GetInstance().addData("name2","JD Unadkat (lm)");

        CricketAppManager.GetInstance().addData("over1","1");
        CricketAppManager.GetInstance().addData("maiden1","0");
        CricketAppManager.GetInstance().addData("runs1","9");
        CricketAppManager.GetInstance().addData("wicket1","0");
        CricketAppManager.GetInstance().addData("economy1","9.00");

        CricketAppManager.GetInstance().addData("over2","2");
        CricketAppManager.GetInstance().addData("maiden2","0");
        CricketAppManager.GetInstance().addData("runs2","22");
        CricketAppManager.GetInstance().addData("wicket2","1");
        CricketAppManager.GetInstance().addData("economy2","11.00");

        CricketAppManager.GetInstance().addData("match_description","4th Match(N),Indian Premier League at Hyderabad, Apr 9 2018");
        CricketAppManager.GetInstance().addData("team_one","RR");
        CricketAppManager.GetInstance().addData("team_two","SRH");
        CricketAppManager.GetInstance().addData("target_run","125");
        CricketAppManager.GetInstance().addData("current_run","45/1* (5/20 ovr,tgt 126)");
        CricketAppManager.GetInstance().addData("match_status","Sunrisers Hyderabad requires another 81 runs with 9 wickets and 15.0 overs remaining");

    }

    @Override
    public void refresh()
    {
        firstBatsman.setText( CricketAppManager.GetInstance().getData("name_one"));
        firstRuns.setText( CricketAppManager.GetInstance().getData("runs_one"));
        firstBalls.setText( CricketAppManager.GetInstance().getData("balls_one"));
        firstFours.setText( CricketAppManager.GetInstance().getData("4s_one"));
        firstSixers.setText( CricketAppManager.GetInstance().getData("6s_one"));
        firstSr.setText( CricketAppManager.GetInstance().getData("strikerate_one"));

        secondBatsman.setText( CricketAppManager.GetInstance().getData("name_two"));
        secondRuns.setText( CricketAppManager.GetInstance().getData("runs_two"));
        secondBalls.setText( CricketAppManager.GetInstance().getData("balls_two"));
        secondFours.setText( CricketAppManager.GetInstance().getData("4s_two"));
        secondSixers.setText( CricketAppManager.GetInstance().getData("6s_two"));
        secondSr.setText( CricketAppManager.GetInstance().getData("strikerate_two"));

        firstBowler.setText( CricketAppManager.GetInstance().getData("name1"));
        firstOver.setText( CricketAppManager.GetInstance().getData("over1"));
        firstMaiden.setText( CricketAppManager.GetInstance().getData("maiden1"));
        firstOverRuns.setText( CricketAppManager.GetInstance().getData("runs1"));
        firstWicket.setText( CricketAppManager.GetInstance().getData("wicket1"));
        firstEco.setText( CricketAppManager.GetInstance().getData("economy1"));

        SecondBowler.setText( CricketAppManager.GetInstance().getData("name2"));
        secondOver.setText( CricketAppManager.GetInstance().getData("over2"));
        secondMaiden.setText( CricketAppManager.GetInstance().getData("maiden2"));
        secondOverRuns.setText( CricketAppManager.GetInstance().getData("runs2"));
        secondWicket.setText( CricketAppManager.GetInstance().getData("wicket2"));
        secondEco.setText( CricketAppManager.GetInstance().getData("economy2"));
    }
}
