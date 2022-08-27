package com.vgrigorchik.weatherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.vgrigorchik.weatherapp.R
import com.vgrigorchik.weatherapp.adapters.WeatherAdapter
import com.vgrigorchik.weatherapp.adapters.WeatherModel
import com.vgrigorchik.weatherapp.databinding.FragmentHourBinding


class HourFragment : Fragment() {
    lateinit var binding: FragmentHourBinding
    private lateinit var adapter: WeatherAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHourBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRcView()

    }

    private fun initRcView() = with(binding) {
        rcView.layoutManager = LinearLayoutManager(context)
        adapter = WeatherAdapter()
        rcView.adapter = adapter
        val list = listOf(
            WeatherModel("", "12:00", "Солнечно", "30°C",
                "", "", "", ""),
            WeatherModel("", "13:00", "Солнечно", "32°C",
                "", "", "", ""),
            WeatherModel("", "14:00", "Солнечно", "34°C",
                "", "", "", ""),
            WeatherModel("", "15:00", "Солнечно", "36°C",
                "", "", "", ""),
            WeatherModel("", "12:00", "Солнечно", "30°C",
                "", "", "", ""),
            WeatherModel("", "13:00", "Солнечно", "32°C",
                "", "", "", ""),
            WeatherModel("", "14:00", "Солнечно", "34°C",
                "", "", "", ""),
            WeatherModel("", "15:00", "Солнечно", "36°C",
                "", "", "", ""),
        )
        adapter.submitList(list)
    }

    companion object {
        @JvmStatic
        fun newInstance() = HourFragment()
    }
}