package Data;

import java.util.HashMap;

public class MatchData
{
    public void addMatch(String name,String value)
    {
        mMatchData.put(name,value);
    }
    public String getMatch(String name)
    {
        String value = null;
        value=(String)mMatchData.get(name);
        return value;
    }
    private HashMap<String,String> mMatchData = new HashMap<String,String>();
}
