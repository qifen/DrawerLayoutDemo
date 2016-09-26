package com.wei.drawerlayoutdemo;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

/**
 * Created by weiyilin on 16/9/26.
 */

public class ContentFragment extends Fragment {

    private TextView tv;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.content, container, false);
        tv = (TextView) view.findViewById(R.id.tv);
        tv.setText(getArguments().getString("text"));
        return view;
    }

}
