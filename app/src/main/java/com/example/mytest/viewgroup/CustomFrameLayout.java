package com.example.mytest.viewgroup;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

import com.example.mytest.R;

/**
 * Created by Administrator on 2017/9/8 0008.
 */

public class CustomFrameLayout extends ViewGroup {

    //自定义布局中设置的宽度和高度
    private int mHoriztonalSpacing;
    private int mVerticalSpacing;

    public CustomFrameLayout(Context context) {
        this(context, null);
    }

    public CustomFrameLayout(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomFrameLayout(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray a = context.obtainStyledAttributes(attrs, R.styleable.CustomFrameLayout);
        try {
            //获取设置的宽度
            mHoriztonalSpacing = a.getDimensionPixelSize(R.styleable.CustomFrameLayout_horizontalspacing,
                    this.getResources().getDimensionPixelSize(R.dimen.default_horizontal_spacing));
            //获取设置的高度
            mVerticalSpacing = a.getDimensionPixelSize(R.styleable.CustomFrameLayout_verticalspacing,
                    this.getResources().getDimensionPixelSize(R.dimen.default_vertical_spacing));

        } catch (Exception e) {
            e.printStackTrace();

        } finally {
            a.recycle();
        }
    }

    /**
     * 测量自己的大小，同时也测量子View大小，并将子View的大小保存在LayoutParams中
     * @param widthMeasureSpec
     * @param heightMeasureSpec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        final int count = this.getChildCount();
        int width = this.getPaddingLeft();
        int height = this.getPaddingTop();
        for (int i = 0; i < count; i++) {
            final View currentView = this.getChildAt(i);
            this.measureChild(currentView, widthMeasureSpec, heightMeasureSpec);
            CustomFrameLayout.LayoutParams params = (CustomFrameLayout.LayoutParams) currentView.getLayoutParams();
            if(params.mSettingPaddingLeft != 0){
                width +=params.mSettingPaddingLeft;
            }
            if(params.mSettingPaddingTop != 0){
                height +=params.mSettingPaddingTop;
            }
            params.x = width;
            params.y = height;
            width += mHoriztonalSpacing;
            height += mVerticalSpacing;
        }
        width +=getChildAt(this.getChildCount() - 1).getMeasuredWidth() + this.getPaddingRight();
        height += getChildAt(this.getChildCount() - 1).getMeasuredHeight() + this.getPaddingBottom();
        this.setMeasuredDimension(resolveSize(width, widthMeasureSpec), resolveSize(height, heightMeasureSpec));

    }

    @Override
    protected void onLayout(boolean b, int l, int i1, int i2, int i3) {
        final int count = this.getChildCount();
        for (int i = 0; i < count; i++) {
            final View currentView = this.getChildAt(i);
            CustomFrameLayout.LayoutParams lp = (CustomFrameLayout.LayoutParams) currentView.getLayoutParams();
            currentView.layout(lp.x, lp.y, lp.x + currentView.getMeasuredWidth(),
                    lp.y + currentView.getMeasuredHeight());
        }


    }

    /**
     * 构造自定义的内部类LayoutParams，
     * 可以方便我们在测量我们的子View的时候保存它们的属性值，以便在Layout阶段布局
     */
    public static class LayoutParams extends ViewGroup.LayoutParams {
        int x;
        int y;
        int mSettingPaddingLeft;
        int mSettingPaddingTop;

        public LayoutParams(Context c, AttributeSet attrs) {
            super(c, attrs);
            TypedArray a = c.obtainStyledAttributes(attrs, R.styleable.CustomFrameLayout_LayoutParams);
            mSettingPaddingLeft = a.getDimensionPixelSize(R.styleable.CustomFrameLayout_LayoutParams_layout_paddingleft, 0);
            mSettingPaddingTop = a.getDimensionPixelSize(R.styleable.CustomFrameLayout_LayoutParams_layout_paddinTop, 0);
            a.recycle();
        }

        public LayoutParams(int width, int height) {
            super(width, height);
        }

        public LayoutParams(ViewGroup.LayoutParams source) {
            super(source);
        }
    }

    /**
     * 返回我们自定义的LayoutParams
     * @return
     */
    @Override
    protected ViewGroup.LayoutParams generateDefaultLayoutParams() {
        return new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
    }

    @Override
    protected ViewGroup.LayoutParams generateLayoutParams(ViewGroup.LayoutParams p) {
        return new LayoutParams(p);
    }

    @Override
    public ViewGroup.LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new LayoutParams(this.getContext(), attrs);
    }
}
