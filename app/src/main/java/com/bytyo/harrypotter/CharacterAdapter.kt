package com.bytyo.harrypotter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bytyo.harrypotter.model.Characters


class CharacterAdapter (val character: List<Characters>) : RecyclerView.Adapter<CharacterAdapter.CharacterViewHolder>() {

    class CharacterViewHolder(val v: View) : RecyclerView.ViewHolder(v) {
        val fullname: TextView = v.findViewById(R.id.tv_fullname)
        val nickname: TextView = v.findViewById(R.id.tv_nickname)
        val houses: TextView = v.findViewById(R.id.tv_houses)
        val interpretedby: TextView = v.findViewById(R.id.tv_interpretedby)
        val children: TextView = v.findViewById(R.id.tv_children)
        val birthdate: TextView = v.findViewById(R.id.tv_birthdate)
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): CharacterViewHolder {
        val layout = LayoutInflater.from(parent.context).inflate(R.layout.style_character,
            parent, false)
        return CharacterViewHolder(layout)
    }

    override fun onBindViewHolder(holder: CharacterViewHolder, position: Int) {
        val data = character[position]

        holder.fullname.text = data.fullName
        holder.nickname.text = data.nickname
        holder.houses.text = data.hogwartsHouse
        holder.interpretedby.text = data.interpretedBy
        holder.children.text = data.children.toString()
        holder.birthdate.text = data.birthdate
    }

    override fun getItemCount(): Int {
        return character.size
    }
}
