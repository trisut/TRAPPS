package com.example.trapps

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

class fragment_daily : Fragment() {

    private lateinit var recyclerViewVertical: RecyclerView
    private lateinit var recyclerViewHorizontal: RecyclerView
    private lateinit var verticalAdapter: MyAdapter
    private lateinit var horizontalAdapter: HorizontalAdapter
    private lateinit var verticalDataList: List<DataModel>
    private lateinit var horizontalDataList: List<DataModel>

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_daily, container, false)

        recyclerViewVertical = view.findViewById(R.id.recyclerViewVertical)
        recyclerViewVertical.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

        recyclerViewHorizontal = view.findViewById(R.id.recyclerViewHorizontal)
        recyclerViewHorizontal.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)

        verticalDataList = generateVerticalData()
        verticalAdapter = MyAdapter(verticalDataList)
        recyclerViewVertical.adapter = verticalAdapter

        horizontalDataList = generateHorizontalData()
        horizontalAdapter = HorizontalAdapter(horizontalDataList)
        recyclerViewHorizontal.adapter = horizontalAdapter

        return view
    }

    private val verticalTexts = listOf(
        "Bangun Tidur",
        "Mandi",
        "Bermain Game",
        "Nongkrong Bersama Teman",
        "Tidur"
    )

    private val verticalImages = listOf(
        R.drawable.bangun,
        R.drawable.mandi,
        R.drawable.main,
        R.drawable.nongkrong,
        R.drawable.tidur
    )

    private val horizontalTexts = listOf(
        "Faliq",
        "Moricio",
        "Wildan",
        "Nasza",
        "Deran"
    )

    private val horizontalImages = listOf(
        R.drawable.friend,
        R.drawable.friend1,
    )

    private fun generateVerticalData(): List<DataModel> {
        val size = minOf(verticalTexts.size, verticalImages.size)
        return List(size) { index ->
            DataModel(verticalTexts[index], verticalImages[index])
        }
    }

    private fun generateHorizontalData(): List<DataModel> {
        val size = minOf(horizontalTexts.size, horizontalImages.size)
        return List(size) { index ->
            DataModel(horizontalTexts[index], horizontalImages[index])
        }
    }

    // Model data Anda
    data class DataModel(val text: String, val imageRes: Int)
}