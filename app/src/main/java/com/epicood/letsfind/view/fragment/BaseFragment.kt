package com.epicood.letsfind.view.fragment

import android.annotation.SuppressLint
import android.app.AlertDialog
import android.os.Bundle
import android.provider.Settings
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.epicood.letsfind.R
import com.epicood.letsfind.getAndroidID
import com.epicood.letsfind.model.Rating
import com.epicood.letsfind.util.Constants.Companion.FUTBOOL
import com.epicood.letsfind.util.Constants.Companion.IQ
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_base.*
import kotlinx.android.synthetic.main.username_alert.*


class BaseFragment : Fragment() {

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


//        var mDatabase = FirebaseDatabase.getInstance().reference
//        if (mDatabase != null) {
//            usernameAlert()
//            btnAlert.setOnClickListener {
//                val androidID = getAndroidID(it.context)
//                val rating = Rating("usernameFB".toString(), "0")
//                mDatabase.child(getAndroidID(it.context)).setValue(Rating("Aslanm", "1000"))
//            }
//        } else {
//            Log.i("data", "error");
//        }

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

    fun usernameAlert(){
        val view = View.inflate(requireContext(), R.layout.username_alert, null)
        val builder = AlertDialog.Builder(requireContext())
        builder.setView(view)
        val dialog = builder.create()
        dialog.show()
        dialog.window?.setBackgroundDrawableResource(R.color.background)
    }



//    fun firebase(){
//        usernameAlert()
//        btnAlert.setOnClickListener {
//            val usernameFB = usernameText.text
//            val androidID = getAndroidID(requireContext())
//            val rating = Rating("usernameFB".toString(), "0")
//            mDatabase?.child(androidID)?.setValue(rating)
//        }
//    }


}