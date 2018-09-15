package Adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.app.cricket.R;

import java.util.List;
import Model.BowlerListModel;

public class ScoreCardBowlerAdapter extends RecyclerView.Adapter<ScoreCardBowlerAdapter.ViewHolder>
{
    private Context mContext;
    private List<BowlerListModel> mScoreCardData ;

    public class ViewHolder extends RecyclerView.ViewHolder
    {
        TextView bname,bover,bmaiden,bruns,bwicket,beco;
        public ViewHolder(View itemView)
        {
            super(itemView);

            bname=(TextView)itemView.findViewById(R.id.score_card_ball_name);
            bover=(TextView)itemView.findViewById(R.id.score_card_ball_over);
            bmaiden=(TextView)itemView.findViewById(R.id.score_card_ball_maiden);
            bruns=(TextView)itemView.findViewById(R.id.score_card_ball_runs);
            bwicket=(TextView)itemView.findViewById(R.id.score_card_ball_wicket);
            beco=(TextView)itemView.findViewById(R.id.score_card_ball_eco);
        }
    }
    public ScoreCardBowlerAdapter(Context mContext, List<BowlerListModel> mScoreCardData)
    {
        this.mContext = mContext;
        this.mScoreCardData = mScoreCardData;
    }

    public void updateValues(List<BowlerListModel> list)
    {
        mScoreCardData=list;
        this.notifyDataSetChanged();;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.score_card_bowler_list, parent, false);

        return new ViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position)
    {
        try {
            BowlerListModel scoreCardData=mScoreCardData.get(position);
            holder.bname.setText(scoreCardData.getName());
            holder.bover.setText(scoreCardData.getOver());
            holder.bmaiden.setText(scoreCardData.getMaiden());
            holder.bruns.setText(scoreCardData.getRuns());
            holder.bwicket.setText(scoreCardData.getWicket());
            holder.beco.setText(scoreCardData.getECO());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Override
    public int getItemCount() {
        int size=0;
        try {
            size=mScoreCardData.size();
        } catch (Exception e) {
            size=0;
            e.printStackTrace();
        }
        return size;
    }


}
