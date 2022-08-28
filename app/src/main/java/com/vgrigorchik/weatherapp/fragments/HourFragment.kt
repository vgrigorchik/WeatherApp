package com.vgrigorchik.weatherapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Adapter
import android.widget.LinearLayout
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.vgrigorchik.weatherapp.MainViewModel
import com.vgrigorchik.weatherapp.R
import com.vgrigorchik.weatherapp.adapters.WeatherAdapter
import com.vgrigorchik.weatherapp.adapters.WeatherModel
import com.vgrigorchik.weatherapp.databinding.FragmentHourBinding
import org.json.JSONArray
import org.json.JSONObject


class HourFragment : Fragment() {
    lateinit var binding: FragmentHourBinding
    private lateinit var adapter: WeatherAdapter
    private val model: MainViewModel by activityViewModels()

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
        model.liveDataCurrent.observe(viewLifecycleOwner){
            adapter.submitList(getHoursList(it))

        }

    }

    private fun initRcView() = with(binding) {
        rcView.layoutManager = LinearLayoutManager(context)
        adapter = WeatherAdapter()
        rcView.adapter = adapter
    }

    private fun getHoursList(wItem: WeatherModel): List<WeatherModel>{
        val hoursArray = JSONArray(wItem.hours)
        val list = ArrayList<WeatherModel>()
        for (i in 0 until hoursArray.length()){
            val item = WeatherModel(
                "",
                (hoursArray[i] as JSONObject).getString("time"),
                (hoursArray[i] as JSONObject).getJSONObject("condition").getString("text"),
                (hoursArray[i] as JSONObject).getString("temp_c"),
                "",
                "",
                (hoursArray[i] as JSONObject).getJSONObject("condition").getString("icon"),
                ""
            )
            list.add(item)
        }
        return list
    }

    companion object {
        @JvmStatic
        fun newInstance() = HourFragment()
    }
}