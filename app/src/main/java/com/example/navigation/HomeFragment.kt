package com.example.navigation

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.ActivityNavigator
import androidx.navigation.fragment.FragmentNavigatorExtras
import androidx.navigation.fragment.findNavController
import com.example.navigation.databinding.FragmentHomeBinding
import kotlinx.serialization.Serializable
import kotlinx.serialization.decodeFromString
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.encodeToJsonElement

class HomeFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val json = Json.encodeToString(One(1))
        val one = Json.decodeFromString<One>(json)
    }

    private lateinit var binding: FragmentHomeBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.apply {
            redTV.setOnClickListener {
                val extras = FragmentNavigatorExtras(redTV to "red")
                findNavController().navigate(HomeFragmentDirections.showRed(), extras)
            }
            yellowTV.setOnClickListener {
                val extras = FragmentNavigatorExtras(yellowTV to "yellow")
                findNavController().navigate(HomeFragmentDirections.showYellow(), extras)
            }
            greenTV.setOnClickListener {
                val extras = FragmentNavigatorExtras(greenTV to "green")
                findNavController().navigate(HomeFragmentDirections.showGreen(), extras)
            }
        }
    }
}

@Serializable
data class One(val a: Int)