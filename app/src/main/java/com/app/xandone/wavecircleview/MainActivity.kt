package com.app.xandone.wavecircleview

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.ColorRes
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        start2()
        start3()
    }

    @SuppressLint("ResourceType")
    fun start2() {
        @ColorRes val purpleColor = ContextCompat.getColor(this, R.color.purple_200)
        @ColorRes val tealColor = ContextCompat.getColor(this, R.color.teal_200)
        purple_tv.setOnClickListener {
            ThemeHelper.start2(
                this@MainActivity,
                root_cl,
                purpleColor,
                object : WaveCircleView2.IWaveEndListener {
                    override fun endCallBack() {
                        root_cl.setBackgroundColor(purpleColor)
                        ThemeHelper.stop2()

                    }
                }
            )
        }

        teal_tv.setOnClickListener {
            ThemeHelper.start2(
                this@MainActivity,
                root_cl,
                tealColor,
                object : WaveCircleView2.IWaveEndListener {
                    override fun endCallBack() {
                        root_cl.setBackgroundColor(tealColor)
                        ThemeHelper.stop2()
                    }
                }
            )
        }
    }

    @SuppressLint("ResourceType")
    fun start3() {
        @ColorRes val purpleColor = ContextCompat.getColor(this, R.color.purple_200)
        @ColorRes val tealColor = ContextCompat.getColor(this, R.color.teal_200)
        purple_tv.setOnClickListener {
            ThemeHelper.start3(
                this@MainActivity,
                root_cl,
                purpleColor,
                object : WaveCircleView3.IWaveEndListener {
                    override fun endCallBack() {
                        root_cl.setBackgroundColor(purpleColor)
                        ThemeHelper.stop3()

                    }
                }
            )
        }

        teal_tv.setOnClickListener {
            ThemeHelper.start3(
                this@MainActivity,
                root_cl,
                tealColor,
                object : WaveCircleView3.IWaveEndListener {
                    override fun endCallBack() {
                        root_cl.setBackgroundColor(tealColor)
                        ThemeHelper.stop3()
                    }
                }
            )
        }
    }
}