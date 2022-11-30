package com.example.applibrary.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.navigation.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applibrary.interfaces.OnServiceClickListener
import com.example.applibrary.R
import com.example.applibrary.ui.adapters.ServiceAdapter
import com.example.applibrary.data.models.ServiceItemModel
import com.example.applibrary.data.viewmodels.HomeViewModule
import com.example.applibrary.databinding.FragmentHomeBinding
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import org.koin.androidx.viewmodel.ext.android.viewModel


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private var _binding:FragmentHomeBinding? = null
    private val binding:FragmentHomeBinding get() = _binding!!
    private lateinit var serviceAdapter: ServiceAdapter
    private val homeViewModule: HomeViewModule by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        homeViewModule.services()
        serviceAdapter = ServiceAdapter(listOf())
        serviceAdapter.listener = object : OnServiceClickListener {
            override fun onClick(item: ServiceItemModel) {
                val direction = HomeFragmentDirections.actionHomeFragmentToWritersFragment()
                direction.name = item.title
                direction.description = item.description
                direction.search = false
                view?.findNavController()?.navigate(direction)
            }
        }
        binding.homeRecycleView.apply {
            adapter = serviceAdapter
            layoutManager = LinearLayoutManager(requireContext())
        }
        observeViewModel()
    }

    private fun observeViewModel(){
        homeViewModule.services.observe(viewLifecycleOwner, Observer {
            serviceAdapter.updateDataset(it)
        })
    }

}