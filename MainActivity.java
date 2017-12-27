package com.example.a5g.indicator;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.rd.PageIndicatorView;
import com.rd.animation.type.AnimationType;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private PageIndicatorView pageIndicatorView;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initViews();

        Button btn_go = (Button) findViewById(R.id.button);
        btn_go.setOnClickListener(
                new Button.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Intent intent = new Intent(MainActivity.this, HomeActivity.class);
                        startActivity(intent);
                    }
                }
        );



    }

    private void initViews() {

        final HomeAdapter adapter = new HomeAdapter();
        adapter.setData(createPageList());
        //adapter.getItemPosition(pagenumber);

        ViewPager pager = (ViewPager) findViewById(R.id.viewPager);
        pager.setAdapter(adapter);

        pageIndicatorView = (PageIndicatorView) findViewById(R.id.pageIndicatorView);
        pageIndicatorView.setViewPager(pager);
        pageIndicatorView.setAnimationType(AnimationType.DROP);

        pager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {/*empty*/}

            @Override
            public void onPageSelected(int position) {
                pageIndicatorView.setSelection(position);
                ImageView imageView = (ImageView) findViewById(R.id.imageView1);
                if(position == 0) {
                    imageView.setImageResource(R.drawable.img2);
                }
                else if(position == 1){
                    imageView.setImageResource(R.drawable.img1);
                }
            }

            @Override
            public void onPageScrollStateChanged(int state) {/*empty*/}
        });


    }

    @NonNull
    private List<View> createPageList() {
        List<View> pageList = new ArrayList<>();
        pageList.add(createPageView(R.color.google_green));
        pageList.add(createPageView(R.color.google_red));
        pageList.add(createPageView(R.color.colorPrimary));
        pageList.add(createPageView(R.color.colorAccent));

        return pageList;
    }

    @NonNull
    private View createPageView(int color) {
        View view = new View(this);
        view.setBackgroundColor(getResources().getColor(color));


        return view;
    }
}
