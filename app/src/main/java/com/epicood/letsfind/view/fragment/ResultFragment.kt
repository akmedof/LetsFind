package com.epicood.letsfind.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import com.epicood.letsfind.R
import com.epicood.letsfind.model.Quiz
import com.epicood.letsfind.model.QuizResult
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_result.*


class ResultFragment : Fragment() {

//    private lateinit var result: QuizResult

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
        arguments?.let {
            var incorrect = ResultFragmentArgs.fromBundle(it).incorrectCount
            var straight = ResultFragmentArgs.fromBundle(it).straightCount
            mainScore.text = straight.toString()
//            score.text = incorrect.toString()
            getCountPoint(straight, incorrect)
        }
//        mainScore.text =
//        score.text = result.incorrect.toString()

        resultToMain.setOnClickListener {
            Navigation.findNavController(it).navigate(ResultFragmentDirections.actionResultFragmentToBaseFragment())
        }
    }

    private fun getCountPoint(straight: Int, incorrect: Int){
        val sPoint = straight * 50
        val iPoint = incorrect * 25
        var point = sPoint - iPoint
        if (point < 0){
            quizPoint.text = "0"
        }
        quizPoint.text = point.toString()
    }

}