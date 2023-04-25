package com.example.qrcodeapp.fragments.connect

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import com.example.qrcodeapp.R
import com.example.qrcodeapp.databinding.FragmentConnectBinding
import com.example.qrcodeapp.viewmodel.DatabaseViewModel
import kotlinx.android.synthetic.main.fragment_connect.view.*

class ConnectFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val binding = FragmentConnectBinding.inflate(layoutInflater, container, false)

        val viewModel = ViewModelProvider(this).get(DatabaseViewModel::class.java)

        binding.connectButton.setOnClickListener {
            val url = binding.urlEditText.text.toString()
            val user = binding.userEditText.text.toString()
            val password = binding.passwordEditText.text.toString()
            val isConnected = viewModel.connectToDatabase(url, user, password)

            if (isConnected) {
                Toast.makeText(context, "Connected to database", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(context, "Failed to connect to database", Toast.LENGTH_SHORT).show()
            }
        }

        return binding.root
    }


}