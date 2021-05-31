package com.epicood.letsfind.view

import android.graphics.Color
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.epicood.letsfind.R
import com.epicood.letsfind.databinding.FragmentQuizBinding
import com.epicood.letsfind.model.Quiz
import com.epicood.letsfind.viewmodel.QuizViewModel
import kotlinx.android.synthetic.main.fragment_quiz.*


class QuizFragment : Fragment() {

    private lateinit var viewModel : QuizViewModel
    private var count = 0
    private lateinit var binding: FragmentQuizBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_quiz, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)
        viewModel.getData()

        viewModel.quizs.observe(viewLifecycleOwner, Observer { quizs ->
            quizs?.let {
//                setQuizs(it)
                setQuizs(it)
                Log.i("quiz", it.toString())
            }
        })

//        variantSelect("Mars")

    }

    private fun setQuizs(quizs: List<Quiz>){

        btnNext.setOnClickListener {

            if (count < quizs.size){
                qusestionText.text = quizs[count].quest
                variantAText.text = quizs[count].answerA
                variantBText.text = quizs[count].answerB
                variantCText.text = quizs[count].answerC
                variantDText.text = quizs[count].answerD
                variantSelect(quizs[count].answer)
                Log.i("asdf", quizs[count].toString())
                count++
            }else{
                val action = QuizFragmentDirections.actionQuizFragmentToResultFragment()
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    private fun variantSelect(answer: String){
        variantAText.setBackgroundColor(Color.parseColor("#3F51B5"))
        variantBText.setBackgroundColor(Color.parseColor("#3F51B5"))
        variantCText.setBackgroundColor(Color.parseColor("#3F51B5"))
        variantDText.setBackgroundColor(Color.parseColor("#3F51B5"))
        var i=0
        variantA.setOnClickListener {
            if(i!=1) {
                i = 1
                if (variantAText.text.equals(answer)) {
                    variantAText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantBText.text.equals(answer)){
                    variantAText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantBText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantCText.text.equals(answer)){
                    variantAText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantCText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantDText.text.equals(answer)){
                    variantAText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantDText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }
            }
        }
        variantB.setOnClickListener {
            if(i!=1) {
                i = 1
                if (variantBText.text.equals(answer)) {
                    variantBText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantAText.text.equals(answer)){
                    variantBText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantAText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantCText.text.equals(answer)){
                    variantBText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantCText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantDText.text.equals(answer)){
                    variantBText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantDText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }
            }
        }
        variantC.setOnClickListener {
            if(i!=1) {
                i = 1
                if (variantCText.text.equals(answer)) {
                    variantCText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantAText.text.equals(answer)){
                    variantBText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantAText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantCText.text.equals(answer)){
                    variantBText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantCText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantDText.text.equals(answer)){
                    variantBText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantDText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }
            }
        }
        variantD.setOnClickListener {
            if(i!=1) {
                i = 1
                if (variantDText.text.equals(answer)) {
                    variantDText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantAText.text.equals(answer)){
                    variantDText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantAText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantCText.text.equals(answer)){
                    variantDText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantCText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantBText.text.equals(answer)){
                    variantDText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantBText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }
            }
        }
    }
}



/*
        var i=0
        variantA.setOnClickListener {
            if(i!=1) {
                i = 1
                if (variantAText.text.equals("Mars")) {
                    variantAText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantBText.text.equals("Mars")){
                    variantAText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantBText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantCText.text.equals("Mars")){
                    variantAText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantCText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantDText.text.equals("Mars")){
                    variantAText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantDText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }
            }
        }
        variantB.setOnClickListener {
            if(i!=1) {
                i = 1
                if (variantBText.text.equals("Mars")) {
                    variantBText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantAText.text.equals("Mars")){
                    variantBText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantAText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantCText.text.equals("Mars")){
                    variantBText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantCText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantDText.text.equals("Mars")){
                    variantBText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantDText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }
            }
        }
        variantC.setOnClickListener {
            if(i!=1) {
                i = 1
                if (variantCText.text.equals("Mars")) {
                    variantCText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantAText.text.equals("Mars")){
                    variantBText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantAText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantCText.text.equals("Mars")){
                    variantBText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantCText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantDText.text.equals("Mars")){
                    variantBText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantDText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }
            }
        }
        variantD.setOnClickListener {
            if(i!=1) {
                i = 1
                if (variantDText.text.equals("Mars")) {
                    variantDText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantAText.text.equals("Mars")){
                    variantDText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantAText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantCText.text.equals("Mars")){
                    variantDText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantCText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantBText.text.equals("Mars")){
                    variantDText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantBText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }
            }
        }
*/