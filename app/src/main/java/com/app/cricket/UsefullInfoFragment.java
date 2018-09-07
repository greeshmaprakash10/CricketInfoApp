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
        CricketAppManager.GetInstance().addData("batsman_one","S Dhawan* (lhb)");
        CricketAppManager.GetInstance().addData("batsman_second","KS Williamson (rhb)");

        CricketAppManager.GetInstance().addData("R1","26");
        CricketAppManager.GetInstance().addData("B1","17");
        CricketAppManager.GetInstance().addData("4s1","4");
        CricketAppManager.GetInstance().addData("6s1","1");
        CricketAppManager.GetInstance().addData("SR1","152.94");

        CricketAppManager.GetInstance().addData("R2","12");
        CricketAppManager.GetInstance().addData("B2","8");
        CricketAppManager.GetInstance().addData("4s2","1");
        CricketAppManager.GetInstance().addData("6s2","1");
        CricketAppManager.GetInstance().addData("SR2","150.00");

        CricketAppManager.GetInstance().addData("bowler_one","K Gowtham (ob)");
        CricketAppManager.GetInstance().addData("bowler_second","JD Unadkat (lm)");

        CricketAppManager.GetInstance().addData("O1","1");
        CricketAppManager.GetInstance().addData("M1","0");
        CricketAppManager.GetInstance().addData("Run1","9");
        CricketAppManager.GetInstance().addData("W1","0");
        CricketAppManager.GetInstance().addData("Econ1","9.00");

        CricketAppManager.GetInstance().addData("O2","2");
        CricketAppManager.GetInstance().addData("M2","0");
        CricketAppManager.GetInstance().addData("Run2","22");
        CricketAppManager.GetInstance().addData("W2","1");
        CricketAppManager.GetInstance().addData("Econ2","11.00");

        CricketAppManager.GetInstance().addData("live","4th Match(N),Indian Premier League at Hyderabad, Apr 9 2018");
        CricketAppManager.GetInstance().addData("team1","RR");
        CricketAppManager.GetInstance().addData("team2","SRH");
        CricketAppManager.GetInstance().addData("target","125/9");
        CricketAppManager.GetInstance().addData("current","45/1* (5/20 ovr,tgt 126)");
        CricketAppManager.GetInstance().addData("status","Sunrisers Hyderabad requires another 81 runs with 9 wickets and 15.0 overs remaining");

    }

    @Override
    public void refresh()
    {
        firstBatsman.setText( CricketAppManager.GetInstance().getData("batsman_one"));
        firstRuns.setText( CricketAppManager.GetInstance().getData("R1"));
        firstBalls.setText( CricketAppManager.GetInstance().getData("B1"));
        firstFours.setText( CricketAppManager.GetInstance().getData("4s1"));
        firstSixers.setText( CricketAppManager.GetInstance().getData("6s1"));
        firstSr.setText( CricketAppManager.GetInstance().getData("SR1"));

        secondBatsman.setText( CricketAppManager.GetInstance().getData("batsman_second"));
        secondRuns.setText( CricketAppManager.GetInstance().getData("R2"));
        secondBalls.setText( CricketAppManager.GetInstance().getData("B2"));
        secondFours.setText( CricketAppManager.GetInstance().getData("4s2"));
        secondSixers.setText( CricketAppManager.GetInstance().getData("6s2"));
        secondSr.setText( CricketAppManager.GetInstance().getData("SR2"));

        firstBowler.setText( CricketAppManager.GetInstance().getData("bowler_one"));
        firstOver.setText( CricketAppManager.GetInstance().getData("O1"));
        firstMaiden.setText( CricketAppManager.GetInstance().getData("M1"));
        firstOverRuns.setText( CricketAppManager.GetInstance().getData("Run1"));
        firstWicket.setText( CricketAppManager.GetInstance().getData("W1"));
        firstEco.setText( CricketAppManager.GetInstance().getData("Econ1"));

        SecondBowler.setText( CricketAppManager.GetInstance().getData("bowler_second"));
        secondOver.setText( CricketAppManager.GetInstance().getData("O2"));
        secondMaiden.setText( CricketAppManager.GetInstance().getData("M2"));
        secondOverRuns.setText( CricketAppManager.GetInstance().getData("Run2"));
        secondWicket.setText( CricketAppManager.GetInstance().getData("W2"));
        secondEco.setText( CricketAppManager.GetInstance().getData("Econ2"));
    }
}
