package com.example.qrcodeapp.fragments.settings

import android.R
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatDelegate
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import androidx.fragment.app.ListFragment
import com.example.qrcodeapp.databinding.FragmentSettingsBinding
import com.example.qrcodeapp.fragments.ChangeThemeFragment
import com.example.qrcodeapp.fragments.add.AddFragment
import com.example.qrcodeapp.fragments.add.CreateCodeFragment
import com.example.qrcodeapp.fragments.connect.ConnectFragment
import kotlinx.android.synthetic.main.fragment_settings.view.*


class SettingsFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentSettingsBinding.inflate(layoutInflater, container, false)

        //!!переход с одного фрагмента на другой!!//
        binding.connectButton.setOnClickListener {
            val newFragment: Fragment = ConnectFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(com.example.qrcodeapp.R.id.frame_layout, newFragment)
            transaction.addToBackStack(null)

            transaction.commit()
        }

        binding.changeThemeButton.setOnClickListener {
            val newFragment: Fragment = ChangeThemeFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(com.example.qrcodeapp.R.id.frame_layout, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.listUserButton.setOnClickListener {
            val newFragment: Fragment = ListFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(com.example.qrcodeapp.R.id.frame_layout, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.createQRCodeButton.setOnClickListener {
            val newFragment: Fragment = CreateCodeFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(com.example.qrcodeapp.R.id.frame_layout, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        binding.addUserButton.setOnClickListener {
            val newFragment: Fragment = AddFragment()
            val transaction: FragmentTransaction = requireFragmentManager().beginTransaction()

            transaction.replace(com.example.qrcodeapp.R.id.frame_layout, newFragment)
            transaction.addToBackStack(null)
            transaction.commit()
        }

        return binding.root
    }

}

