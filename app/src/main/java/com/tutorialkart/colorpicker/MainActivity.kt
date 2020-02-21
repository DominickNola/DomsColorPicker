package com.tutorialkart.colorpicker

import android.app.Activity
import android.graphics.Color
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.colorpicker.*
//import sun.jvm.hotspot.utilities.IntArray


class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val settings = getSharedPreferences("settings", 0)
        val editor = settings.edit()
        val settings2 = getSharedPreferences("settings2", 0)
        val editor2 = settings2.edit()
        val settings3 = getSharedPreferences("settings3", 0)
        val editor3 = settings3.edit()
        val settings4 = getSharedPreferences("settings4", 0)
        val editor4 = settings4.edit()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnColorPicker.setOnClickListener {
            colorSelector.visibility = View.VISIBLE
        }

        btnColorSelected.setOnClickListener {
            colorSelector.visibility = View.VISIBLE
        }

        strColor.addTextChangedListener(object : TextWatcher {

            override fun afterTextChanged(s: Editable) {
                if (s.length == 6){
                    colorA.progress = 255
                    colorR.progress = Integer.parseInt(s.substring(0..1), 16)
                    colorG.progress = Integer.parseInt(s.substring(2..3), 16)
                    colorB.progress = Integer.parseInt(s.substring(4..5), 16)
                } else if (s.length == 8){
                    colorA.progress = Integer.parseInt(s.substring(0..1), 16)
                    colorR.progress = Integer.parseInt(s.substring(2..3), 16)
                    colorG.progress = Integer.parseInt(s.substring(4..5), 16)
                    colorB.progress = Integer.parseInt(s.substring(6..7), 16)
                }
            }

            override fun beforeTextChanged(s: CharSequence, start: Int,
                                           count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence, start: Int,
                                       before: Int, count: Int) {

            }
        })

        colorA.max = 255
        colorA.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                val colorStr = getColorString()
                strColor.setText(colorStr.replace("#","").toUpperCase())
                btnColorPreview.setBackgroundColor(Color.parseColor(colorStr))

                textView11.text = progress.toString()


            }
        })

        colorR.max = 255
        colorR.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                val colorStr = getColorString()
                strColor.setText(colorStr.replace("#","").toUpperCase())
                btnColorPreview.setBackgroundColor(Color.parseColor(colorStr))

                textView8.text = progress.toString()

            }
        })

        colorG.max = 255
        colorG.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                val colorStr = getColorString()
                strColor.setText(colorStr.replace("#","").toUpperCase())
                btnColorPreview.setBackgroundColor(Color.parseColor(colorStr))

                textView9.text = progress.toString()

            }
        })

        colorB.max = 255
        colorB.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onStopTrackingTouch(seekBar: SeekBar) {}
            override fun onStartTrackingTouch(seekBar: SeekBar) {}
            override fun onProgressChanged(seekBar: SeekBar, progress: Int,
                                           fromUser: Boolean) {
                val colorStr = getColorString()
                strColor.setText(colorStr.replace("#","").toUpperCase())
                btnColorPreview.setBackgroundColor(Color.parseColor(colorStr))

                textView10.text = progress.toString()

            }
        })

//        colorCancelBtn.setOnClickListener {
//            colorSelector.visibility = View.GONE
//        }

        colorOkBtn.setOnClickListener {
            val color:String = getColorString()
            btnColorSelected.setBackgroundColor(Color.parseColor(color))
            colorSelector.visibility = View.GONE
        }

        // first save button
        button11.setOnClickListener {

            editor.putInt("Red", colorR.progress)
            editor.putInt("Green", colorG.progress)
            editor.putInt("Blue", colorR.progress)
            editor.putInt("Opacity", colorG.progress)
            editor.apply()
        }

        // first preset button
        button10.setOnClickListener {

            colorR.progress = settings.getInt("Red", 0)
            colorG.progress = settings.getInt("Green", 0)
            colorB.progress = settings.getInt("Blue", 0)
            colorA.progress = settings.getInt("Opacity", 0)
        }

        // second save button
        button12.setOnClickListener {

            editor2.putInt("Red", colorR.progress)
            editor2.putInt("Green", colorG.progress)
            editor2.putInt("Blue", colorR.progress)
            editor2.putInt("Opacity", colorG.progress)
            editor2.apply()
        }

        // second preset button
        button9.setOnClickListener {

            colorR.progress = settings2.getInt("Red", 0)
            colorG.progress = settings2.getInt("Green", 0)
            colorB.progress = settings2.getInt("Blue", 0)
            colorA.progress = settings2.getInt("Opacity", 0)
        }

        // third save button
        button13.setOnClickListener {

            editor3.putInt("Red", colorR.progress)
            editor3.putInt("Green", colorG.progress)
            editor3.putInt("Blue", colorR.progress)
            editor3.putInt("Opacity", colorG.progress)
            editor3.apply()
        }

        // third preset button
        button8.setOnClickListener {

            colorR.progress = settings3.getInt("Red", 0)
            colorG.progress = settings3.getInt("Green", 0)
            colorB.progress = settings3.getInt("Blue", 0)
            colorA.progress = settings3.getInt("Opacity", 0)
        }

        // forth save button
        button14.setOnClickListener {

            editor4.putInt("Red", colorR.progress)
            editor4.putInt("Green", colorG.progress)
            editor4.putInt("Blue", colorR.progress)
            editor4.putInt("Opacity", colorG.progress)
            editor4.apply()
        }

        // forth preset button
        button7.setOnClickListener {

            colorR.progress = settings4.getInt("Red", 0)
            colorG.progress = settings4.getInt("Green", 0)
            colorB.progress = settings4.getInt("Blue", 0)
            colorA.progress = settings4.getInt("Opacity", 0)
        }
    }
    fun getColorString(): String {
        var a = Integer.toHexString(((255*colorA.progress)/colorA.max))
        if(a.length==1) a = "0"+a
        var r = Integer.toHexString(((255*colorR.progress)/colorR.max))
        if(r.length==1) r = "0"+r
        var g = Integer.toHexString(((255*colorG.progress)/colorG.max))
        if(g.length==1) g = "0"+g
        var b = Integer.toHexString(((255*colorB.progress)/colorB.max))
        if(b.length==1) b = "0"+b
        return "#" + a + r + g + b
    }
}
