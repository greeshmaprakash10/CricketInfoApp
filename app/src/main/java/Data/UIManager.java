package Data;

import java.util.Vector;

public class UIManager {
    public void refresh()
    {
        for (int i = 0; i < mUIObjs.size(); i++)
        {
            mUIObjs.get(i).refresh();
        }
    }
    public void addUI(ScoreUIBase ui)
    {
        mUIObjs.add(ui);
    }

    private Vector<ScoreUIBase> mUIObjs = new Vector<ScoreUIBase>();
}
