package com.epicood.letsfind.view.fragment

import android.graphics.Color
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.epicood.letsfind.util.Constants.Companion.FUTBOOL
import com.epicood.letsfind.util.Constants.Companion.IQ
import com.epicood.letsfind.R
import com.epicood.letsfind.model.Quiz
import com.epicood.letsfind.viewmodel.QuizViewModel
import kotlinx.android.synthetic.main.fragment_quiz.*


class QuizFragment : Fragment() {

    private lateinit var viewModel : QuizViewModel
    private var count = 0
    private var straightAnswer = 0
    private var incorrectAnswer = 0
    private var quizCategoryID = 0
    private var qCount = 0
    private lateinit var list: List<Quiz>
//    private lateinit var binding: FragmentQuizBinding
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

        arguments?.let {
            quizCategoryID = QuizFragmentArgs.fromBundle(it).categoriesID
            Log.i("ffff", quizCategoryID.toString())
        }

        viewModel = ViewModelProvider(this).get(QuizViewModel::class.java)
        if (quizCategoryID.equals(FUTBOOL)){
            viewModel.getFutbolQuiz()
        }else if (quizCategoryID.equals(IQ)){
            viewModel.getIQQuiz()
        }else{
            viewModel.getData()
        }

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
                    val action = QuizFragmentDirections.actionQuizFragmentToResultFragment()
                    action.straightCount = straightAnswer
                    action.incorrectCount = incorrectAnswer
                    Navigation.findNavController(view).navigate(action)
                }
                progressBar.setProgress(0)
            }
        }.start()
    }

    private fun setQuizs(quizs: List<Quiz>){
        countBar.start()
        quizCount.text = (qCount++).toString()
        btnNext.visibility = View.GONE
        qusestionText.text = quizs[count].quest
        variantAText.text = quizs[count].answerA
        variantBText.text = quizs[count].answerB
        variantCText.text = quizs[count].answerC
        variantDText.text = quizs[count].answerD
        variantSelect(quizs[count].answer)
        count++
        btnNext.setOnClickListener {
            countBar.start()
            quizCount.text = (qCount++).toString()
            if (count < quizs.size) {
                btnNext.visibility = View.GONE
                qusestionText.text = quizs[count].quest
                variantAText.text = quizs[count].answerA
                variantBText.text = quizs[count].answerB
                variantCText.text = quizs[count].answerC
                variantDText.text = quizs[count].answerD
                variantSelect(quizs[count].answer)
                count++
            } else {
                countBar.cancel()
                val action = QuizFragmentDirections.actionQuizFragmentToResultFragment()
                action.straightCount = straightAnswer
                action.incorrectCount = incorrectAnswer
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

    private fun variantSelect(answer: String){
        variantAText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.answer_btn))
        variantBText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.answer_btn))
        variantCText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.answer_btn))
        variantDText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.answer_btn))
        var i=0
        variantA.setOnClickListener {
            countBar.cancel()
            btnNext.visibility = View.VISIBLE
            if(i!=1) {
                i = 1
                if (variantAText.text.equals(answer)) {
                    variantAText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickSuccess))
                    straightAnswer++
                }else if(variantBText.text.equals(answer)){
                    variantAText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickError))
                    variantBText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickSuccess))
                    incorrectAnswer++
                }else if(variantCText.text.equals(answer)){
                    variantAText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickError))
                    variantCText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickSuccess))
                    incorrectAnswer++
                }else if(variantDText.text.equals(answer)){
                    variantAText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickError))
                    variantDText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickSuccess))
                    incorrectAnswer++
                }
            }
        }
        variantB.setOnClickListener {
            countBar.cancel()
            btnNext.visibility = View.VISIBLE
            if(i!=1) {
                i = 1
                if (variantBText.text.equals(answer)) {
                    variantBText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickSuccess))
                    straightAnswer++
                }else if(variantAText.text.equals(answer)){
                    variantBText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickError))
                    variantAText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickSuccess))
                    incorrectAnswer++
                }else if(variantCText.text.equals(answer)){
                    variantBText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickError))
                    variantCText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickSuccess))
                    incorrectAnswer++
                }else if(variantDText.text.equals(answer)){
                    variantBText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickError))
                    variantDText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickSuccess))
                    incorrectAnswer++
                }
            }
        }
        variantC.setOnClickListener {
            countBar.cancel()
            btnNext.visibility = View.VISIBLE
            if(i!=1) {
                i = 1
                if (variantCText.text.equals(answer)) {
                    variantCText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickSuccess))
                    straightAnswer++
                }else if(variantAText.text.equals(answer)){
                    variantCText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickError))
                    variantAText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickSuccess))
                    incorrectAnswer++
                }else if(variantBText.text.equals(answer)){
                    variantCText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickError))
                    variantBText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickSuccess))
                    incorrectAnswer++
                }else if(variantDText.text.equals(answer)){
                    variantCText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickError))
                    variantDText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickSuccess))
                    incorrectAnswer++
                }
            }
        }
        variantD.setOnClickListener {
            countBar.cancel()
            btnNext.visibility = View.VISIBLE
            if(i!=1) {
                i = 1
                if (variantDText.text.equals(answer)) {
                    variantDText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickSuccess))
                    straightAnswer++
                }else if(variantAText.text.equals(answer)){
                    variantDText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickError))
                    variantAText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickSuccess))
                    incorrectAnswer++
                }else if(variantCText.text.equals(answer)){
                    variantDText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickError))
                    variantCText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickSuccess))
                    incorrectAnswer++
                }else if(variantBText.text.equals(answer)){
                    variantDText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickError))
                    variantBText.setBackgroundColor(ContextCompat.getColor(requireContext(), R.color.btnClickSuccess))
                    incorrectAnswer++
                }
            }
        }
    }

    override fun onStop() {
        super.onStop()
        countBar.cancel()
    }
}