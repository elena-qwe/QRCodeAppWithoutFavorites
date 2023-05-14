package com.example.qrcodeapp.fragments.updateScan

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.set
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.example.qrcodeapp.R
import com.example.qrcodeapp.databinding.FragmentUpdateScanBinding
import com.example.qrcodeapp.viewmodel.ScanHistoryViewModel

class UpdateScanFragment : Fragment() {

    private lateinit var mScanHistoryViewModel: ScanHistoryViewModel
    //private val args by navArgs<UpdateScanFragment>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val binding = FragmentUpdateScanBinding.inflate(layoutInflater, container, false)

        mScanHistoryViewModel = ViewModelProvider(this)
            .get(ScanHistoryViewModel::class.java)

        //binding.inputNameEditText.editableText?.set(args.)

        return binding.root
    }


}