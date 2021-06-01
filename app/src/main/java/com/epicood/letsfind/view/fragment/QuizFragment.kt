package com.epicood.letsfind.view.fragment

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.text.Editable
import android.text.TextWatcher
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
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
    private lateinit var list: List<Quiz>
    private lateinit var binding: FragmentQuizBinding
    private lateinit var countBar: CountDownTimer

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



//        countBar.start()
//        countBar.onFinish()


        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)
        viewModel.getData()

        viewModel.quizs.observe(viewLifecycleOwner, Observer { quizs ->
            quizs?.let {
                setQuizs(it)
                list = it
            }
        })

        countBar = object : CountDownTimer(10*1000, 1000){
            override fun onTick(millisUntilFinished: Long) {
                textCount.text = (millisUntilFinished/1000).toInt().toString()
                progressBar.setProgress((millisUntilFinished/100).toInt())
            }
            override fun onFinish() {
                Log.i("timeend","fgvswfa")

                if (count < list.size){
                    setQuizs(list)
                }else{
                    countBar.cancel()
                    val action =
                        QuizFragmentDirections.actionQuizFragmentToResultFragment()
                    Navigation.findNavController(view).navigate(action)
                }
                progressBar.setProgress(0)
            }
        }.start()
    }

    private fun setQuizs(quizs: List<Quiz>){
        countBar.start()
        qusestionText.text = quizs[count].quest
        variantAText.text = quizs[count].answerA
        variantBText.text = quizs[count].answerB
        variantCText.text = quizs[count].answerC
        variantDText.text = quizs[count].answerD
        variantSelect(quizs[count].answer)
        count++
        btnNext.setOnClickListener {
            countBar.start()
            if (count < quizs.size) {
                qusestionText.text = quizs[count].quest
                variantAText.text = quizs[count].answerA
                variantBText.text = quizs[count].answerB
                variantCText.text = quizs[count].answerC
                variantDText.text = quizs[count].answerD
                variantSelect(quizs[count].answer)
//                Log.i("asdf", quizs[count].toString())
                count++
            } else {
                countBar.cancel()
                val action =
                    QuizFragmentDirections.actionQuizFragmentToResultFragment()
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
                    variantCText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantAText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantBText.text.equals(answer)){
                    variantCText.setBackgroundColor(Color.parseColor("#DC0A27"))
                    variantBText.setBackgroundColor(Color.parseColor("#83DC0A"))
                }else if(variantDText.text.equals(answer)){
                    variantCText.setBackgroundColor(Color.parseColor("#DC0A27"))
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