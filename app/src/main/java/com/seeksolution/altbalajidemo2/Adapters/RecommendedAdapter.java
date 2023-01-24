package com.seeksolution.altbalajidemo2.Adapters;

import android.content.Context;
import android.net.Uri;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.facebook.shimmer.ShimmerFrameLayout;
import com.seeksolution.altbalajidemo2.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.zip.Inflater;

public class RecommendedAdapter extends RecyclerView.Adapter<RecommendedAdapter.MyView3> {
    public Context context;
    public ArrayList<RecommendedModel> arrayRecommendedList;

    public RecommendedAdapter(Context context,ArrayList<RecommendedModel> arrayRecommendedList) {
        this.context=context;
        this.arrayRecommendedList=arrayRecommendedList;
    }
    @NonNull
    @Override
    public MyView3 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.mycustom_layout_trending_list,parent,false);
        return new MyView3(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView3 holder, int position) {
        final int i=position;
        holder.imageView.setVisibility(View.GONE);
        holder.simmer_imageview.setVisibility(View.VISIBLE);
        holder.shimmerFrameLayout.startShimmer();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Picasso.get().load(Uri.parse(arrayRecommendedList.get(i).getPicUrls())).into(holder.imageView);

                holder.shimmerFrameLayout.hideShimmer();
                holder.simmer_imageview.setVisibility(View.GONE);
                holder.imageView.setVisibility(View.VISIBLE);
            }
        },5000);

    }

    @Override
    public int getItemCount() {
        return arrayRecommendedList.size();
    }

    public class MyView3 extends RecyclerView.ViewHolder {
        public ImageView imageView,simmer_imageview;
        public ShimmerFrameLayout shimmerFrameLayout;
        public MyView3(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_trending_list);
            shimmerFrameLayout=itemView.findViewById(R.id.trending_list_shimmer_container);
            simmer_imageview=itemView.findViewById(R.id.iv_trending_simmer);
        }
    }
}
