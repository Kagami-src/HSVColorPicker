package com.kagami.hsvcolorpicker;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by sinceredeveloper on 16/12/28.
 */

public class KView extends View {
    protected int[] colors=new int[360];

    private CallBack callBack;
    public KView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        HSVColorPicker cp=new HSVColorPicker(context);
    }

    public void setCallBack(CallBack c){

    }

    public static interface CallBack{
        public void onCall(KView v);
    }
}
