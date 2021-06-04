package com.epicood.letsfind.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.epicood.letsfind.R
import com.epicood.letsfind.adapter.RatingAdapter
import com.epicood.letsfind.viewmodel.RatingViewModel
import kotlinx.android.synthetic.main.fragment_rating.*

class RatingFragment : Fragment() {

//    private lateinit var database : FirebaseDatabase
    private lateinit var viewModel : RatingViewModel
    private val adapter = RatingAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_rating, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RatingViewModel::class.java)
        viewModel.getData()

        recyclerViewRating.layoutManager = LinearLayoutManager(requireContext())
        recyclerViewRating.adapter = adapter

        viewModel.ratings.observe(viewLifecycleOwner, Observer { ratings ->
            ratings?.let {
                adapter.updateFavoriteList(it)
            }
        })

    }

    override fun onStop() {
        super.onStop()
    }

}