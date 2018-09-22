package com.app.cricket;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import Data.ScoreUIBase;

public class LiveFragment extends Fragment implements ScoreUIBase
{
    public LiveFragment(){}
    
    TextView firstBatsman,secondBatsman,firstBowler,SecondBowler;
    TextView firstRuns,secondRuns,firstBalls,secondBalls,firstFours,secondFours,firstSixers,secondSixers,firstSr,secondSr;
    TextView firstOver,secondOver,firstOverRuns,secondOverRuns,firstMaiden,secondMaiden,firstWicket,secondWicket,firstEco,secondEco;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_live, container, false);

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

            refresh();

        } catch (Exception e) {
            e.printStackTrace();
        }
        return rootView;
    }
    @Override
    public void refresh()
    {
        firstBatsman.setText(ScoreActivity.scoreModels.get(0).getBatsmanList().get(0).getName());
        firstRuns.setText( ScoreActivity.scoreModels.get(0).getBatsmanList().get(0).getRuns());
        firstBalls.setText(ScoreActivity.scoreModels.get(0).getBatsmanList().get(0).getBalls());
        firstFours.setText(ScoreActivity.scoreModels.get(0).getBatsmanList().get(0).getFour());
        firstSixers.setText(ScoreActivity.scoreModels.get(0).getBatsmanList().get(0).getSixer());
        firstSr.setText(ScoreActivity.scoreModels.get(0).getBatsmanList().get(0).getSR());

        secondBatsman.setText(ScoreActivity.scoreModels.get(0).getBatsmanList().get(1).getName());
        secondRuns.setText(ScoreActivity.scoreModels.get(0).getBatsmanList().get(1).getRuns());
        secondBalls.setText(ScoreActivity.scoreModels.get(0).getBatsmanList().get(1).getBalls());
        secondFours.setText(ScoreActivity.scoreModels.get(0).getBatsmanList().get(1).getFour());
        secondSixers.setText(ScoreActivity.scoreModels.get(0).getBatsmanList().get(1).getSixer());
        secondSr.setText(ScoreActivity.scoreModels.get(0).getBatsmanList().get(1).getSR());

        firstBowler.setText(ScoreActivity.scoreModels.get(0).getBowlerList().get(0).getName());
        firstOver.setText(ScoreActivity.scoreModels.get(0).getBowlerList().get(0).getOver());
        firstMaiden.setText(ScoreActivity.scoreModels.get(0).getBowlerList().get(0).getMaiden());
        firstOverRuns.setText(ScoreActivity.scoreModels.get(0).getBowlerList().get(0).getRuns());
        firstWicket.setText(ScoreActivity.scoreModels.get(0).getBowlerList().get(0).getWicket());
        firstEco.setText(ScoreActivity.scoreModels.get(0).getBowlerList().get(0).getECO());

        SecondBowler.setText(ScoreActivity.scoreModels.get(0).getBowlerList().get(1).getName());
        secondOver.setText(ScoreActivity.scoreModels.get(0).getBowlerList().get(1).getOver());
        secondMaiden.setText(ScoreActivity.scoreModels.get(0).getBowlerList().get(1).getMaiden());
        secondOverRuns.setText(ScoreActivity.scoreModels.get(0).getBowlerList().get(1).getRuns());
        secondWicket.setText(ScoreActivity.scoreModels.get(0).getBowlerList().get(1).getWicket());
        secondEco.setText(ScoreActivity.scoreModels.get(0).getBowlerList().get(1).getECO());
    }
}
