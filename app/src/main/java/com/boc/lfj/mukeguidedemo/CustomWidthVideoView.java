package com.boc.lfj.mukeguidedemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.VideoView;

/**
 * 类名： CustomWidthVideoView
 * 功能说明：
 * 作者： lfj
 * 创建时间： 2016/12/23
 * 修改内容：
 * 修改人： lfj
 * 修改时间：2016/12/23
 */
public class CustomWidthVideoView extends VideoView {
    private int mWidth = 0;
    private int mHeight = 0;
    public CustomWidthVideoView(Context context) {
        super(context);
    }

    public CustomWidthVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomWidthVideoView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    
    public void setWidthHeight(int width,int height){
        this.mWidth = width;
        this.mHeight = height;
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        if (mWidth>0&&mHeight>0){
            setMeasuredDimension(mWidth,mHeight);
        }else {
            super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        }
    }
}
