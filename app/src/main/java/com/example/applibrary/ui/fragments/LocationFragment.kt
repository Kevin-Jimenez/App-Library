package com.example.applibrary.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.applibrary.R
import com.example.applibrary.data.viewmodels.HomeViewModule
import com.example.applibrary.databinding.FragmentLocationBinding
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [LocationFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class LocationFragment : Fragment() , OnMapReadyCallback{

    private var _binding:FragmentLocationBinding? = null
    private val binding: FragmentLocationBinding get() = _binding!!
    private lateinit var nMap: GoogleMap
    private val homeViewModule: HomeViewModule by sharedViewModel()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentLocationBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        homeViewModule.company()
        val mapFragment: SupportMapFragment = childFragmentManager.findFragmentById(R.id.fragment_location_map) as SupportMapFragment
        mapFragment.getMapAsync(this)
    }

    override fun onMapReady(map: GoogleMap) {
        nMap = map
        nMap.uiSettings.isZoomControlsEnabled = true
        observeViewModels()
    }

    private fun observeViewModels(){
        homeViewModule.company.observe(viewLifecycleOwner, Observer {
            val latLng = LatLng(it.lat, it.lng)
            nMap.addMarker(MarkerOptions().position(latLng).title(it.name))
            nMap.moveCamera(CameraUpdateFactory.newLatLngZoom(latLng, 17.0f))
        })
    }

}