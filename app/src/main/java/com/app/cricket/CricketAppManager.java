package com.app.cricket;

import android.content.Context;

import java.util.HashMap;

import Data.DownloadManager;
import Data.ScoreData;
import Data.ScoreUIBase;
import Data.UIManager;

public class CricketAppManager
{
    private CricketAppManager() { }
    public static CricketAppManager GetInstance()
    {
        if (mManager == null)
        {
            mManager = new CricketAppManager();
        }
        return mManager;
    }
    private static CricketAppManager mManager = null;

    public void addData(String name, String val)
    {
        mScoreData.addData(name, val);
    }

    public String  getData(String name){return mScoreData.getData(name);}

    public void refresh(){mUIManger.refresh();}

    public void addUI(ScoreUIBase ui){ mUIManger.addUI(ui); }

    public void clear(){mScoreData.clear();}
    public boolean isReady(){return mDownload.isReady();}

    public void download(String Url,Context context){mDownload.download(Url,context);}
    public void downloadScoreCard(String Url,Context context){mDownload.downloadScoreCard(Url,context);}

    private ScoreData mScoreData = new ScoreData();
    private UIManager mUIManger = new UIManager();
    private DownloadManager mDownload=new DownloadManager();

}
