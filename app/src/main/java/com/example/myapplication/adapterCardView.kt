package com.example.myapplication

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.databinding.FragmentFrgCBinding
import com.example.myapplication.databinding.ItemlistBinding

class adapterCardView(var item:ArrayList<PublicacionesPost>):RecyclerView.Adapter<adapterCardView.contentView>() {

    //VINCULACION
    lateinit var layout: ItemlistBinding
    private val binding get() = layout!!


    class contentView(view: ItemlistBinding):RecyclerView.ViewHolder(view.root) {

        val publicacionText:TextView

        init{
            publicacionText=view.txtPublicacion
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): adapterCardView.contentView {

        val view=ItemlistBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return contentView(view)

    }

    override fun onBindViewHolder(holder: adapterCardView.contentView, position: Int) {

        val items=item.get(position)
        holder.publicacionText.text=items.post

    }

    override fun getItemCount(): Int = item.size

}