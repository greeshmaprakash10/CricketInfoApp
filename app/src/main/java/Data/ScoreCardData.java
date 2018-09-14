package Data;

import java.io.Serializable;
import java.util.List;

import Model.BatsmanListModel;
import Model.BowlerListModel;

public class ScoreCardData implements Serializable
{
    String team_bat,team_ball,extras,total,fall_one,fall_two,fall_three,fall_four,fall_five;
    List<BatsmanListModel> batsmanList;
    List<BowlerListModel> bowlerList;

    public ScoreCardData(String team_bat, String team_ball, String extras, String total,
                         String fall_one, String fall_two, String fall_three, String fall_four,
                         String fall_five, List<BatsmanListModel> batsmanList, List<BowlerListModel> bowlerList) {
        this.team_bat = team_bat;
        this.team_ball = team_ball;
        this.extras = extras;
        this.total = total;
        this.fall_one = fall_one;
        this.fall_two = fall_two;
        this.fall_three = fall_three;
        this.fall_four = fall_four;
        this.fall_five = fall_five;
        this.batsmanList = batsmanList;
        this.bowlerList = bowlerList;
    }

    public String getTeam_bat() {
        return team_bat;
    }

    public String getTeam_ball() {
        return team_ball;
    }

    public String getExtras() {
        return extras;
    }

    public String getTotal() {
        return total;
    }

    public String getFall_one() {
        return fall_one;
    }

    public String getFall_two() {
        return fall_two;
    }

    public String getFall_three() {
        return fall_three;
    }

    public String getFall_four() {
        return fall_four;
    }

    public String getFall_five() {
        return fall_five;
    }

    public List<BatsmanListModel> getBatsmanList() {
        return batsmanList;
    }

    public List<BowlerListModel> getBowlerList() {
        return bowlerList;
    }
}
