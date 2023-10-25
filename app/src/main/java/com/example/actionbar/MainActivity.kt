package com.example.actionbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.viewpager2.widget.ViewPager2
import com.example.actionbar.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    //membuat binding
    private lateinit var binding : ActivityMainBinding

    lateinit var mediator: TabLayoutMediator
    lateinit var viewPager1: ViewPager2
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        title = " "
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        with(binding) {
            viewPager1 = viewPager
            //Adapter ini digunakan untuk mengelola tampilan tab dan kontennya.
            viewPager.adapter = TabAdapter(supportFragmentManager, this@MainActivity.lifecycle)
            mediator = TabLayoutMediator(tabLayout, viewPager)
            {tab, position ->
                when(position) {
                    0 -> tab.text = "Register"
                    1 -> tab.text = "Login"
                    else -> " "
                }
            }
            //menghubungkan mediator yang telah dikonfigurasi dengan TabLayout dan ViewPager2
            mediator.attach()
            viewPager1Companion = viewPager1

        }
    }
    //memanggil variabel di suatu kelas tanpa melalui sebuah objek
    companion object {
        lateinit var viewPager1Companion : ViewPager2
    }
}