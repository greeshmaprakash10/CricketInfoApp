package Model;

import java.io.Serializable;
import java.util.List;

import Model.BatsmanListModel;
import Model.BowlerListModel;

public class ScoreCardData implements Serializable
{
    String team_bat,team_ball,match_description,match_status,target_run,current_run,extras,
            total,fall_one,fall_two,fall_three,fall_four,fall_five;
    List<BatsmanListModel> batsmanList;
    List<BowlerListModel> bowlerList;

    public ScoreCardData(String team_bat, String team_ball, String match_description,
                         String match_status, String target_run, String current_run,
                         String extras, String total, String fall_one, String fall_two,
                         String fall_three, String fall_four, String fall_five,
                         List<BatsmanListModel> batsmanList, List<BowlerListModel> bowlerList) {
        this.team_bat = team_bat;
        this.team_ball = team_ball;
        this.match_description = match_description;
        this.match_status = match_status;
        this.target_run = target_run;
        this.current_run = current_run;
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

    public String getMatch_description() {
        return match_description;
    }

    public String getMatch_status() {
        return match_status;
    }

    public String getTarget_run() {
        return target_run;
    }

    public String getCurrent_run() {
        return current_run;
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

