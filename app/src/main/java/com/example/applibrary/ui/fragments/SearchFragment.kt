package com.example.applibrary.ui.fragments

import android.content.ActivityNotFoundException
import android.content.Intent
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.example.applibrary.CAMERA_PERMISSION_CODE
import com.example.applibrary.REQUEST_IMAGE_CODE
import com.example.applibrary.checkPermission
import com.example.applibrary.data.viewmodels.LoginViewModel
import com.example.applibrary.databinding.FragmentSearchBinding
import com.example.applibrary.ui.activities.LoginActivity
import org.koin.androidx.viewmodel.ext.android.sharedViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [SearchFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SearchFragment : Fragment() {

    private var _binding:FragmentSearchBinding? = null
    private val binding: FragmentSearchBinding get() = _binding!!
    private val loginViewModel: LoginViewModel by sharedViewModel()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentSearchBinding.inflate(layoutInflater, container, false)
        return binding.root
    }

    override fun onStart() {
        super.onStart()
        binding.profileFragmentLogout.setOnClickListener {
            loginViewModel.logOut()
        }

        binding.profileFragmenteImage.setOnClickListener {
            if (checkPermission(android.Manifest.permission.CAMERA, CAMERA_PERMISSION_CODE)){
                    openCamera()
            }
        }
        observeViewModel()

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<out String>,
        grantResults: IntArray
    ) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        if(requestCode == CAMERA_PERMISSION_CODE && grantResults[0] == PackageManager.PERMISSION_GRANTED){
            openCamera()
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == REQUEST_IMAGE_CODE){
            val extras = data!!.extras
            val image = extras!!["data"] as Bitmap?
            binding.profileFragmenteImage.setImageBitmap(image)
        }
    }

    private fun openCamera(){
        val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(intent, REQUEST_IMAGE_CODE)
        }catch (e: ActivityNotFoundException){
            Log.d("Hola", e.message.toString())
        }
    }

    private fun observeViewModel(){
        loginViewModel.user.observe(viewLifecycleOwner, Observer {
            if(it != null){
                binding.profileFragmenteImage.setImageResource(it.icon.toInt())
                binding.profileFragmentName.text = it.name
                binding.profileFragmentEmail.text = it.email
            }else{
                val intent = Intent(requireContext(), LoginActivity::class.java)
                startActivity(intent)
                requireActivity().finish()
            }
        })
    }

}