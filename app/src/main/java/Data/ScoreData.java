package Data;

import java.util.HashMap;
import java.util.Iterator;

public class ScoreData
{

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
