package com.example.hliao.demo_viewpager;

import android.support.v4.view.PagerAdapter;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by hliao on 6/28/2016.
 */
public class ViewPagerAdapter extends PagerAdapter {

    private List<View> mList=new ArrayList<>();

    public ViewPagerAdapter(List<View> list){
        this.mList=list;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {
        container.addView(mList.get(position),0);
        return mList.get(position);
    }

    @Override
    public int getItemPosition(Object object) {
        return super.getItemPosition(object);
    }

    @Override
    public int getCount() {
        return mList.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view==object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
       container.removeView(mList.get(position));
    }
}
