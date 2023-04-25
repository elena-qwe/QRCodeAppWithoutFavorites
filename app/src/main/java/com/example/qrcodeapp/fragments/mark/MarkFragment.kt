package com.example.qrcodeapp.fragments.mark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.qrcodeapp.R
import com.example.qrcodeapp.databinding.FragmentMarkBinding
import com.example.qrcodeapp.model.Favorite
import com.example.qrcodeapp.viewmodel.FavoritesViewModel
import kotlinx.android.synthetic.main.fragment_mark.view.*


class MarkFragment : Fragment() {

    private lateinit var viewModel: FavoritesViewModel
    private lateinit var adapter: FavoritesAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentMarkBinding.inflate(inflater, container, false)

        viewModel = ViewModelProvider(this).get(FavoritesViewModel::class.java)

        val adapter = FavoritesAdapter()
        binding.recyclerviewMark.adapter = adapter

        binding.floatingActionButton.setOnClickListener {
           //добавить в избранное (?)
        }

        return binding.root
    }


}