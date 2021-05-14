package com.database.artdrawer

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import petrov.kristiyan.colorpicker.ColorPicker

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        drawingButtonsSetup()
    }
    private fun drawingButtonsSetup() {

        fb_colour_picker.setOnClickListener{
        val colorPicker = ColorPicker(this)
            colorPicker.setOnFastChooseColorListener(object : ColorPicker.OnFastChooseColorListener {
                override fun setOnFastChooseColorListener(position: Int, color: Int) {
                    dv_drawView.setColor(color)
                }

                override fun onCancel() {
                    colorPicker.dismissDialog()
                }
            })

                .disableDefaultButtons(true)
                .setColumns(5)
                .setRoundColorButton(true)
                .show()
        }

        fb_undo.setOnClickListener{
            dv_drawView.undo()

            Snackbar.make(it,"Undo successful",Snackbar.LENGTH_SHORT)
                .setAction("Redo"){
                    dv_drawView.undo()
                }.show()
        }

        fb_clear_all.setOnClickListener{
            dv_drawView.clearCanvas()
        }

    }
}