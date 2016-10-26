package com.example.dllo.bibilala.bangumi.grid;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

public class GridViews extends GridView {
    public GridViews(Context context) {
        super(context);
    }

    public GridViews(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GridViews(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    /**
     * 重写该方法，达到使ListView适应ScrollView的效果
     */
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                MeasureSpec.AT_MOST);
        super.onMeasure(widthMeasureSpec, expandSpec);
    }
}