package com.epicood.letsfind.view.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.epicood.letsfind.R
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_result.*


class ResultFragment : Fragment() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_result, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var database = FirebaseDatabase.getInstance().reference


        resultToMain.setOnClickListener {
            Navigation.findNavController(it).navigate(ResultFragmentDirections.actionResultFragmentToBaseFragment())
        }

    }

}