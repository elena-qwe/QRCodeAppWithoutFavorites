package com.example.qrcodeapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupActionBarWithNavController
import androidx.navigation.ui.setupWithNavController
import com.example.qrcodeapp.databinding.ActivityHomeBinding
import com.example.qrcodeapp.fragments.history.HistoryFragment
import com.example.qrcodeapp.fragments.mark.MarkFragment
import com.example.qrcodeapp.fragments.scan.ScanFragment
import com.example.qrcodeapp.fragments.settings.SettingsFragment

class HomeActivity : AppCompatActivity() {


    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)
        replaceFragment(ScanFragment())



        binding.bottomNavigationView.setOnItemSelectedListener {

            when (it.itemId) {
                R.id.scan -> replaceFragment(ScanFragment())
                R.id.settings -> replaceFragment(SettingsFragment())
                R.id.mark -> replaceFragment(MarkFragment())
                R.id.history -> replaceFragment(HistoryFragment())
                else -> {

                }
            }
            true
        }
    }



    fun replaceFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_layout, fragment)
        fragmentTransaction.commit()
    }

}