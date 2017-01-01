package com.wangyang.android.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.wangyang.android.R;
import com.wangyang.android.utils.DensityUtil;

import static android.R.attr.textSize;

/**
 * Created by Administrator on 2016/12/31.
 */

public class TopBar extends RelativeLayout {

    private static final String TAG = "TopBar";
    public ImageView mLeftImageButton;
    public TextView mTitleText;
    public ImageView mRightImageButton;

    public TopBar(Context context) {
        this(context, null);
    }

    public TopBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    private void init(Context context) {
        setBackgroundResource(R.color.topbar_background);

        mLeftImageButton = new ImageView(context);
        mLeftImageButton.setImageResource(R.drawable.profile_ic_home_normal);
        RelativeLayout.LayoutParams leftParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        leftParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT | RelativeLayout.CENTER_VERTICAL);
        leftParams.leftMargin = (int)getResources().getDimension(R.dimen.topbar_margin);
        addView(mLeftImageButton, leftParams);

        mTitleText = new TextView(context);
        mTitleText.setTextSize(TypedValue.COMPLEX_UNIT_PX, getResources().getDimension(R.dimen.topbar_title_text));
        mTitleText.setText("dddddd");
        RelativeLayout.LayoutParams titleParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        titleParams.addRule(RelativeLayout.CENTER_IN_PARENT);
        addView(mTitleText, titleParams);

        mRightImageButton = new ImageView(context);
        mRightImageButton.setImageResource(R.drawable.profile_ic_talk_normal);
        RelativeLayout.LayoutParams rightParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        rightParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT);
        rightParams.addRule(RelativeLayout.CENTER_VERTICAL);

        rightParams.rightMargin = (int)getResources().getDimension(R.dimen.topbar_margin);
        addView(mRightImageButton, rightParams);

    }
}

