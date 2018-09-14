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

import java.util.List;

import Adapter.ScoreCardAdapter;
import Data.DownloadManager;
import Data.ScoreCardData;
import Data.ScoreUIBase;

public class ScoreCardFragment extends Fragment implements ScoreUIBase
{
    RecyclerView recyclerView;
    Context mContext;
    public ScoreCardFragment(){}

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_score_card, container, false);
        recyclerView=(RecyclerView)rootView.findViewById(R.id.recyclerview_scorecard);
        mContext=getContext();
        try
        {
            ScoreCardAdapter adapter=new ScoreCardAdapter(mContext,ScoreActivity.scoreModels);
            LinearLayoutManager mLayoutManager = new LinearLayoutManager(mContext, LinearLayoutManager.VERTICAL,false);
            recyclerView.setNestedScrollingEnabled(true);
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setAdapter(adapter);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return rootView;
    }
    @Override
    public void refresh() {

    }
}

