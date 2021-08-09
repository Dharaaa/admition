package com.systrack.admission.helpers;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.appcompat.widget.AppCompatTextView;

//@SuppressLint("AppCompatCustomView")
public class FontAwesomeTextview extends AppCompatTextView {
    public FontAwesomeTextview(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public FontAwesomeTextview(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FontAwesomeTextview(Context context) {
        super(context);
        init();
    }

    private void init() {

        //Font name should not contain "/".
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                "fonts/fontawesome-webfont.ttf");
        setTypeface(tf);
    }
}
