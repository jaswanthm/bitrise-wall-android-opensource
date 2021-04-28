package xyz.jaswanth.bitwall;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import xyz.jaswanth.bitwall.pojo.Datum;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private List<Datum> bitriseAppList;
    Context context;

    public RecyclerViewAdapter(Context context) {
        bitriseAppList = new ArrayList<>();
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(ViewGroup parent,
                                                             int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recyclerview_item_layout, parent, false);

        RecyclerViewAdapter.ViewHolder viewHolder = new RecyclerViewAdapter.ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewAdapter.ViewHolder holder, int position) {
        Datum app = bitriseAppList.get(position);
        holder.txtCoin.setText(app.getTitle());
        Picasso.with(context).load(app.getAvatarUrl()).into(holder.imgApp);

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(holder.itemView.getContext(), AppDetailActivity.class);
                intent.putExtra("app", app);
                holder.itemView.getContext().startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return bitriseAppList.size();
    }

    public void setData(List<Datum> data) {
        this.bitriseAppList.addAll(data);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtCoin;
        public CardView cardView;
        public ImageView imgApp;

        public ViewHolder(View view) {
            super(view);

            txtCoin = view.findViewById(R.id.txtCoin);
            cardView = view.findViewById(R.id.cardView);
            imgApp = view.findViewById(R.id.imgApp);

        }
    }
}
