package com.example.qrcodeapp.fragments.settings

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.qrcodeapp.databinding.FragmentSettingsBinding
import com.example.qrcodeapp.fragments.connect.ConnectFragment
import kotlinx.android.synthetic.main.fragment_settings.view.*


class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)

        //!!переход на другой фрагмент!!//
        binding.connectButton.setOnClickListener {
            val newFragment: Fragment = ConnectFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(com.example.qrcodeapp.R.id.frame_layout, newFragment)
            transaction.addToBackStack(null)

            transaction.commit()
        }

        binding.lightThemeButton.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
        }

        binding.darkThemeButton.setOnClickListener {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
        }



        return binding.root


    }





}

