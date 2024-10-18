package com.example.paintapp

import android.graphics.Color
import android.graphics.Paint
import android.graphics.Path
import android.os.Build
import android.os.Bundle
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.annotation.ColorLong
import androidx.annotation.RequiresApi
import com.example.paintapp.MainActivity.Companion.path
import com.example.paintapp.PaintView.Companion.colorList
import com.example.paintapp.PaintView.Companion.currentBrush
import com.example.paintapp.PaintView.Companion.pathList

class MainActivity : ComponentActivity() {

    // Object with variables that can be passed between Kotlin files
    companion object {
        var path = Path()
        var paintBrush = Paint()
    }

    // Code that runs when the app opens up for the first time.
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Connects to the buttons created in the activity_main.xml file by their ids
        val redBtn = findViewById<ImageButton>(R.id.redColor)
        val orangeBtn = findViewById<ImageButton>(R.id.orangeColor)
        val yellowBtn = findViewById<ImageButton>(R.id.yellowColor)
        val limeGreenBtn = findViewById<ImageButton>(R.id.limeGreenColor)
        val greenBtn = findViewById<ImageButton>(R.id.greenColor)
        val cyanBtn = findViewById<ImageButton>(R.id.cyanColor)
        val blueBtn = findViewById<ImageButton>(R.id.blueColor)
        val purpleBtn = findViewById<ImageButton>(R.id.purpleColor)
        val blackBtn = findViewById<ImageButton>(R.id.blackColor)
        val whiteBtn = findViewById<ImageButton>(R.id.whiteColor)

        // Color buttons, change the color and show a short message indicated what color has been selected
        redBtn.setOnClickListener {
            Toast.makeText(this, "Red", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.RED
            currentColor(paintBrush.color)
        }

        orangeBtn.setOnClickListener {
            Toast.makeText(this, "Orange", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.parseColor("#ffa500")
            currentColor(paintBrush.color)
        }

        yellowBtn.setOnClickListener {
            Toast.makeText(this, "Yellow", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.parseColor("#fff000")
            currentColor(paintBrush.color)
        }

        limeGreenBtn.setOnClickListener {
            Toast.makeText(this, "Lime Green", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.parseColor("#00ff00")
            currentColor(paintBrush.color)
        }

        greenBtn.setOnClickListener {
            Toast.makeText(this, "Green", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.parseColor("#008000")
            currentColor(paintBrush.color)
        }

        cyanBtn.setOnClickListener {
            Toast.makeText(this, "Cyan", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.parseColor("#00ffff")
            currentColor(paintBrush.color)
        }

        blueBtn.setOnClickListener {
            Toast.makeText(this, "Blue", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.BLUE
            currentColor(paintBrush.color)
        }

        purpleBtn.setOnClickListener {
            Toast.makeText(this, "Purple", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.parseColor("#6200ee")
            currentColor(paintBrush.color)
        }

        blackBtn.setOnClickListener {
            Toast.makeText(this, "Black", Toast.LENGTH_SHORT).show()
            paintBrush.color = Color.BLACK
            currentColor(paintBrush.color)
        }

//        whiteBtn.setOnClickListener{
//            Toast.makeText(this,"White",Toast.LENGTH_SHORT).show()
//            paintBrush.color = Color.WHITE
//            currentColor(paintBrush.color)
//
//        }

        whiteBtn.setOnClickListener {
            Toast.makeText(this, "Canvas Cleared", Toast.LENGTH_SHORT).show()
            pathList.clear()
            colorList.clear()
            path.reset()
        }
    }

    private fun currentColor(color: Int) {
        currentBrush = color
        path = Path()
    }
}


