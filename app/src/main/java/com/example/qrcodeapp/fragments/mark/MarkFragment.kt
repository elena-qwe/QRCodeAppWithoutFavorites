package com.example.qrcodeapp.fragments.mark

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.qrcodeapp.R
import com.example.qrcodeapp.databinding.FragmentMarkBinding
import com.example.qrcodeapp.model.Scan
import com.example.qrcodeapp.viewmodel.FavoritesViewModel


class MarkFragment : Fragment() {

    private lateinit var favoriteItemsRecyclerView: RecyclerView
    private lateinit var favoriteItemsAdapter: FavoriteItemsAdapter
    private val favoriteItems = mutableListOf<Scan>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = FragmentMarkBinding.inflate(inflater, container, false)

        favoriteItemsRecyclerView = binding.favoriteItemsRecyclerView
        favoriteItemsRecyclerView.layoutManager = LinearLayoutManager(requireContext())
        favoriteItemsAdapter = FavoriteItemsAdapter(favoriteItems)
        favoriteItemsRecyclerView.adapter = favoriteItemsAdapter


        return binding.root
    }

    fun addToFavorites(item: Scan) {
        favoriteItems.add(item)
        favoriteItemsAdapter.notifyDataSetChanged()
    }


}