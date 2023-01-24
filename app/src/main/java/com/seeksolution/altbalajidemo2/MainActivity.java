package com.seeksolution.altbalajidemo2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.seeksolution.altbalajidemo2.Adapters.OriginalAdapter;
import com.seeksolution.altbalajidemo2.Adapters.RecommendedAdapter;
import com.seeksolution.altbalajidemo2.Adapters.RecommendedModel;
import com.seeksolution.altbalajidemo2.Adapters.TrendingAdapter;
import com.seeksolution.altbalajidemo2.models.OriginalModel;
import com.seeksolution.altbalajidemo2.models.TrendingModel;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView recyclerView,recyclerView1,recyclerView2;
    private String[] ImageUrls={
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/928/1360928-v-b808273e5b54",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/457/30457-v",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/375/1350375-v-108376acc65b",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/372/1420372-v-c4dc9b7e307f",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1158/1451158-v-60ae0c6f2c82",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1248/1431248-v-af62a54a6d8d",
    };

    private String[] ImgUrls={
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/928/1360928-v-b808273e5b54",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/457/30457-v",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/375/1350375-v-108376acc65b",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/372/1420372-v-c4dc9b7e307f",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1158/1451158-v-60ae0c6f2c82",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1248/1431248-v-af62a54a6d8d",

    };

    private String[] PicUrls={
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/928/1360928-v-b808273e5b54",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/457/30457-v",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/375/1350375-v-108376acc65b",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/372/1420372-v-c4dc9b7e307f",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1158/1451158-v-60ae0c6f2c82",
            "https://img1.hotstarext.com/image/upload/f_auto,t_web_vl_1_5x/sources/r1/cms/prod/1248/1431248-v-af62a54a6d8d",

    };
    ArrayList<RecommendedModel> recommendedArrayList;
    ArrayList<TrendingModel> modelArrayList;
    ArrayList<OriginalModel> originalArrayList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=(RecyclerView)findViewById(R.id.rc_view_trending_list);


        recyclerView1=(RecyclerView)findViewById(R.id.rc_view_original_list);


        recyclerView2=(RecyclerView)findViewById(R.id.rc_view_recommended_list);


        //Layout Manager =>Horizontal
        originalArrayList=new ArrayList<OriginalModel>();
       modelArrayList=new ArrayList<TrendingModel>();
       recommendedArrayList=new ArrayList<RecommendedModel>();
    for(int i=0;i<ImageUrls.length;i++){
       modelArrayList.add(new TrendingModel(ImageUrls[i]));
    }
    TrendingAdapter adapter=new TrendingAdapter(getApplicationContext(),modelArrayList);

    for(int i=0;i<ImgUrls.length;i++){
        originalArrayList.add(new OriginalModel(ImgUrls[i]));
    }
        OriginalAdapter adapter1=new OriginalAdapter(getApplicationContext(),originalArrayList);


    for(int i=0;i<PicUrls.length;i++){
        recommendedArrayList.add(new RecommendedModel(PicUrls[i]));
    }
        RecommendedAdapter adapter2=new RecommendedAdapter(getApplicationContext(),recommendedArrayList);
    //set Adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
        recyclerView.setAdapter(adapter);
     //set for original
            recyclerView1.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
            recyclerView1.setAdapter(adapter1);
      //set For Recommended adapter
            recyclerView2.setLayoutManager(new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false));
            recyclerView2.setAdapter(adapter2);
    }
}