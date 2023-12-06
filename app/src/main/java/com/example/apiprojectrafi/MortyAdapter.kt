package com.example.apiprojectrafi

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class MortyAdapter(val dataMorty: List<ResultsItem?>?) : RecyclerView.Adapter<MortyAdapter.MyViewHolder>(){
    class MyViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val imgMorty = view.findViewById<ImageView>(R.id.img_card)
        val nameMorty = view.findViewById<TextView>(R.id.item_name_morty)
        val statusMorty = view.findViewById<TextView>(R.id.descMorty)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_row_morty, parent, false)
        return MyViewHolder(view)

    }

    override fun getItemCount(): Int {
        if (dataMorty != null){
            return dataMorty.size
        }
        return 0
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.nameMorty.text = dataMorty?.get(position)?.name
        holder.statusMorty.text = dataMorty?.get(position)?.species
        Glide.with(holder.imgMorty).load(dataMorty?.get(position)?.image).error(R.drawable.ic_launcher_background)
            .into(holder.imgMorty)

        holder.itemView.setOnClickListener{
            val nama = dataMorty?.get(position)?.name
            Toast.makeText(holder.itemView.context, "${nama}", Toast.LENGTH_SHORT).show()
        }



    }
}