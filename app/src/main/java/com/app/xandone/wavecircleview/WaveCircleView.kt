package com.app.xandone.wavecircleview

import android.content.Context
import android.graphics.Canvas
import android.graphics.Paint
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import androidx.core.content.ContextCompat
import kotlin.math.pow
import kotlin.math.sqrt

/**
 * author: Admin
 * created on: 2020/11/11 09:53
 * description:
 */
class WaveCircleView(context: Context?) : View(context) {

    private val mContext: Context? = context
    private lateinit var mPaint: Paint
    private var mRaduis: Float = 0F
    private var mMaxRaduis: Float = 0F
    private var mCircleX: Float = 0F
    private var mCircleY: Float = 0F
    private var isStartDraw: Boolean = false

    init {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.color = ContextCompat.getColor(mContext!!, R.color.purple_500)
    }

    constructor(context: Context, attrs: AttributeSet) : this(context) {
        initView()
    }

    private fun initView() {
        mPaint = Paint(Paint.ANTI_ALIAS_FLAG)
        mPaint.color = ContextCompat.getColor(mContext!!, R.color.purple_500)
    }

    override fun onDraw(canvas: Canvas?) {
        if (isStartDraw) {
            drawCicle(canvas, mCircleX, mCircleY)
        }
    }


    override fun onTouchEvent(event: MotionEvent?): Boolean {
        when (event?.action) {
            MotionEvent.ACTION_DOWN -> {
                val circleX = event.x
                val circleY = event.y
                dealParams(circleX, circleY)
            }
        }
        return true
    }

    private fun dealParams(circleX: Float, circleY: Float) {
        this.mCircleX = circleX
        this.mCircleY = circleY
        this.isStartDraw = true
        this.mRaduis = 0F;

        invalidate()
    }

    private fun drawCicle(canvas: Canvas?, circleX: Float, circleY: Float) {
        if (mRaduis > mMaxRaduis) {
            fiexdBgColor(canvas)
            this.isStartDraw = false
            return
        }
        canvas?.drawCircle(circleX, circleY, mRaduis, mPaint)
        postDelayed(Runnable { mRaduis += 30; invalidate() }, 5)
    }

    private fun fiexdBgColor(cavans: Canvas?) {
        cavans?.drawCircle(0F, 0F, mMaxRaduis, mPaint)
    }

    override fun onSizeChanged(w: Int, h: Int, oldw: Int, oldh: Int) {
        super.onSizeChanged(w, h, oldw, oldh)
        this.mMaxRaduis = sqrt(w.toDouble().pow(2.0) + h.toDouble().pow(2.0)).toFloat()
    }

}