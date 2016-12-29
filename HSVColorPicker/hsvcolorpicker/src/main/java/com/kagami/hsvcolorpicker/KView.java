package com.kagami.hsvcolorpicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sinceredeveloper on 16/12/28.
 */

public class KView extends View {
    protected int[] colors=new int[360];

    public KView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
