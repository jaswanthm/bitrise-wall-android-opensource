package xyz.jaswanth.bitwall;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import xyz.jaswanth.bitwall.pojo.BitriseBuild;

public class BuildListRecyclerViewAdapter extends RecyclerView.Adapter<BuildListRecyclerViewAdapter.ViewHolder> {

    private List<BitriseBuild> bitriseBuildList;
    private Context activityContext;

    public BuildListRecyclerViewAdapter(Context context) {
        bitriseBuildList = new ArrayList<>();
        this.activityContext = context;
    }

    @Override
    public BuildListRecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                                      int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.build_list_recyclerview_item_layout, parent, false);

        BuildListRecyclerViewAdapter.ViewHolder viewHolder = new BuildListRecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(BuildListRecyclerViewAdapter.ViewHolder holder, int position) {
        final BitriseBuild app = bitriseBuildList.get(position);
        holder.txtCoin.setText(String.valueOf(app.getBuildNumber()));
        holder.txtMarket.setText(app.getBranch());
        if(app.getStatus() != null) {
            if (app.getStatus() == 1) {
                holder.imgStatus.setBackgroundResource(R.drawable.rectangle_green);
            } else {
                holder.imgStatus.setBackgroundResource(R.drawable.rectangle_red);
            }
        }
        holder.btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                    showBottomSheet(app);
            }
        });

        holder.btnLogs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLogBottomSheet(app);
            }
        });

    }

    public void showBottomSheet(BitriseBuild build) {
        if (activityContext instanceof AppDetailActivity) {
            ((AppDetailActivity)activityContext).expandBottomSheet(build);
        }
   }

    public void showLogBottomSheet(BitriseBuild build) {
        if (activityContext instanceof AppDetailActivity) {
            ((AppDetailActivity)activityContext).expandLogBottomSheet(build);
        }
    }

    @Override
    public int getItemCount() {
        return bitriseBuildList.size();
    }

    public void setData(List<BitriseBuild> data) {
        this.bitriseBuildList.addAll(data);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtCoin;
        public TextView txtMarket;
        public CardView cardView;
        public TextView btnView;
        public TextView btnLogs;
        public View imgStatus;

        public ViewHolder(View view) {
            super(view);

            txtCoin = view.findViewById(R.id.txtCoin);
            txtMarket = view.findViewById(R.id.txtMarket);
            cardView = view.findViewById(R.id.cardView);
            btnView = view.findViewById(R.id.btnView);
            btnLogs = view.findViewById(R.id.btnLogs);
            imgStatus = view.findViewById(R.id.build_status);

        }
    }
}
