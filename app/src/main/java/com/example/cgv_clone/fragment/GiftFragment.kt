package com.example.cgv_clone.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.cgv_clone.databinding.FragmentGiftBinding

class GiftFragment : Fragment() {

    private var _binding: FragmentGiftBinding? = null

    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentGiftBinding.inflate(inflater, container, false)
        return binding.root

    }

}