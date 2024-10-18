package com.example.paintapp
import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Color.WHITE
import android.graphics.Paint
import android.graphics.Path
import android.util.AttributeSet
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.compose.ui.graphics.colorspace.WhitePoint
import com.example.paintapp.MainActivity.Companion.paintBrush
import com.example.paintapp.MainActivity.Companion.path


class PaintView : View{         // A view is an object that draws something like a button, image, or other UI element onto the screen.

    var params : ViewGroup.LayoutParams? = null

    companion object{
        var pathList = ArrayList<Path>()
        var colorList = ArrayList<Int>()
        var currentBrush = Color.BLACK
    }

    // Multiple constructors allow for more flexible code, allowing the app to work in more contexts

    // Primary Constructor
    // Allows for creating a view directly in the code without an XML layout
    constructor(context: Context) : this(context, null){
        init()
    }
    // Secondary Constructor
    // This constructor allows for defining custom attributes in XML for the view
    constructor(context: Context, attrs: AttributeSet?) : this(context, attrs, 0){
        init()
    }
    //Tertiary Constructor
    // This constructor allows the application of a default style to the app
    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        init()
    }

    // init function for the paintbrush, sets it's initial variables
    private fun init(){
        paintBrush.isAntiAlias = true
        paintBrush.color = currentBrush
        paintBrush.style = Paint.Style.STROKE
        paintBrush.strokeJoin = Paint.Join.ROUND
        paintBrush.strokeWidth = 8f

        params = ViewGroup.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT,ViewGroup.LayoutParams.WRAP_CONTENT)
    }

    // Function that runs when the user draws a line, creates a path that follows the line drawn and draws a line in the current color
    override fun onTouchEvent(event: MotionEvent): Boolean {
        var x = event.x
        var y = event.y

        //if(currentBrush == WHITE) {
        //    paintBrush.strokeWidth = 32f
        //} else{
        //    paintBrush.strokeWidth = 8f
        //}

        when(event.action){
            MotionEvent.ACTION_DOWN -> {
                path.moveTo(x, y)
                return true
            }
            MotionEvent.ACTION_MOVE -> {
                path.lineTo(x, y)
                pathList.add(path)
                colorList.add(currentBrush)
            }
            else -> return false
        }
        postInvalidate()
        return false;
    }

    override fun onDraw(canvas: Canvas) {
        for(i in pathList.indices){
            paintBrush.setColor(colorList[i])
            canvas.drawPath(pathList[i], paintBrush)
            invalidate()
        }
    }
}