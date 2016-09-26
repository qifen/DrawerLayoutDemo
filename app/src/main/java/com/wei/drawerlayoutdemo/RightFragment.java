package com.wei.drawerlayoutdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by weiyilin on 16/9/26.
 */

public class RightFragment extends Fragment implements View.OnClickListener {

    private DrawerLayout drawerLayout;
    private FragmentManager fragmentManager;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fg_right, container, false);
        view.findViewById(R.id.button1).setOnClickListener(this);
        view.findViewById(R.id.button2).setOnClickListener(this);
        view.findViewById(R.id.button3).setOnClickListener(this);
        fragmentManager = getActivity().getSupportFragmentManager();
        return view;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button1:
                ContentFragment contentFragment1 = new ContentFragment();
                Bundle bundle1 = new Bundle();
                bundle1.putString("text", "界面1");
                contentFragment1.setArguments(bundle1);
                fragmentManager.beginTransaction().replace(R.id.fl_content, contentFragment1).commit();
                drawerLayout.closeDrawer(Gravity.END);
                break;
            case R.id.button2:
                ContentFragment contentFragment2 = new ContentFragment();
                Bundle bundle2 = new Bundle();
                bundle2.putString("text", "界面2");
                contentFragment2.setArguments(bundle2);
                fragmentManager.beginTransaction().replace(R.id.fl_content, contentFragment2).commit();
                drawerLayout.closeDrawer(Gravity.END);
                break;
            case R.id.button3:
                ContentFragment contentFragment3 = new ContentFragment();
                Bundle bundle3 = new Bundle();
                bundle3.putString("text", "界面3");
                contentFragment3.setArguments(bundle3);
                fragmentManager.beginTransaction().replace(R.id.fl_content, contentFragment3).commit();
                drawerLayout.closeDrawer(Gravity.END);
                break;
        }
    }

    public void setDrawerLayout (DrawerLayout drawerLayout) {
        this.drawerLayout = drawerLayout;
    }
}
