package Data;

import android.annotation.SuppressLint;

import com.app.cricket.CricketAppManager;

import java.util.HashMap;

public class ScoreData
{

    public void addData(String name, String val)    //to add values to HasMap
    {
        mScoreData.put(name, val);
    }
    public String  getData(String name)             // to get values from HashMap
    {
        String value = null;
        value=(String)mScoreData.get(name);
        return value;
    }
    public void clear()                         //  to clear Hashmap
    {
        mScoreData.clear();
    }
    @SuppressLint("NewApi")
    public void updateScore(String keyValue, String value)
    {
        mScoreData.remove(keyValue);
        mScoreData.put(keyValue, value);
    }

    private HashMap<String,String> mScoreData = new HashMap<String,String>();

 }
