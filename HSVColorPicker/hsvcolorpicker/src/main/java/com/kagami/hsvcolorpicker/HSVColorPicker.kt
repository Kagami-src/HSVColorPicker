package com.kagami.hsvcolorpicker

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View

/**
 * Created by sinceredeveloper on 16/12/28.
 */
class HSVColorPicker : View {
    val colors = IntArray(360)
    var color = Color.BLACK
    var barWidth=20f
    val barRectF=RectF()
    var sliderRadius=20f
    var sliderPaddingTop:Float=0f
    val paint=Paint(Paint.ANTI_ALIAS_FLAG)

    constructor(context: Context) : super(context) {
        init()
    }

    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        init()
    }
    constructor(context: Context, attrs: AttributeSet,defStyleAttr: Int) : super(context, attrs,defStyleAttr) {
        init()
    }


    fun init(){
        for (i in 0..299) {
            colors[i] = Color.HSVToColor(floatArrayOf(i.toFloat(), 1f, 1f))
        }
        for (i in 0..59) {
            colors[i + 300] = Color.rgb((255 * ((59 - i) / 59.0f)).toInt(), (255 * ((59 - i) / 59.0f)).toInt(), (255 * ((59 - i) / 59.0f)).toInt())
        }
    }

    val clipPath=Path()
    override fun onDraw(canvas: Canvas) {
        super.onDraw(canvas)
        barRectF.left=width-paddingRight-barWidth/2-+sliderRadius
        barRectF.right=barRectF.left+barWidth
        barRectF.top = paddingTop.toFloat()+sliderRadius
        barRectF.bottom = (height-paddingBottom).toFloat()-sliderRadius
        val unit=barRectF.height()/360
        clipPath.reset()
        clipPath.addRoundRect(barRectF,barWidth/2,barWidth/2,Path.Direction.CCW)
        canvas.save()
        canvas.clipPath(clipPath)
        for (i in colors.indices){
            paint.color=colors[i]
            canvas.drawRect(barRectF.left,barRectF.top+unit*i,barRectF.right,barRectF.top+unit*i+unit,paint)
        }
        canvas.restore()
        val index = (sliderPaddingTop/barRectF.height() * 359).toInt()
        paint.color=colors[index]
        canvas.drawCircle(barRectF.centerX(),sliderPaddingTop+barRectF.top,sliderRadius,paint)
    }

    override fun onTouchEvent(event: MotionEvent): Boolean {
        var y=event.y-barRectF.top
        if(y<0)
            y=0f
        if(y>barRectF.height())
            y=barRectF.height()
        sliderPaddingTop=y
        invalidate()

        return true
    }

    interface OnColorPickedListener {
        fun onColorPicker(color: Int)
    }
}