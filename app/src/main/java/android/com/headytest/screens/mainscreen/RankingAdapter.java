package android.com.headytest.screens.mainscreen;

import android.com.headytest.R;
import android.com.headytest.realm.RankingRm;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import io.realm.RealmResults;

/**
 * Created by Praveen on 25-02-2018.
 */

public class RankingAdapter extends RecyclerView.Adapter<RankingAdapter.MyViewHolder> {

    private List<RankingRm> moviesList;
    private int positionm;

    public RankingAdapter(RealmResults<RankingRm> rmRealmResults, int position) {
        this.moviesList = rmRealmResults;
        this.positionm = position;
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView tv_pro_id, tv_pro_count;

        public MyViewHolder(View view) {
            super(view);
            tv_pro_id = (TextView) view.findViewById(R.id.tv_pro_id);
            tv_pro_count = (TextView) view.findViewById(R.id.tv_pro_count);
        }
    }


    public RankingAdapter(List<RankingRm> moviesList) {
        this.moviesList = moviesList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_ranking, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        RankingRm movie = moviesList.get(position);
        holder.tv_pro_id.setText("Product Id : " + movie.getProductId());
        if (positionm == 0)
            holder.tv_pro_count.setText("View Count : " + movie.getViewCount());
        else if (positionm == 1)
            holder.tv_pro_count.setText("Order Count : " + movie.getViewCount());
        else if (positionm == 2)
            holder.tv_pro_count.setText("Shares : " + movie.getViewCount());

    }

    @Override
    public int getItemCount() {
        return moviesList.size();
    }
}