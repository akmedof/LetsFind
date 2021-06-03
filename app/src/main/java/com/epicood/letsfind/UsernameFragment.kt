package com.epicood.letsfind

import android.app.AlertDialog
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.navigation.Navigation
import com.epicood.letsfind.model.Rating
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.fragment_username.*
import kotlinx.android.synthetic.main.username_alert.*

class UsernameFragment : Fragment() {

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


        var mDatabase = FirebaseDatabase.getInstance().reference
        val androidID = getAndroidID(requireContext())
        if (mDatabase != null) {
            btnSave.setOnClickListener {
                val username = createUsernameText.text.toString()
                mDatabase.child(androidID).setValue(Rating(username, "5000"))
                Navigation.findNavController(it).navigate(UsernameFragmentDirections.actionUsernameFragmentToBaseFragment())
                Toast.makeText(requireContext(), "Success Username: $username", Toast.LENGTH_LONG).show()
            }
        } else {
            Log.i("data", "error");
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
}