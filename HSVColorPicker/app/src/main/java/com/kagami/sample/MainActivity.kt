package com.kagami.sample

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.kagami.hsvcolorpicker.HSVColorPicker

class MainActivity : AppCompatActivity() {

    lateinit var pickerView:HSVColorPicker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        pickerView = findViewById(R.id.picker) as HSVColorPicker
    }
}
