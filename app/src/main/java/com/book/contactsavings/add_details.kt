package com.book.contactsavings

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.book.contactsavings.databinding.ActivityAddDetailsBinding

class add_details : AppCompatActivity() {

    private  lateinit var binding: ActivityAddDetailsBinding
    private lateinit var db: NotesDatabaseHelper
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddDetailsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = NotesDatabaseHelper(this)

        binding.saveButton.setOnClickListener{
            val title = binding.titleEdit.text.toString()
            val content = binding.contentEditText.text.toString()
            val note = Note(0,title,content)
            db.insertNote(note)
            finish()
            Toast.makeText(this,"Note Saved", Toast.LENGTH_SHORT).show()
        }
    }
}