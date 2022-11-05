package com.example.applibrary

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.applibrary.databinding.FragmentHomeBinding
import com.example.applibrary.databinding.FragmentSingUpBinding


/**
 * A simple [Fragment] subclass.
 * Use the [HomeFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class HomeFragment : Fragment() {

    private var _binding:FragmentHomeBinding? = null
    private val binding:FragmentHomeBinding get() = _binding!!
    private lateinit var serviceAdapter: ServiceAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentHomeBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        serviceAdapter = ServiceAdapter(listOf(
            ServiceItemModel(
                "1","Aventura","Es un género narrativo literario que narra los viajes, el misterio y el riesgo",R.drawable.logins.toString()
            ),
            ServiceItemModel(
                "2","Ciencia Ficcion","Es un género narrativo literario que narra la ficcion, la literatura fantastica y el terror",R.drawable.logins.toString()
            ),
            ServiceItemModel(
                "3","Fantasia","Es un género narrativo literario que narra la fantasia",R.drawable.logins.toString()
            ),
            ServiceItemModel(
                "4","Romantico","Es un género narrativo literario que narra lo dulce del amor y la pasion",R.drawable.logins.toString()
            ),
            ServiceItemModel(
                "5","Infantil y Juvenil","Es un género narrativo literario que narra las obras de creación para niños y jóvenes",R.drawable.logins.toString()
            )
        ))
        serviceAdapter.listener = object : OnServiceClickListener{
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
    }

}