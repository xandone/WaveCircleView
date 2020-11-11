package com.app.xandone.wavecircleview

import android.app.Activity
import android.content.Context
import android.util.Log
import android.view.ViewGroup
import androidx.annotation.ColorRes

/**
 * author: Admin
 * created on: 2020/11/11 10:59
 * description:
 */
object ThemeHelper {

//    --------------------------------------WaveCircleView-----------------------------------

    private fun createView(context: Context): WaveCircleView {
        return WaveCircleView(context)
    }

    public fun start(context: Context) {
        val waveView = createView(context)

        if (context is Activity) {
            val rootView: ViewGroup = context.window.decorView as ViewGroup
            rootView.addView(waveView, 0)
        }

    }

//    --------------------------------------WaveCircleView2-----------------------------------

    private var mRootView: ViewGroup? = null
    private var waveCircleView2: WaveCircleView2? = null

    //是否正在添加
    private var isWaving: Boolean = false

    private fun createView2(context: Context): WaveCircleView2 {
        waveCircleView2 = WaveCircleView2(context)
        return waveCircleView2 as WaveCircleView2
    }

    public fun start2(
        context: Context,
        viewGroup: ViewGroup,
        @ColorRes color: Int,
        listener: WaveCircleView2.IWaveEndListener
    ) {
        if (isWaving) {
            return
        }
        this.isWaving = true
        val waveView = createView2(context)

        if (context is Activity) {
            mRootView = viewGroup
            mRootView?.addView(waveView, 0)
            waveView.dealParams(0F, 0F, color, listener)
        }
    }

    fun stop2() {
        if (waveCircleView2 != null) {
            mRootView?.post(Runnable {
                mRootView?.removeView(waveCircleView2)
                waveCircleView2 = null
                this.isWaving = false
            })

        }
    }


    //    --------------------------------------WaveCircleView3-----------------------------------

    private var mRootView3: ViewGroup? = null
    private var waveCircleView3: WaveCircleView3? = null

    //是否正在添加
    private var isWaving3: Boolean = false

    private fun createView3(context: Context): WaveCircleView3 {
        waveCircleView3 = WaveCircleView3(context)
        return waveCircleView3 as WaveCircleView3
    }

    public fun start3(
        context: Context,
        viewGroup: ViewGroup,
        @ColorRes color: Int,
        listener: WaveCircleView3.IWaveEndListener
    ) {
        if (isWaving3) {
            return
        }
        this.isWaving3 = true
        val waveView = createView3(context)

        if (context is Activity) {
            mRootView3 = viewGroup
            mRootView3?.addView(waveView, 0)
            waveView.dealParams(0F, 0F, color, listener)
        }
    }

    fun stop3() {
        if (waveCircleView3 != null) {
            mRootView3?.post(Runnable {
                mRootView3?.removeView(waveCircleView3)
                waveCircleView3 = null
                this.isWaving3 = false
            })

        }
    }
}