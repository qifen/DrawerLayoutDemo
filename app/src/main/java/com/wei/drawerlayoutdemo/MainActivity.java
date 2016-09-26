package com.wei.drawerlayoutdemo;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private DrawerLayout drawerLayout;
    private FrameLayout frameLayout;
    private android.view.View topbar;
    private Button btn_right;
    private RightFragment rightFragment;
    private LeftFragment leftFragment;
    private FragmentManager fragmentManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragmentManager = getSupportFragmentManager();
        rightFragment = (RightFragment) fragmentManager.findFragmentById(R.id.right_fg);
        leftFragment = (LeftFragment) fragmentManager.findFragmentById(R.id.left_fg);
        initView();
    }

    private void initView() {
        drawerLayout = (DrawerLayout) findViewById(R.id.drawlayout);
        frameLayout = (FrameLayout) findViewById(R.id.fl_content);
        topbar = findViewById(R.id.topbar);
        btn_right = (Button) findViewById(R.id.top_bt);
        btn_right.setOnClickListener(this);
        //设置右面的侧滑菜单只能通过编程打开
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.END);

        drawerLayout.setDrawerListener(new DrawerLayout.DrawerListener() {
            @Override
            public void onDrawerSlide(View drawerView, float slideOffset) {

            }

            @Override
            public void onDrawerOpened(View drawerView) {

            }

            @Override
            public void onDrawerClosed(View drawerView) {
                drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_LOCKED_CLOSED, Gravity.END);
            }

            @Override
            public void onDrawerStateChanged(int newState) {

            }
        });
        leftFragment.setDrawerLayout(drawerLayout);
        rightFragment.setDrawerLayout(drawerLayout);
    }

    @Override
    public void onClick(View v) {
        drawerLayout.openDrawer(Gravity.END);
        //解除锁定
        drawerLayout.setDrawerLockMode(DrawerLayout.LOCK_MODE_UNLOCKED, Gravity.END);
    }
}
