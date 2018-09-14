package Model;

import java.io.Serializable;

public class BowlerListModel implements Serializable
{
    String id,name,over,maiden,runs,wicket,NB,WD,ECO;

    public BowlerListModel(String id, String name, String over, String maiden,
                           String runs, String wicket, String NB, String WD, String ECO)
    {
        this.id = id;
        this.name = name;
        this.over = over;
        this.maiden = maiden;
        this.runs = runs;
        this.wicket = wicket;
        this.NB = NB;
        this.WD = WD;
        this.ECO = ECO;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getOver() {
        return over;
    }

    public String getMaiden() {
        return maiden;
    }

    public String getRuns() {
        return runs;
    }

    public String getWicket() {
        return wicket;
    }

    public String getNB() {
        return NB;
    }

    public String getWD() {
        return WD;
    }

    public String getECO() {
        return ECO;
    }
}
