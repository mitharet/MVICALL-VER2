package com.mitha.ver2mvicall.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.mitha.ver2mvicall.R;
import com.mitha.ver2mvicall.model.Explore;


import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ExploreAdapter extends RecyclerView.Adapter<ExploreAdapter.ViewHolder>{

    private Context context;
    private List<Explore> exploreList;
    private OnItemClickListener onItemClickListener;

    public interface OnItemClickListener {
        void onItemClick(Explore explore);
    }

    public ExploreAdapter(Context context, List<Explore> exploreList, OnItemClickListener onItemClickListener) {
        this.context = context;
        this.exploreList = exploreList;
        this.onItemClickListener = onItemClickListener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.item_explore, parent, false));
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.bindItem(exploreList.get(position), onItemClickListener);
    }

    @Override
    public int getItemCount() {
        return exploreList.size();
    }

    class ViewHolder extends RecyclerView.ViewHolder{

        @BindView(R.id.cover)
        ImageView imageBanner;

        ViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }

        void bindItem(Explore explore, OnItemClickListener listener){
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    listener.onItemClick(explore);
                }
            });
            RequestOptions requestOptions = new RequestOptions()
                    .placeholder(R.drawable.ic_launcher_background);

            Glide.with(context)
                    .load(explore.getImage_banner())
                    .apply(requestOptions)
                    .into(imageBanner);
        }
    }


}
