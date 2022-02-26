package com.example.myapplication

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.myapplication.databinding.FragmentFrgCBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class frgC : Fragment() {

    //VINCULACION
    lateinit var layout: FragmentFrgCBinding
    private val binding get() = layout

    lateinit var lista:ArrayList<PublicacionesPost>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {
        // Inflate the layout for this fragment
        layout= FragmentFrgCBinding.inflate(inflater,container,false)

        val recycler=layout.postList
        lista= ArrayList()

        //BASE DE DATOS FIREBASE
        val db = Firebase.firestore


        /**/
        var item=""
        db.collection("post")
            .whereNotEqualTo("publicacion","")
            .get()
            .addOnSuccessListener { result ->

                Log.i("result",result.size().toString())

                for (document in result) {

                    Log.i("result",document.id)
                    Log.i("result",document.data.get("publicacion").toString())

                    item=document.data.get("publicacion").toString()

                    lista.add(PublicacionesPost("mio"))

                }

            }

        /**/



        val adapter=adapterCardView(lista)
        recycler.layoutManager=LinearLayoutManager(requireContext())
        recycler.adapter=adapter

        return layout.root

    }


}