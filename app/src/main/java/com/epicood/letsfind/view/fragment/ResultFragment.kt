package com.epicood.letsfind.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.epicood.letsfind.R
import com.epicood.letsfind.getAndroidID
import com.epicood.letsfind.model.Quiz
import com.epicood.letsfind.model.QuizResult
import com.epicood.letsfind.viewmodel.RatingViewModel
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_result.*


class ResultFragment : Fragment() {

//    private lateinit var mDatabase : DatabaseReference
//    private lateinit var binding:
    private lateinit var viewModel: RatingViewModel

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

        viewModel = ViewModelProvider(this).get(RatingViewModel::class.java)
        viewModel.getData()


        arguments?.let {
            var incorrect = ResultFragmentArgs.fromBundle(it).incorrectCount
            var straight = ResultFragmentArgs.fromBundle(it).straightCount
            mainScore.text = straight.toString()
//            score.text = incorrect.toString()
            getCountPoint(straight, incorrect)
            setCupImg(straight)
        }

        resultToMain.setOnClickListener {
            updatePoint()
            Navigation.findNavController(it).navigate(ResultFragmentDirections.actionResultFragmentToBaseFragment())
        }
    }

    private fun getCountPoint(straight: Int, incorrect: Int){
        val sPoint = straight * 50
        val iPoint = incorrect * 25
        var point = sPoint - iPoint
        if (point < 0){
            quizPoint.text = "0"
        }else{
            quizPoint.text = point.toString()
        }
    }
    private fun setCupImg(straight: Int){
        if(straight >= 8){
            cupImage.setImageResource(R.drawable.gold_cup)
        }else if(straight < 8 && straight >= 5){
            cupImage.setImageResource(R.drawable.sliver_cup)
        }else cupImage.setImageResource(R.drawable.bronz_cup)
    }
    private fun updatePoint(){
        viewModel.ratings.observe(viewLifecycleOwner, Observer { ratings->
            ratings?.let {
                it.forEach {
                    if (it.androidID == getAndroidID(requireContext())){
                        var point = it.point?.toInt()?.plus(quizPoint.text.toString().toInt())
                        viewModel.updatePointByAndroidID(getAndroidID(requireContext()),
                            point.toString(), requireContext())
                    }
                }
            }
        })
    }




}