package com.dineshprabha.notes.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.findNavController
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.dineshprabha.notes.databinding.NoteLayoutBinding
import com.dineshprabha.notes.fragments.HomeFragmentDirections
import com.dineshprabha.notes.model.Notes

class NoteAdapter : RecyclerView.Adapter<NoteAdapter.NoteViewHolder>()  {

    class NoteViewHolder(val binding: NoteLayoutBinding) : RecyclerView.ViewHolder(binding.root) {
    }

    private val differCallback = object : DiffUtil.ItemCallback<Notes>(){
        override fun areItemsTheSame(oldItem: Notes, newItem: Notes): Boolean {
            return oldItem.id == newItem.id &&
                    oldItem.title == newItem.title &&
                    oldItem.description == newItem.description
        }

        override fun areContentsTheSame(oldItem: Notes, newItem: Notes): Boolean {
            return oldItem == newItem
        }

    }

    val differ = AsyncListDiffer(this, differCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NoteViewHolder {
        return NoteViewHolder(
            NoteLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        )
    }

    override fun getItemCount(): Int {
        return differ.currentList.size
    }

    override fun onBindViewHolder(holder: NoteViewHolder, position: Int) {
        val note = differ.currentList[position]
        holder.binding.noteTitle.text = note.title
        holder.binding.noteDesc.text = note.description

        holder.itemView.setOnClickListener {
            val direction = HomeFragmentDirections.actionHomeFragmentToEditNoteFragment(note)
            it.findNavController().navigate(direction)
        }
    }

}