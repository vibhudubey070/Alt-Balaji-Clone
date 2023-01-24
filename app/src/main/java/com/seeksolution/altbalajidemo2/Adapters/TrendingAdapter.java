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
import com.seeksolution.altbalajidemo2.models.TrendingModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class TrendingAdapter extends RecyclerView.Adapter<TrendingAdapter.MyView> {
    public Context context;
    public ArrayList<TrendingModel> arrayList;


    public TrendingAdapter(Context context, ArrayList<TrendingModel> arrayList) {
        this.context = context;
        this.arrayList = arrayList;
    }

    @NonNull
    @Override
    public MyView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.mycustom_layout_trending_list,parent,false);
        return new MyView(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView holder, int position) {
        final int i=position;

        holder.imageView.setVisibility(View.GONE);
        holder.simmer_imageview.setVisibility(View.VISIBLE);
        holder.shimmerFrameLayout.startShimmer();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Picasso.get()
                        .load(Uri.parse(arrayList.get(i).getImageUrls()))
                        .into(holder.imageView);

                holder.shimmerFrameLayout.hideShimmer(); // simmer-hide
                holder.simmer_imageview.setVisibility(View.GONE); //grey-done
                holder.imageView.setVisibility(View.VISIBLE); //original => visible
            }
        },5000);


    }

    @Override
    public int getItemCount() {
        return arrayList.size();
    }

    public class MyView extends RecyclerView.ViewHolder{
        public ImageView imageView;
        public ShimmerFrameLayout shimmerFrameLayout;
        public ImageView simmer_imageview;
        public MyView(@NonNull View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.iv_trending_list);
            shimmerFrameLayout=itemView.findViewById(R.id.trending_list_shimmer_container);
            simmer_imageview=itemView.findViewById(R.id.iv_trending_simmer);
        }
    }
}
