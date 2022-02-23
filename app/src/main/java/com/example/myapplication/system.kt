package com.example.myapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.viewpager2.widget.ViewPager2
import com.example.myapplication.databinding.ActivitySystemBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class system : AppCompatActivity() {

    lateinit var vistas:ActivitySystemBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        vistas=ActivitySystemBinding.inflate(layoutInflater)

        setContentView(vistas.root)



        val slider=vistas.slider
        val tabs=vistas.tabs

        val adapterSlider=myPages(this)

        slider.adapter=adapterSlider

        val adminTab=TabLayoutMediator(tabs,slider,TabLayoutMediator.TabConfigurationStrategy{
            tab,position->

            when(position){
                0->tab.text="Perfil"
                    1->tab.text="+"
                2->tab.text="Post"
                3->tab.text="Config"
                4->tab.text="..."

            }
        })

        adminTab.attach()

    }
}