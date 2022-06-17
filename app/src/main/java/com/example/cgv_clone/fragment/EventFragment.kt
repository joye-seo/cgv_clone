package com.example.cgv_clone.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cgv_clone.databinding.FragmentEventBinding

class EventFragment : Fragment() {

    private var _binding: FragmentEventBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentEventBinding.inflate(inflater, container, false)
        return binding.root

    }

}