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
            val fName = binding.FNEdit.text.toString()
            val lName = binding.LNEdit.text.toString()
            val phone: Int? = binding.PEdit.text.toString().toIntOrNull()
            val disc = binding.contentEdit.text.toString()
            if (phone != null){
                val note = Note(0,fName,lName,phone,disc)
                db.insertNote(note)
                finish()
                Toast.makeText(this,"Note Saved", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(this, "Invalid phone number", Toast.LENGTH_SHORT).show()
            }
        }
    }
}