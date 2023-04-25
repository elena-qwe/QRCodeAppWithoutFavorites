package com.example.qrcodeapp.fragments.scan

import android.app.Activity.RESULT_OK
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavHostController
import androidx.navigation.fragment.NavHostFragment
import com.example.qrcodeapp.R
import com.example.qrcodeapp.databinding.FragmentScanBinding
import com.example.qrcodeapp.model.Scan
import com.example.qrcodeapp.viewmodel.ScanHistoryViewModel
import com.example.qrcodeapp.viewmodel.UserViewModel
import com.google.zxing.integration.android.IntentIntegrator
import com.journeyapps.barcodescanner.ScanOptions
import kotlinx.android.synthetic.main.fragment_scan.view.*


class ScanFragment : Fragment() {

    private lateinit var mScanHistoryViewModel: ScanHistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentScanBinding.inflate(layoutInflater, container, false)

        binding.buttonScan.setOnClickListener {

            val integrator = IntentIntegrator.forSupportFragment(this)
            integrator.setDesiredBarcodeFormats(IntentIntegrator.PRODUCT_CODE_TYPES)
            integrator.setPrompt("Scan a barcode")
            integrator.setCameraId(0)  // use a specific camera of the device
            integrator.setBeepEnabled(false)
            integrator.setOrientationLocked(false)
            integrator.initiateScan()



            /*val integrator = IntentIntegrator.forSupportFragment(this@ScanFragment)

            integrator.setOrientationLocked(false)
            integrator.setPrompt("Scan a barcode")
            integrator.setDesiredBarcodeFormats(IntentIntegrator.QR_CODE)
            integrator.setBeepEnabled(false)
            integrator.initiateScan()*/
        }
        return binding.root
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {

        if(resultCode == RESULT_OK) {
            val resultScan = IntentIntegrator.parseActivityResult(requestCode, resultCode, data)
            if (resultScan != null) {
                if (resultScan.contents == null) {
                    Toast.makeText(requireContext(), "отменено", Toast.LENGTH_LONG
                    ).show()
                } else {
                    Toast.makeText(requireContext(), "Сканирование: " + resultScan.contents, Toast.LENGTH_LONG
                    ).show()
                    val name = requestCode.toString()
                    val content = resultCode.toString()

                    if(inputCheck(name, content))
                    {
                        val scan = Scan(0, name, content)
                        mScanHistoryViewModel = ViewModelProvider(this).get(ScanHistoryViewModel::class.java)
                        mScanHistoryViewModel.addScan(scan)

                    }

                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    }

    private fun inputCheck(name: String, content: String): Boolean {
        return !(TextUtils.isEmpty(name) || TextUtils.isEmpty(content))

    }


}