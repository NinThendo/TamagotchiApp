package com.legends.mytamagame

import android.annotation.SuppressLint

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.ProgressBar


class MainActivity2 : AppCompatActivity() {
    // declaring variables
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
        // initializing variables

        progClean = findViewById(R.id.progClean)
        progPlay = findViewById(R.id.progPlay)
        progFeed = findViewById(R.id.progFeed)
        btnClean = findViewById(R.id.btnClean)
        btnPlay = findViewById(R.id.btnPlay)
        btnFeed = findViewById(R.id.btnFeed)
        imgView = findViewById(R.id.imgView)






        btnFeed.setOnClickListener {
            progFeed.max = 130 // setting max for an easter egg for the feed function
           progFeed.incrementProgressBy(10) // increases the progress bars progress by 10 each click
            if(progFeed.progress == 100){ //  when the progress reaches 100 the image will change
                imgView.setImageResource(R.drawable.dogidle)
            } else if (progFeed.progress == 130) {
                imgView.setImageResource(R.drawable.dogdead) // when the progress reaches 130 the easter egg will occur
            } else imgView.setImageResource(R.drawable.dogeat) // when progress is greater than or less than 100 this image will show

        }

        btnClean.setOnClickListener {

            progClean.incrementProgressBy(10)
            if(progClean.progress == 100){
                imgView.setImageResource(R.drawable.dogidle)
            } else if (progClean.progress >= 75) {
                imgView.setImageResource(R.drawable.dirtydog_75)
            } else if (progClean.progress >= 50){
                imgView.setImageResource(R.drawable.dirtydog_50)
            }else imgView.setImageResource(R.drawable.dirtydog_100) // the higher the progress the more clean the dog will get
        }

        btnPlay.setOnClickListener {
            progPlay.incrementProgressBy(10)
            if(progPlay.progress == 100){
                imgView.setImageResource(R.drawable.dogidle)
            } else imgView.setImageResource(R.drawable.dogplay)
        }

    }
}