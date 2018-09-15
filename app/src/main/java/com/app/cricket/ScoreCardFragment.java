package com.app.cricket;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import Adapter.ScoreCardBatsmanAdapter;
import Adapter.ScoreCardBowlerAdapter;
import Data.ScoreUIBase;

public class ScoreCardFragment extends Fragment implements ScoreUIBase
{
    RecyclerView recyclerView1,recyclerView2;
    Context mContext;
    TextView team,total,fallWickets;
    ScoreCardBatsmanAdapter adapter;
    ScoreCardBowlerAdapter bowlerAdapter;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState)
    {
        View rootView = inflater.inflate(R.layout.fragment_score_card, container, false);
        recyclerView1=(RecyclerView)rootView.findViewById(R.id.recyclerview_batsman);
        recyclerView2=(RecyclerView)rootView.findViewById(R.id.recyclerview_bowlers);
        team=(TextView)rootView.findViewById(R.id.score_card_team);
        total=(TextView)rootView.findViewById(R.id.score_card_total);
        fallWickets=(TextView)rootView.findViewById(R.id.score_card_fallofwicket);

        mContext=getContext();
        try
        {
            team.setText(ScoreActivity.scoreModels.get(0).getTeam_bat());
            total.setText(ScoreActivity.scoreModels.get(0).getTotal());
            fallWickets.setText(ScoreActivity.scoreModels.get(0).getFall_five()+","+ScoreActivity.scoreModels.get(0).getFall_four()+
            ","+ScoreActivity.scoreModels.get(0).getFall_three()+","+ScoreActivity.scoreModels.get(0).getFall_two()+","+
                    ScoreActivity.scoreModels.get(0).getFall_one());

            if(ScoreActivity.scoreModels!=null)
            {
                adapter=new ScoreCardBatsmanAdapter(mContext,ScoreActivity.scoreModels.get(0).getBatsmanList());
                LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
                recyclerView1.setNestedScrollingEnabled(true);
                recyclerView1.setLayoutManager(mLayoutManager);
                recyclerView1.setAdapter(adapter);

                bowlerAdapter=new ScoreCardBowlerAdapter(mContext,ScoreActivity.scoreModels.get(0).getBowlerList());
                LinearLayoutManager layoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
                recyclerView2.setNestedScrollingEnabled(true);
                recyclerView2.setLayoutManager(layoutManager);
                recyclerView2.setAdapter(bowlerAdapter);


            }


        } catch (Exception e) {
            e.printStackTrace();
        }

        return rootView;
    }
    @Override
    public void refresh()
    {

    }

    @Override
    public void onResume() {
        super.onResume();
        try {
            if(ScoreActivity.scoreModels.size()>0)
            adapter.updateValues(ScoreActivity.scoreModels.get(0).getBatsmanList());
            bowlerAdapter.updateValues(ScoreActivity.scoreModels.get(0).getBowlerList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}

