package com.gamdestroyerr.roomnote.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.gamdestroyerr.roomnote.R
import com.gamdestroyerr.roomnote.model.Note
import com.gamdestroyerr.roomnote.ui.fragments.NoteFragmentDirections
import com.google.android.material.textview.MaterialTextView
import kotlinx.android.synthetic.main.note_item_layout.view.*


class RvNotesAdapter : androidx.recyclerview.widget.ListAdapter<Note, RvNotesAdapter.NotesViewHolder>(DiffUtilCallback()){


    inner class NotesViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var title: MaterialTextView = itemView.noteItemTitle
        var content: MaterialTextView = itemView.noteContentItemTitle
        var date: MaterialTextView = itemView.noteDate
        var noteContainer: ConstraintLayout = itemView.noteItemContainer
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NotesViewHolder {
        return NotesViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.note_item_layout, parent, false)
        )
    }

    override fun onBindViewHolder(holder: NotesViewHolder, position: Int) {

        getItem(position).let { note ->
//            holder.itemView.animation =
//                AnimationUtils.loadAnimation(holder.itemView.context, R.anim.fade_scale)
            holder.title.text = note.title
            holder.content.text = note.content
            holder.date.text = note.date
            holder.itemView.setOnClickListener {
                val action = NoteFragmentDirections.actionNoteFragmentToNoteContentFragment()
                    .setNote(note)
                Navigation.findNavController(it).navigate(action)
            }
        }
    }

}

