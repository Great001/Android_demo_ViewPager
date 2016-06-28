package com.example.hliao.demo_viewpager;

import android.content.DialogInterface;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ViewPager mVp_test;
    private TextView mTvOne,mTvTwo,mTvThree;
    private LinearLayout mLlDotView;
    private List<View> mList;
    private ImageView [] mDot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        mVp_test=(ViewPager)findViewById(R.id.vp_test);
        mTvOne=(TextView)findViewById(R.id.tv_one);
        mTvTwo=(TextView)findViewById(R.id.tv_two);
        mTvThree=(TextView)findViewById(R.id.tv_three);
        mLlDotView=(LinearLayout)findViewById(R.id.ll_dot);



        mList=new ArrayList<>();
        View viewOne=getLayoutInflater().inflate(R.layout.one,null);
        View viewTwo=getLayoutInflater().inflate(R.layout.two,null);
        View viewThree=getLayoutInflater().inflate(R.layout.three,null);

        mList.add(viewOne);
        mList.add(viewTwo);
        mList.add(viewThree);
        ViewPagerAdapter adapter=new ViewPagerAdapter(mList);
        mVp_test.setAdapter(adapter);
        mVp_test.setCurrentItem(0, false);
        mTvOne.setTextColor(getResources().getColor(R.color.red));


        final int count=mList.size();
        mDot=new ImageView[count];
        for(int i=0;i<count;i++){
            mDot[i]=(ImageView)mLlDotView.getChildAt(i);
        }
        mDot[0].setImageResource(R.drawable.dotshape_white);

        mTvOne.setOnClickListener(this);
        mTvTwo.setOnClickListener(this);
        mTvThree.setOnClickListener(this);

        mVp_test.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
            }

            @Override
            public void onPageSelected(int position) {
                mTvOne.setTextColor(getResources().getColor(R.color.white));
                mTvThree.setTextColor(getResources().getColor(R.color.white));
                mTvTwo.setTextColor(getResources().getColor(R.color.white));
                for(int i=0;i<count;i++){
                    mDot[i].setImageResource(R.drawable.dotshape_black);
                }
                switch (position) {
                    case 0:
                        mTvOne.setTextColor(getResources().getColor(R.color.red));
                        mDot[0].setImageResource(R.drawable.dotshape_white);
                        break;
                    case 1:
                        mTvTwo.setTextColor(getResources().getColor(R.color.red));
                        mDot[1].setImageResource(R.drawable.dotshape_white);
                        break;
                    case 2:
                        mTvThree.setTextColor(getResources().getColor(R.color.red));
                        mDot[2].setImageResource(R.drawable.dotshape_white);
                        break;
                    default:
                        break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }



    @Override
    public void onClick(View v) {
        mTvOne.setTextColor(getResources().getColor(R.color.white));
        mTvThree.setTextColor(getResources().getColor(R.color.white));
        mTvTwo.setTextColor(getResources().getColor(R.color.white));

        int count=mList.size();
        for(int i=0;i<count;i++){
            mDot[i].setImageResource(R.drawable.dotshape_black);
        }
        switch (v.getId()){
            case R.id.tv_one:
                mTvOne.setTextColor(getResources().getColor(R.color.red));
                mVp_test.setCurrentItem(0, true);
                mDot[0].setImageResource(R.drawable.dotshape_white);
                break;
            case R.id.tv_two:
                mTvTwo.setTextColor(getResources().getColor(R.color.red));
                mVp_test.setCurrentItem(1, true);
                mDot[1].setImageResource(R.drawable.dotshape_white);
                break;
            case R.id.tv_three:
                mTvThree.setTextColor(getResources().getColor(R.color.red));
                mVp_test.setCurrentItem(2, true);
                mDot[2].setImageResource(R.drawable.dotshape_white);
                break;
                default:break;
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
