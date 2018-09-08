package Data;

import java.util.HashMap;
import java.util.Iterator;

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

    private HashMap<String,String> mScoreData = new HashMap<String,String>();

 }
