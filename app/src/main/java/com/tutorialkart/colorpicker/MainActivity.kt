package com.tutorialkart.colorpicker

import android.graphics.Color
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.SeekBar
import kotlinx.android.synthetic.main.colorpicker.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val settings = getSharedPreferences("settings", 0)
        val editor = settings.edit()
        val settings2 = getSharedPreferences("settings2", 0)
        val editor2 = settings2.edit()
        val settings3 = getSharedPreferences("settings3", 0)
        val editor3 = settings3.edit()
        val settings4 = getSharedPreferences("settings4", 0)
        val editor4 = settings4.edit()

        val buttons = getSharedPreferences("buttons", 0)
        val editor5 = buttons.edit()
        val buttons2 = getSharedPreferences("buttons2", 0)
        val editor6 = buttons2.edit()
        val buttons3 = getSharedPreferences("buttons3", 0)
        val editor7 = buttons3.edit()
        val buttons4 = getSharedPreferences("buttons4", 0)
        val editor8 = buttons4.edit()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //setting toolbar
        supportActionBar?.setDisplayShowHomeEnabled(true)
        supportActionBar?.setLogo(R.drawable.ic_action_name)
        supportActionBar?.setDisplayUseLogoEnabled(true)

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

//        colorOkBtn.setOnClickListener {
//            val color:String = getColorString()
//            btnColorSelected.setBackgroundColor(Color.parseColor(color))
//            colorSelector.visibility = View.GONE
//        }

        // first preset button
        button10.setOnClickListener {

            colorR.progress = settings.getInt("Red", 0)
            colorG.progress = settings.getInt("Green", 0)
            colorB.progress = settings.getInt("Blue", 0)
            colorA.progress = settings.getInt("Opacity", 0)

            button10.text = buttons.getString("buttons", "default")
            color_name_edit.text = buttons.getString("buttons", "default")

        }

        // first save button
        button11.setOnClickListener {

            editText2.visibility = View.VISIBLE
            button7.visibility = View.GONE
            button8.visibility = View.GONE
            button9.visibility = View.GONE
            button10.visibility = View.GONE
            button11.visibility = View.GONE
            button12.visibility = View.GONE
            button13.visibility = View.GONE
            button14.visibility = View.GONE
            colorR.visibility = View.GONE
            colorG.visibility = View.GONE
            colorB.visibility = View.GONE
            colorA.visibility = View.GONE
            textView2.visibility = View.GONE
            textView3.visibility = View.GONE
            textView4.visibility = View.GONE
            textView5.visibility = View.GONE
            textView8.visibility = View.GONE
            textView9.visibility = View.GONE
            textView10.visibility = View.GONE
            textView11.visibility = View.GONE
            color_name_edit.visibility = View.GONE
            done1.visibility = View.VISIBLE
            done2.visibility = View.GONE
            done3.visibility = View.GONE
            done4.visibility = View.GONE
            back1.visibility = View.VISIBLE
            back2.visibility = View.GONE
            back3.visibility = View.GONE
            back4.visibility = View.GONE

        }

        // first done button
        done1.setOnClickListener {
            // add color from the seekBars to the first settings/editor
            editor.putInt("Red", colorR.progress)
            editor.putInt("Green", colorG.progress)
            editor.putInt("Blue", colorB.progress)
            editor.putInt("Opacity", colorA.progress)
            editor.apply()

            button10.text = editText2.text
            color_name_edit.text = editText2.text
            editor5.putString("buttons", button10.text.toString())
            editor5.apply()

            editText2.visibility = View.GONE
            button7.visibility = View.VISIBLE
            button8.visibility = View.VISIBLE
            button9.visibility = View.VISIBLE
            button10.visibility = View.VISIBLE
            button11.visibility = View.VISIBLE
            button12.visibility = View.VISIBLE
            button13.visibility = View.VISIBLE
            button14.visibility = View.VISIBLE
            colorR.visibility = View.VISIBLE
            colorG.visibility = View.VISIBLE
            colorB.visibility = View.VISIBLE
            colorA.visibility = View.VISIBLE
            textView2.visibility = View.VISIBLE
            textView3.visibility = View.VISIBLE
            textView4.visibility = View.VISIBLE
            textView5.visibility = View.VISIBLE
            textView8.visibility = View.VISIBLE
            textView9.visibility = View.VISIBLE
            textView10.visibility = View.VISIBLE
            textView11.visibility = View.VISIBLE
            color_name_edit.visibility = View.VISIBLE
            done1.visibility = View.GONE
            back1.visibility = View.GONE

        }

        back1.setOnClickListener {

            button10.text = buttons.getString("buttons", "default")
            color_name_edit.text = buttons.getString("buttons", "default")
            editText2.visibility = View.GONE
            button7.visibility = View.VISIBLE
            button8.visibility = View.VISIBLE
            button9.visibility = View.VISIBLE
            button10.visibility = View.VISIBLE
            button11.visibility = View.VISIBLE
            button12.visibility = View.VISIBLE
            button13.visibility = View.VISIBLE
            button14.visibility = View.VISIBLE
            colorR.visibility = View.VISIBLE
            colorG.visibility = View.VISIBLE
            colorB.visibility = View.VISIBLE
            colorA.visibility = View.VISIBLE
            textView2.visibility = View.VISIBLE
            textView3.visibility = View.VISIBLE
            textView4.visibility = View.VISIBLE
            textView5.visibility = View.VISIBLE
            textView8.visibility = View.VISIBLE
            textView9.visibility = View.VISIBLE
            textView10.visibility = View.VISIBLE
            textView11.visibility = View.VISIBLE
            color_name_edit.visibility = View.VISIBLE
            done1.visibility = View.GONE
            back1.visibility = View.GONE
        }

        // second preset button
        button9.setOnClickListener {

            colorR.progress = settings2.getInt("Red", 0)
            colorG.progress = settings2.getInt("Green", 0)
            colorB.progress = settings2.getInt("Blue", 0)
            colorA.progress = settings2.getInt("Opacity", 0)

            button9.text = buttons2.getString("buttons", "default")
            color_name_edit.text = buttons2.getString("buttons", "default")

        }

        // second save button
        button12.setOnClickListener {

            editText3.visibility = View.VISIBLE
            button7.visibility = View.GONE
            button8.visibility = View.GONE
            button9.visibility = View.GONE
            button10.visibility = View.GONE
            button11.visibility = View.GONE
            button12.visibility = View.GONE
            button13.visibility = View.GONE
            button14.visibility = View.GONE
            colorR.visibility = View.GONE
            colorG.visibility = View.GONE
            colorB.visibility = View.GONE
            colorA.visibility = View.GONE
            textView2.visibility = View.GONE
            textView3.visibility = View.GONE
            textView4.visibility = View.GONE
            textView5.visibility = View.GONE
            textView8.visibility = View.GONE
            textView9.visibility = View.GONE
            textView10.visibility = View.GONE
            textView11.visibility = View.GONE
            color_name_edit.visibility = View.GONE
            done1.visibility = View.GONE
            done2.visibility = View.VISIBLE
            done3.visibility = View.GONE
            done4.visibility = View.GONE
            back1.visibility = View.GONE
            back2.visibility = View.VISIBLE
            back3.visibility = View.GONE
            back4.visibility = View.GONE
        }

        // second done button
        done2.setOnClickListener {
            editor2.putInt("Red", colorR.progress)
            editor2.putInt("Green", colorG.progress)
            editor2.putInt("Blue", colorB.progress)
            editor2.putInt("Opacity", colorA.progress)
            editor2.apply()

            button9.text = editText3.text
            color_name_edit.text = editText3.text
            editor6.putString("buttons", button9.text.toString())
            editor6.apply()

            editText3.visibility = View.GONE
            button7.visibility = View.VISIBLE
            button8.visibility = View.VISIBLE
            button9.visibility = View.VISIBLE
            button10.visibility = View.VISIBLE
            button11.visibility = View.VISIBLE
            button12.visibility = View.VISIBLE
            button13.visibility = View.VISIBLE
            button14.visibility = View.VISIBLE
            colorR.visibility = View.VISIBLE
            colorG.visibility = View.VISIBLE
            colorB.visibility = View.VISIBLE
            colorA.visibility = View.VISIBLE
            textView2.visibility = View.VISIBLE
            textView3.visibility = View.VISIBLE
            textView4.visibility = View.VISIBLE
            textView5.visibility = View.VISIBLE
            textView8.visibility = View.VISIBLE
            textView9.visibility = View.VISIBLE
            textView10.visibility = View.VISIBLE
            textView11.visibility = View.VISIBLE
            color_name_edit.visibility = View.VISIBLE
            done2.visibility = View.GONE
            back2.visibility = View.GONE

        }

        back2.setOnClickListener {

            button9.text = buttons2.getString("buttons", "default")
            color_name_edit.text = buttons2.getString("buttons", "default")
            editText3.visibility = View.GONE
            button7.visibility = View.VISIBLE
            button8.visibility = View.VISIBLE
            button9.visibility = View.VISIBLE
            button10.visibility = View.VISIBLE
            button11.visibility = View.VISIBLE
            button12.visibility = View.VISIBLE
            button13.visibility = View.VISIBLE
            button14.visibility = View.VISIBLE
            colorR.visibility = View.VISIBLE
            colorG.visibility = View.VISIBLE
            colorB.visibility = View.VISIBLE
            colorA.visibility = View.VISIBLE
            textView2.visibility = View.VISIBLE
            textView3.visibility = View.VISIBLE
            textView4.visibility = View.VISIBLE
            textView5.visibility = View.VISIBLE
            textView8.visibility = View.VISIBLE
            textView9.visibility = View.VISIBLE
            textView10.visibility = View.VISIBLE
            textView11.visibility = View.VISIBLE
            color_name_edit.visibility = View.VISIBLE
            done2.visibility = View.GONE
            back2.visibility = View.GONE
        }

        // third preset button
        button8.setOnClickListener {

            colorR.progress = settings3.getInt("Red", 0)
            colorG.progress = settings3.getInt("Green", 0)
            colorB.progress = settings3.getInt("Blue", 0)
            colorA.progress = settings3.getInt("Opacity", 0)

            button8.text = buttons3.getString("buttons", "default")
            color_name_edit.text = buttons3.getString("buttons", "default")
        }

        // third save button
        button13.setOnClickListener {

            editText4.visibility = View.VISIBLE
            button7.visibility = View.GONE
            button8.visibility = View.GONE
            button9.visibility = View.GONE
            button10.visibility = View.GONE
            button11.visibility = View.GONE
            button12.visibility = View.GONE
            button13.visibility = View.GONE
            button14.visibility = View.GONE
            colorR.visibility = View.GONE
            colorG.visibility = View.GONE
            colorB.visibility = View.GONE
            colorA.visibility = View.GONE
            textView2.visibility = View.GONE
            textView3.visibility = View.GONE
            textView4.visibility = View.GONE
            textView5.visibility = View.GONE
            textView8.visibility = View.GONE
            textView9.visibility = View.GONE
            textView10.visibility = View.GONE
            textView11.visibility = View.GONE
            color_name_edit.visibility = View.GONE
            done1.visibility = View.GONE
            done2.visibility = View.GONE
            done3.visibility = View.VISIBLE
            done4.visibility = View.GONE
            back1.visibility = View.GONE
            back2.visibility = View.GONE
            back3.visibility = View.VISIBLE
            back4.visibility = View.GONE
        }

        // third done button
        done3.setOnClickListener {

            editor3.putInt("Red", colorR.progress)
            editor3.putInt("Green", colorG.progress)
            editor3.putInt("Blue", colorB.progress)
            editor3.putInt("Opacity", colorA.progress)
            editor3.apply()

            button8.text = editText4.text
            color_name_edit.text = editText4.text
            editor7.putString("buttons", button8.text.toString())
            editor7.apply()

            editText4.visibility = View.GONE
            button7.visibility = View.VISIBLE
            button8.visibility = View.VISIBLE
            button9.visibility = View.VISIBLE
            button10.visibility = View.VISIBLE
            button11.visibility = View.VISIBLE
            button12.visibility = View.VISIBLE
            button13.visibility = View.VISIBLE
            button14.visibility = View.VISIBLE
            colorR.visibility = View.VISIBLE
            colorG.visibility = View.VISIBLE
            colorB.visibility = View.VISIBLE
            colorA.visibility = View.VISIBLE
            textView2.visibility = View.VISIBLE
            textView3.visibility = View.VISIBLE
            textView4.visibility = View.VISIBLE
            textView5.visibility = View.VISIBLE
            textView8.visibility = View.VISIBLE
            textView9.visibility = View.VISIBLE
            textView10.visibility = View.VISIBLE
            textView11.visibility = View.VISIBLE
            color_name_edit.visibility = View.VISIBLE
            done3.visibility = View.GONE
            back3.visibility = View.GONE

        }

        back3.setOnClickListener {

            button8.text = buttons3.getString("buttons", "default")
            color_name_edit.text = buttons3.getString("buttons", "default")
            editText4.visibility = View.GONE
            button7.visibility = View.VISIBLE
            button8.visibility = View.VISIBLE
            button9.visibility = View.VISIBLE
            button10.visibility = View.VISIBLE
            button11.visibility = View.VISIBLE
            button12.visibility = View.VISIBLE
            button13.visibility = View.VISIBLE
            button14.visibility = View.VISIBLE
            colorR.visibility = View.VISIBLE
            colorG.visibility = View.VISIBLE
            colorB.visibility = View.VISIBLE
            colorA.visibility = View.VISIBLE
            textView2.visibility = View.VISIBLE
            textView3.visibility = View.VISIBLE
            textView4.visibility = View.VISIBLE
            textView5.visibility = View.VISIBLE
            textView8.visibility = View.VISIBLE
            textView9.visibility = View.VISIBLE
            textView10.visibility = View.VISIBLE
            textView11.visibility = View.VISIBLE
            color_name_edit.visibility = View.VISIBLE
            done3.visibility = View.GONE
            back3.visibility = View.GONE
        }

        // forth preset button
        button7.setOnClickListener {

            colorR.progress = settings4.getInt("Red", 0)
            colorG.progress = settings4.getInt("Green", 0)
            colorB.progress = settings4.getInt("Blue", 0)
            colorA.progress = settings4.getInt("Opacity", 0)

            button7.text = buttons4.getString("buttons", "default")
            color_name_edit.text = buttons4.getString("buttons", "default")

        }

        // forth save button
        button14.setOnClickListener {

            editText5.visibility = View.VISIBLE
            button7.visibility = View.GONE
            button8.visibility = View.GONE
            button9.visibility = View.GONE
            button10.visibility = View.GONE
            button11.visibility = View.GONE
            button12.visibility = View.GONE
            button13.visibility = View.GONE
            button14.visibility = View.GONE
            colorR.visibility = View.GONE
            colorG.visibility = View.GONE
            colorB.visibility = View.GONE
            colorA.visibility = View.GONE
            textView2.visibility = View.GONE
            textView3.visibility = View.GONE
            textView4.visibility = View.GONE
            textView5.visibility = View.GONE
            textView8.visibility = View.GONE
            textView9.visibility = View.GONE
            textView10.visibility = View.GONE
            textView11.visibility = View.GONE
            color_name_edit.visibility = View.GONE
            done1.visibility = View.GONE
            done2.visibility = View.GONE
            done3.visibility = View.GONE
            done4.visibility = View.VISIBLE
            back1.visibility = View.GONE
            back2.visibility = View.GONE
            back3.visibility = View.GONE
            back4.visibility = View.VISIBLE

        }

        // forth done button
        done4.setOnClickListener {

            editor4.putInt("Red", colorR.progress)
            editor4.putInt("Green", colorG.progress)
            editor4.putInt("Blue", colorB.progress)
            editor4.putInt("Opacity", colorA.progress)
            editor4.apply()

            button7.text = editText5.text
            color_name_edit.text = editText5.text
            editor8.putString("buttons", button7.text.toString())
            editor8.apply()

            editText5.visibility = View.GONE
            button7.visibility = View.VISIBLE
            button8.visibility = View.VISIBLE
            button9.visibility = View.VISIBLE
            button10.visibility = View.VISIBLE
            button11.visibility = View.VISIBLE
            button12.visibility = View.VISIBLE
            button13.visibility = View.VISIBLE
            button14.visibility = View.VISIBLE
            colorR.visibility = View.VISIBLE
            colorG.visibility = View.VISIBLE
            colorB.visibility = View.VISIBLE
            colorA.visibility = View.VISIBLE
            textView2.visibility = View.VISIBLE
            textView3.visibility = View.VISIBLE
            textView4.visibility = View.VISIBLE
            textView5.visibility = View.VISIBLE
            textView8.visibility = View.VISIBLE
            textView9.visibility = View.VISIBLE
            textView10.visibility = View.VISIBLE
            textView11.visibility = View.VISIBLE
            color_name_edit.visibility = View.VISIBLE
            done4.visibility = View.GONE
            back4.visibility = View.GONE

        }

        back4.setOnClickListener {

            button7.text = buttons4.getString("buttons", "default")
            color_name_edit.text = buttons4.getString("buttons", "default")
            editText5.visibility = View.GONE
            button7.visibility = View.VISIBLE
            button8.visibility = View.VISIBLE
            button9.visibility = View.VISIBLE
            button10.visibility = View.VISIBLE
            button11.visibility = View.VISIBLE
            button12.visibility = View.VISIBLE
            button13.visibility = View.VISIBLE
            button14.visibility = View.VISIBLE
            colorR.visibility = View.VISIBLE
            colorG.visibility = View.VISIBLE
            colorB.visibility = View.VISIBLE
            colorA.visibility = View.VISIBLE
            textView2.visibility = View.VISIBLE
            textView3.visibility = View.VISIBLE
            textView4.visibility = View.VISIBLE
            textView5.visibility = View.VISIBLE
            textView8.visibility = View.VISIBLE
            textView9.visibility = View.VISIBLE
            textView10.visibility = View.VISIBLE
            textView11.visibility = View.VISIBLE
            color_name_edit.visibility = View.VISIBLE
            done4.visibility = View.GONE
            back4.visibility = View.GONE
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
