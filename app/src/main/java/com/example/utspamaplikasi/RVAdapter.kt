package com.example.utspamaplikasi

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView

class RVAdapter (
    private val context : Context,
    private val  dataList : ArrayList<ResponseModel>
): RecyclerView.Adapter<RVAdapter.MyViewHolder>(){

    class MyViewHolder(val view: View): RecyclerView.ViewHolder(view){
        val tvnama = view.findViewById<TextView>(R.id.tv_nama)
        val tvemail = view.findViewById<TextView>(R.id.tv_email)
        val cvMain = view.findViewById<CardView>(R.id.cv_main)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val itemView = layoutInflater.inflate(R.layout.item_produk, parent, false)
        return MyViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.tvnama.text = dataList.get(position).nama
        holder.tvemail.text = dataList.get(position).email
        holder.cvMain.setOnClickListener {
            Toast.makeText(context, " " + dataList.get(position).nama, Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int = dataList.size

    fun setData(data :ArrayList<ResponseModel>){
        dataList.clear()
        dataList.addAll(data)
        notifyDataSetChanged()

    }
}