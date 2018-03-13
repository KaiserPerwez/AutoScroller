package com.qtechie.autoscroller;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.github.demono.AutoScrollViewPager;
import com.github.demono.adapter.InfinitePagerAdapter;
import com.github.demono.adapter.*;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        final AutoScrollViewPager mViewPager = (AutoScrollViewPager) findViewById(R.id.view_pager);
//        AutoScrollViewPager autoScrollViewPager=new AutoScrollViewPager(this);
//        CustomPagerAdapter customPagerAdapter=new CustomPagerAdapter(this);
//        mViewPager.setAdapter(customPagerAdapter);
try{
        final AutoScrollViewPager mViewPager = (AutoScrollViewPager) findViewById(R.id.viewPager);
        RelativeLayout layout=(RelativeLayout)findViewById(R.id.activity_main);
        // TEXTVIEW
        if(mViewPager.getParent()!=null)
            ((ViewGroup)mViewPager.getParent()).removeView(mViewPager); // <- fix
        (layout).addView(mViewPager); //  <==========  ERROR IN THIS LINE DURING 2ND RUN
// EDITTEXT
        MyAdapter mAdapter = new MyAdapter(MainActivity.this.getBaseContext());
        mViewPager.setAdapter(mAdapter);}
catch (Exception e){
    Toast.makeText(this, e.getMessage(), Toast.LENGTH_LONG).show();
}
        // optional start auto scroll
    //    mViewPager.startAutoScroll();
    }

}
class MyAdapter extends InfinitePagerAdapter {

    Context mContext;
    LayoutInflater mLayoutInflater;
    static int item_count;
    //    int[] mResources = {
//            R.drawable.bg_redeem,
//            R.drawable.bg_redeem1,
//            R.drawable.bg_redeem2
//    };
    private   List<Integer> mResources=new ArrayList<>();
    public MyAdapter(Context context) {
        mContext = context;
        mLayoutInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        item_count = 3;//getCount();
        for (int i=0;i<item_count;i++){
            mResources.add(R.drawable.pic);
        }
    }

    @Override
    public int getItemCount() {
        return mResources.size();
    }

    @Override
    public View getItemView(int position, View convertView, ViewGroup container) {
        View itemView = mLayoutInflater.inflate(R.layout.pager_item, container, false);
        ImageView imageView = (ImageView) itemView.findViewById(R.id.imageView);
        imageView.setImageResource(mResources.get(position));
        container.addView(itemView);

        return itemView;
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

}
//class CustomPagerAdapter extends PagerAdapter {
//
//}

