package com.epicood.letsfind.view.fragment

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.epicood.letsfind.R
import com.epicood.letsfind.getAndroidID
import com.epicood.letsfind.model.Rating
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_username.*

class UsernameFragment : Fragment() {

    private lateinit var mDatabase : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_username, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        mDatabase = FirebaseDatabase.getInstance().reference


        createUsername()

    }

    private fun createUsername(){

        val androidID = getAndroidID(requireContext())
        if (mDatabase != null) {
            btnSave.setOnClickListener {
                val username = createUsernameText.text.toString()
                mDatabase.child(androidID).setValue(Rating(username, "5000"))
                Navigation.findNavController(it).navigate(UsernameFragmentDirections.actionUsernameFragmentToBaseFragment())
                Toast.makeText(requireContext(), "İstifadəçi adı yaradılıdı.", Toast.LENGTH_LONG).show()
            }
        } else {
            Log.i("data", "error");
        }
    }

    private fun usernameTextCheck(): String{
        val username = createUsernameText.text
        if (username.isEmpty()){
            Toast.makeText(requireContext(), "Alanı doldurun.", Toast.LENGTH_SHORT).show()
            usernameTextCheck()
            createUsername()
        }else if (username.length <= 3){
            Toast.makeText(requireContext(), "Error! Minimum 4 hərif olmalıdır.", Toast.LENGTH_SHORT).show()
                usernameTextCheck()
            createUsername()
        }
        return username.toString()
    }


}