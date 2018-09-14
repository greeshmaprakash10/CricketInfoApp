package Model;

import java.io.Serializable;

public class BatsmanListModel implements Serializable
{
    String id,name,status,runs,balls,four,sixer,SR;

    public BatsmanListModel(String id, String name, String status, String runs, String balls, String four, String sixer, String SR) {
        this.id = id;
        this.name = name;
        this.status = status;
        this.runs = runs;
        this.balls = balls;
        this.four = four;
        this.sixer = sixer;
        this.SR = SR;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getStatus() {
        return status;
    }

    public String getRuns() {
        return runs;
    }

    public String getBalls() {
        return balls;
    }

    public String getFour() {
        return four;
    }

    public String getSixer() {
        return sixer;
    }

    public String getSR() {
        return SR;
    }
}
