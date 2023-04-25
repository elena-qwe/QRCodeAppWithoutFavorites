package com.example.qrcodeapp.fragments.history


import android.app.AlertDialog
import android.os.Bundle
import android.view.*
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qrcodeapp.R
import com.example.qrcodeapp.databinding.FragmentHistoryBinding
import com.example.qrcodeapp.fragments.mark.FavoritesAdapter
import com.example.qrcodeapp.model.Favorite
import com.example.qrcodeapp.model.Scan
import com.example.qrcodeapp.viewmodel.FavoritesViewModel
import com.example.qrcodeapp.viewmodel.ScanHistoryViewModel
import kotlinx.android.synthetic.main.fragment_list.view.*
import kotlinx.android.synthetic.main.item_scan.*
import kotlinx.android.synthetic.main.item_scan.view.*


class HistoryFragment : Fragment() {

    /*private lateinit var viewModelFav: FavoritesViewModel
    private lateinit var adapterFav: FavoritesAdapter*/
    private lateinit var mScanHistoryViewModel: ScanHistoryViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?
    ): View? {
        val binding = FragmentHistoryBinding.inflate(layoutInflater, container, false)

        //recyclerview
        val adapter = ScanAdapter()
        val recyclerView = binding.recyclerview
        recyclerView.adapter = adapter
        recyclerView.layoutManager = LinearLayoutManager(requireContext())

        //scanViewModel
        mScanHistoryViewModel = ViewModelProvider(this).get(ScanHistoryViewModel::class.java)
        mScanHistoryViewModel.readAllData.observe(viewLifecycleOwner, Observer { scan ->
            adapter.setData(scan)
        })


        //add menu
        setHasOptionsMenu(true)

        return binding.root
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        inflater.inflate(R.menu.delete_menu, menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == R.id.menu_delete) {
            deleteAllScans()
        }

        return super.onOptionsItemSelected(item)
    }


    private fun deleteAllScans() {
        val builder = AlertDialog.Builder(requireContext())
        builder.setPositiveButton("Да") { _, _ ->
            mScanHistoryViewModel.deleteAllScans()
            Toast.makeText(
                requireContext(), "Вся история успешно удалена", Toast.LENGTH_LONG
            ).show()
        }
        builder.setNegativeButton("Нет") { _, _ -> }
        builder.setTitle("Удалить всю историю?")
        builder.setMessage("Вы уверены, что хотите удалить всю историю?")
        builder.create().show()
    }

}