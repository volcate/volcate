package com.example.a5g.indicator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.LinearLayout;

public class HomeActivity extends AppCompatActivity {
    LinearLayout page;
    Animation translateLeft;
    Animation translateRight;
    Button button;
    boolean isPageOpen = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        page = (LinearLayout) findViewById(R.id.page);

        translateLeft = AnimationUtils.loadAnimation(this, R.anim.translate_left);
        translateRight = AnimationUtils.loadAnimation(this, R.anim.translate_right);

        SlidingAnimationListener listener = new SlidingAnimationListener();
        translateLeft.setAnimationListener(listener);
        translateRight.setAnimationListener(listener);

        button = (Button) findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                if(isPageOpen) {
                    page.startAnimation(translateLeft);
                }else{
                    page.setVisibility(View.VISIBLE);
                    page.startAnimation(translateRight);
                }
            }
        });
    }

    class SlidingAnimationListener implements Animation.AnimationListener{

        @Override
        public void onAnimationStart(Animation animation) {


        }

        @Override
        public void onAnimationEnd(Animation animation) {

            if(isPageOpen){
                page.setVisibility(View.INVISIBLE);
                button.setText("열기");
                isPageOpen = false;
            }else{
                button.setText("닫기");
                isPageOpen = true;
            }

        }

        @Override
        public void onAnimationRepeat(Animation animation) {

        }
    }
}
