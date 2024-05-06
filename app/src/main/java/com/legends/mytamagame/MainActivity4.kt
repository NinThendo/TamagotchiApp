package com.legends.mytamagame

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Layout
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar


class MainActivity4 : AppCompatActivity() {
    private lateinit var btnPlay : Button
    private lateinit var btnFeed : Button
    private lateinit var btnClean : Button
    private lateinit var progClean : ProgressBar
    private lateinit var progPlay : ProgressBar
    private lateinit var progFeed : ProgressBar
    private lateinit var imgView: ImageView



    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        progClean = findViewById(R.id.progClean)
        progPlay = findViewById(R.id.progPlay)
        progFeed = findViewById(R.id.progFeed)
        btnClean = findViewById(R.id.btnClean)
        btnPlay = findViewById(R.id.btnPlay)
        btnFeed = findViewById(R.id.btnFeed)
        imgView = findViewById(R.id.imgView)






        btnFeed.setOnClickListener (View.OnClickListener {
            startActivity((Intent(this, MainActivity2::class.java)))
            progFeed.max = 130
            progFeed.incrementProgressBy(10)
            if(progFeed.progress == 100){
                imgView.setImageResource(R.drawable.dogidle)
            } else if (progFeed.progress == 130) {
                imgView.setImageResource(R.drawable.dogdead)
            } else imgView.setImageResource(R.drawable.dogeat)

        })

        btnClean.setOnClickListener (View.OnClickListener {
            startActivity((Intent(this, MainActivity3::class.java)))
            progClean.incrementProgressBy(10)
            if(progClean.progress == 100){
                imgView.setImageResource(R.drawable.dogidle)
            } else if (progClean.progress >= 75) {
                imgView.setImageResource(R.drawable.dirtydog_75)
            } else if (progClean.progress >= 50){
                imgView.setImageResource(R.drawable.dirtydog_50)
            }else imgView.setImageResource(R.drawable.dirtydog_100)
        })

        btnPlay.setOnClickListener (View.OnClickListener {
            progPlay.incrementProgressBy(10)
            if(progPlay.progress == 100){
                imgView.setImageResource(R.drawable.dogidle)
            } else imgView.setImageResource(R.drawable.dogplay)
        })

    }
}