package com.example.qrcodeapp.fragments.updateScan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.qrcodeapp.R
import com.example.qrcodeapp.databinding.FragmentUpdateScanBinding

class UpdateScanFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentUpdateScanBinding.inflate(layoutInflater, container, false)

        return binding.root
    }


}