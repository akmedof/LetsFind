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
        viewModel.getAllAndroidID()
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
        var id = getAndroidID(requireContext())
        viewModel.androidIDList.observe(viewLifecycleOwner, Observer { andID ->
            andID?.let {
                if (it.isNotEmpty()){
                    var i = 0
                    andID.forEach {
                        if (it.equals(id)){
//                        Log.i("ssss", "success " + it + " - " +  id)
                            i++
                        }else{
//                        Log.i("ssss", "error")
//                        Log.i("ssss", "error " + it + " - " +  id)
                        }
                    }
                    if (i == 0){
                        Navigation.findNavController(view).navigate(
                            BaseFragmentDirections.actionBaseFragmentToUsernameFragment())
                    }
                }else{
                    Navigation.findNavController(view).navigate(
                        BaseFragmentDirections.actionBaseFragmentToUsernameFragment())
                }
            }

        })
    }







}