package com.book.contactsavings

import android.os.Binder
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.book.contactsavings.databinding.ActivityUpdateContactBinding

class UpdateContactActivity : AppCompatActivity() {

    private lateinit var binding: ActivityUpdateContactBinding
    private lateinit var db: NotesDatabaseHelper
    private var noteId: Int = -1
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUpdateContactBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)

        noteId = intent.getIntExtra("note_id", -1)
        if (noteId == -1){
            finish()
            return
        }

        val note = db.getNoteByID(noteId)
        binding.FNUpdate.setText(note.fName)
        binding.LNUpdate.setText(note.lName)
        binding.PUpdate.setText(note.phone?.toString() ?: "")
        binding.ContentUpdate.setText(note.disc)

        binding.updateSaveButton.setOnClickListener {
            val newFName = binding.FNUpdate.text.toString()
            val newLName = binding.LNUpdate.text.toString()
            val newPhone: Int? = binding.PUpdate.text.toString().toIntOrNull()
            val newDisc = binding.ContentUpdate.text.toString()

            if (newPhone != null) {
                val updatedNote = Note(noteId, newFName, newLName, newPhone, newDisc)
                db.updateNote(updatedNote)
                finish()

                Toast.makeText(this, "Changes Saved", Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show()
            }
        }


    }
}