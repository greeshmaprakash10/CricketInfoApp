package com.app.cricket;

import java.util.HashMap;

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
        mScoreData.put(name, val);
    }

    public String  getData(String name)
    {
        String value = null;
        value=(String)mScoreData.get(name);
        return value;
    }

    private HashMap<String,String> mScoreData = new HashMap<String,String>();

}
