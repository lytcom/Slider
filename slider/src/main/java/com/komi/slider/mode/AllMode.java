package com.komi.slider.mode;

import android.view.View;

import java.util.ArrayList;

/**
 * Created by Komi on 2016/2/21.
 */
public class AllMode extends SlidableMode {
    private static AllMode ourInstance = new AllMode();

    protected ArrayList<View> slidableChildrenList=new ArrayList<>();

    public static AllMode getInstance() {
        return ourInstance;
    }

    private AllMode() {

    }

    @Override
    public View getSlidableChild(View touchChild) {

        View slidableChild;
        switch (getSort())
        {
            case POSITIVE:
                slidableChild=slidableChildrenList.get(0);
                break;
            case REVERSE:
                slidableChild=slidableChildrenList.get(slidableChildrenList.size()-1);
                break;
            default:
            case TOUCH:
                slidableChild=touchChild;
                break;

        }
        return slidableChild;
    }

    @Override
    public void addSlidableChild(View child) {
        slidableChildrenList.add(child);
    }

    @Override
    public void removeSlidableChild(View child) {
        slidableChildrenList.remove(child);
    }


}