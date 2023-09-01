package com.example.thirdmonthless_7

import androidx.recyclerview.widget.RecyclerView

import android.view.LayoutInflater
import android.view.ViewGroup

class RmAdapter {
    class RmAdapter(val RmList: List<RM>, val onClick: (rm: RM) -> Unit) :
        RecyclerView.Adapter<RmAdapter.RmViewHolder>() {

        inner class RmViewHolder(private val binding: ItemListBinding) :
            RecyclerView.ViewHolder(binding.root) {
            fun bind() {
                val item = RmList[adapterPosition]

                binding.apply {
                    tvLife.text = item.life
                    tvName.text = item.name
                    imgPicture.setImageResource(item.picture)
                }
                itemView.setOnClickListener {
                    onClick.invoke(item)
                }

            }

        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RmViewHolder {
            return RmViewHolder(
                ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            )
        }

        override fun onBindViewHolder(holder: RmViewHolder, position: Int) {
            holder.bind()
        }

        override fun getItemCount(): Int {
            return RmList.size
        }
    }
}