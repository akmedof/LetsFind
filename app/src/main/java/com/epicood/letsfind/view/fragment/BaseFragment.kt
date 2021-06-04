package com.epicood.letsfind.view.fragment

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.epicood.letsfind.R
import com.epicood.letsfind.getAndroidID
import com.epicood.letsfind.model.Rating
import com.epicood.letsfind.util.Constants.Companion.FUTBOOL
import com.epicood.letsfind.util.Constants.Companion.IQ
import com.epicood.letsfind.viewmodel.RatingViewModel
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_base.*
import kotlinx.coroutines.runBlocking


class BaseFragment : Fragment() {

    private lateinit var viewModel : RatingViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_base, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(RatingViewModel::class.java)
        viewModel.getData()
        androidIDCheck(view)
        generalKnowledge.setOnClickListener {
            val action = BaseFragmentDirections.actionBaseFragmentToQuizFragment()
            Navigation.findNavController(it).navigate(action)
        }
        quizFutbool.setOnClickListener {
            val action = BaseFragmentDirections.actionBaseFragmentToQuizFragment()
            action.categoriesID = FUTBOOL
            Navigation.findNavController(it).navigate(action)
        }
        iqQuiz.setOnClickListener {
            val action = BaseFragmentDirections.actionBaseFragmentToQuizFragment()
            action.categoriesID = IQ
            Navigation.findNavController(it).navigate(action)
        }
    }

    private  fun androidIDCheck(view: View){
        viewModel.ratings.observe(viewLifecycleOwner, Observer { ratings ->
            ratings?.let {
                if (it.isEmpty()) {
                    Navigation.findNavController(view)
                        .navigate(BaseFragmentDirections.actionBaseFragmentToUsernameFragment())
                }else{
                    var i = 0
                    for (rating in it) {
                        if (rating.androidID.equals(getAndroidID(requireContext()))) {
                            Log.i("eeeee", it.toString() + "asd")
                            i++
                        } else {
                            Log.i("eeeee", "error")
                        }
                        if (i == 0) {
                            Navigation.findNavController(view)
                                .navigate(BaseFragmentDirections.actionBaseFragmentToUsernameFragment())
                        }
                    }
                }

            }

        })
    }





}