package com.example.myapplication

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentFrgABinding
import com.example.myapplication.databinding.FragmentFrgBBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class frgB : Fragment() {

    //VINCULACION
    lateinit var layout: FragmentFrgBBinding
    private val binding get() = layout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_frg_b, container, false)

        layout= FragmentFrgBBinding.inflate(inflater,container,false)

        val db = Firebase.firestore

        val guardar=layout.btnSave
        val publicacion=layout.etxtPost

        guardar.setOnClickListener {

            val _publicacion= hashMapOf("publicacion" to publicacion.text.toString())

            db.collection("post")
                .add(_publicacion)
                .addOnSuccessListener { documentReference ->
                    Log.i("result", "DocumentSnapshot added with ID: ${documentReference.id}")

                    MaterialAlertDialogBuilder(requireContext())
                        .setTitle("Publicacion realizada")
                        .setMessage("...........")
                        .setPositiveButton("ok"){d,w->

                        }.show()

                    publicacion.text.clear()
                }

        }

        return layout.root

    }

}