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

public class UsefullInfoFragment extends Fragment
{
    public UsefullInfoFragment(){}
    ScoreData dScoreData=new ScoreData();
    TextView firstBatsman,secondBatsman,firstBowler,SecondBowler;
    TextView firstRuns,secondRuns,firstBalls,secondBalls,firstFours,secondFours,firstSixers,secondSixers,firstSr,secondSr;
    TextView firstOver,secondOver,firstOverRuns,secondOverRuns,firstMaiden,secondMaiden,firstWicket,secondWicket,firstEco,secondEco;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_usefull_info, container, false);

        try {

            insert();

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

            Set();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rootView;
    }

    public void insert()
    {
        dScoreData.addData("batsman_one","S Dhawan* (lhb)");
        dScoreData.addData("batsman_second","KS Williamson (rhb)");

        dScoreData.addData("R1","26");
        dScoreData.addData("B1","17");
        dScoreData.addData("4s1","4");
        dScoreData.addData("6s1","1");
        dScoreData.addData("SR1","152.94");

        dScoreData.addData("R2","12");
        dScoreData.addData("B2","8");
        dScoreData.addData("4s2","1");
        dScoreData.addData("6s2","1");
        dScoreData.addData("SR2","150.00");

        dScoreData.addData("bowler_one","K Gowtham (ob)");
        dScoreData.addData("bowler_second","JD Unadkat (lm)");

        dScoreData.addData("O1","1");
        dScoreData.addData("M1","0");
        dScoreData.addData("Run1","9");
        dScoreData.addData("W1","0");
        dScoreData.addData("Econ1","9.00");

        dScoreData.addData("O2","2");
        dScoreData.addData("M2","0");
        dScoreData.addData("Run2","22");
        dScoreData.addData("W2","1");
        dScoreData.addData("Econ2","11.00");
    }
    public void Set()
    {
        firstBatsman.setText(dScoreData.getData("batsman_one"));
        firstRuns.setText(dScoreData.getData("R1"));
        firstBalls.setText(dScoreData.getData("B1"));
        firstFours.setText(dScoreData.getData("4s1"));
        firstSixers.setText(dScoreData.getData("6s1"));
        firstSr.setText(dScoreData.getData("SR1"));

        secondBatsman.setText(dScoreData.getData("batsman_second"));
        secondRuns.setText(dScoreData.getData("R2"));
        secondBalls.setText(dScoreData.getData("B2"));
        secondFours.setText(dScoreData.getData("4s2"));
        secondSixers.setText(dScoreData.getData("6s2"));
        secondSr.setText(dScoreData.getData("SR2"));

        firstBowler.setText(dScoreData.getData("bowler_one"));
        firstOver.setText(dScoreData.getData("O1"));
        firstMaiden.setText(dScoreData.getData("M1"));
        firstOverRuns.setText(dScoreData.getData("Run1"));
        firstWicket.setText(dScoreData.getData("W1"));
        firstEco.setText(dScoreData.getData("Econ1"));

        SecondBowler.setText(dScoreData.getData("bowler_second"));
        secondOver.setText(dScoreData.getData("O2"));
        secondMaiden.setText(dScoreData.getData("M2"));
        secondOverRuns.setText(dScoreData.getData("Run2"));
        secondWicket.setText(dScoreData.getData("W2"));
        secondEco.setText(dScoreData.getData("Econ2"));
    }
}
