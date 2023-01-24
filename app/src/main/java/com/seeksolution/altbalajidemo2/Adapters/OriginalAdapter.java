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
import com.seeksolution.altbalajidemo2.models.OriginalModel;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class OriginalAdapter extends RecyclerView.Adapter<OriginalAdapter.MyView2> {

    public Context context;
    public ArrayList<OriginalModel> arrayList1;

    public OriginalAdapter(Context context,ArrayList<OriginalModel> arrayList1){
        this.context=context;
        this.arrayList1=arrayList1;
    }
    @NonNull
    @Override
    public MyView2 onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.mycustom_layout_trending_list,parent,false);
        return new MyView2(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyView2 holder, int position) {
        final int i=position;

        holder.imgView.setVisibility(View.GONE);
        holder.simmer_imageview.setVisibility(View.VISIBLE);
        holder.shimmerFrameLayout.startShimmer();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Picasso.get().load(Uri.parse(arrayList1.get(i).getImageUrl())).into(holder.imgView);
                holder.shimmerFrameLayout.hideShimmer(); // simmer-hide
                holder.simmer_imageview.setVisibility(View.GONE); //grey-done
                holder.imgView.setVisibility(View.VISIBLE); //original => visible
            }
        },5000);

    }

    @Override
    public int getItemCount() {
        return arrayList1.size();
    }

    public class MyView2 extends RecyclerView.ViewHolder {
        public ImageView imgView;
        public ShimmerFrameLayout shimmerFrameLayout;
        public ImageView simmer_imageview;
        public MyView2(@NonNull View itemView) {
            super(itemView);
            imgView=itemView.findViewById(R.id.iv_trending_list);
            shimmerFrameLayout=itemView.findViewById(R.id.trending_list_shimmer_container);
            simmer_imageview=itemView.findViewById(R.id.iv_trending_simmer);

        }
    }
}
