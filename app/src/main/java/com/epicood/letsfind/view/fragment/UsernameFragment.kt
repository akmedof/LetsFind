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
import com.google.firebase.database.*
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.fragment_username.*

class UsernameFragment : Fragment() {

    private lateinit var mDatabase : DatabaseReference
    private var ratings = emptyList<Rating>()

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
        usernameTextCheck()
    }

    private fun createUsername(username: String){

        val androidID = getAndroidID(requireContext())
        if (mDatabase != null) {
//            btnSave.setOnClickListener {
                usernameTextCheck()
                mDatabase.child(androidID).setValue(Rating(androidID, username, "0"))
                Toast.makeText(requireContext(), "İstifadəçi adı yaradılıdı.", Toast.LENGTH_LONG).show()
//            }
        } else {
            Log.i("data", "error");
        }
    }

    private fun usernameTextCheck(){
        btnSave.setOnClickListener {
            val username = createUsernameText.text
            if (username.isEmpty()){
                Toast.makeText(requireContext(), "Alanı doldurun.", Toast.LENGTH_SHORT).show()
            }else if (username.length < 3){
                Toast.makeText(requireContext(), "Error! Minimum 3 hərif olmalıdır.", Toast.LENGTH_SHORT).show()
            }else if (username.indexOf("~") >= 0 || username.indexOf("!") >= 0 || username.indexOf("@") >= 0
                || username.indexOf("#") >= 0 || username.indexOf("$") >= 0 || username.indexOf("%") >= 0
                || username.indexOf("^") >= 0 || username.indexOf("&") >= 0 || username.indexOf("*") >= 0
                || username.indexOf("(") >= 0 || username.indexOf(")") >= 0 || username.indexOf("_") == 0
                || username.indexOf("=") >= 0 || username.indexOf("-") >= 0 || username.indexOf("+") >= 0
                || username.indexOf("/") >= 0 || username.indexOf("|") >= 0 || username.indexOf("?") >= 0
                || username.indexOf(".") >= 0 || username.indexOf(",") >= 0 || username.indexOf("'") >= 0
                || username.indexOf("`") >= 0 || username.indexOf(":") >= 0 || username.indexOf(";") >= 0){
                Toast.makeText(requireContext(), "Error! !.,@#$%^&*()_-=+' ' işarələrdən istifadə etməyiniz.", Toast.LENGTH_SHORT).show()
            }else if (username.length > 20){
                Toast.makeText(requireContext(), "Error! Maxsimum 20 hərif olmalıdır.", Toast.LENGTH_SHORT).show()
            }else{
                createUsername(username.toString())
                Navigation.findNavController(it).navigate(UsernameFragmentDirections.actionUsernameFragmentToBaseFragment())
            }
        }
    }


}