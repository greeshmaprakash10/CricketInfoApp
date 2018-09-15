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

import Model.BatsmanListModel;

public class ScoreCardBatsmanAdapter extends RecyclerView.Adapter<ScoreCardBatsmanAdapter.MyViewHolder>
{
    private Context mContext;
    private List<BatsmanListModel> mScoreCardData ;


    public class MyViewHolder extends RecyclerView.ViewHolder
    {
        TextView name,status,runs,balls,four,six,sr;
        public MyViewHolder(View itemView)
        {
            super(itemView);

            name=(TextView)itemView.findViewById(R.id.score_card_name);
            status=(TextView)itemView.findViewById(R.id.score_card_status);
            runs=(TextView)itemView.findViewById(R.id.score_card_runs);
            balls=(TextView)itemView.findViewById(R.id.score_card_balls);
            four=(TextView)itemView.findViewById(R.id.score_card_four);
            six=(TextView)itemView.findViewById(R.id.score_card_six);
            sr=(TextView)itemView.findViewById(R.id.score_card_sr);
        }
    }

    public ScoreCardBatsmanAdapter(Context mContext, List<BatsmanListModel> mScoreCardData)
    {
        this.mContext = mContext;
        this.mScoreCardData = mScoreCardData;
    }
    public void updateValues(List<BatsmanListModel> list)
    {
        mScoreCardData=list;
        this.notifyDataSetChanged();;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.score_card_batsman_list, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position)
    {
        try {
            BatsmanListModel scoreCardData=mScoreCardData.get(position);
            holder.name.setText(scoreCardData.getName());
            holder.status.setText(scoreCardData.getStatus());
            holder.runs.setText(scoreCardData.getRuns());
            holder.balls.setText(scoreCardData.getBalls());
            holder.four.setText(scoreCardData.getFour());
            holder.six.setText(scoreCardData.getSixer());
            holder.sr.setText(scoreCardData.getSR());
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
