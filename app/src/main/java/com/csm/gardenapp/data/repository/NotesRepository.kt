package com.csm.gardenapp.data.repository

import com.csm.gardenapp.data.util.AUTH
import com.csm.gardenapp.data.util.CHILD_DATE_CREATED
import com.csm.gardenapp.data.util.CHILD_NAME
import com.csm.gardenapp.data.util.CHILD_NOTES
import com.csm.gardenapp.data.util.CHILD_TEXT
import com.csm.gardenapp.data.util.DB
import com.csm.gardenapp.data.util.NODE_USERS
import com.csm.gardenapp.data.util.getDataOnce
import com.csm.gardenapp.domain.model.Note
import com.csm.gardenapp.domain.util.Result
import java.text.SimpleDateFormat
import java.util.Date
import java.util.UUID

object NotesRepository {
    suspend fun loadNotes() : List<Note> {
        val notesSnapshot = DB.child(NODE_USERS).child(AUTH.currentUser?.uid ?: (return emptyList())).child(
            CHILD_NOTES).getDataOnce()

        if (!notesSnapshot.exists()) return emptyList()

        val notes = mutableListOf<Note>()

        notesSnapshot.children.forEach { noteSnapshot ->
            val id = noteSnapshot.key ?: ""
            val name = (noteSnapshot.child(CHILD_NAME).value ?: "").toString()
            val text = (noteSnapshot.child(CHILD_TEXT).value ?: "").toString()
            val createdAt = (noteSnapshot.child(CHILD_DATE_CREATED).value ?: "").toString()

            notes.add(Note(id, name, createdAt, text))
        }

        return notes
    }

    fun createUpdateNote(uid: String, note: Note, onFinished: (Result) -> Unit) {
        if (note.id.isEmpty()) {
            note.id = UUID.randomUUID().toString()
            val format = SimpleDateFormat("dd.MM.yyyy")
            note.dateCreated = format.format(Date())
        }

        DB.child(NODE_USERS).child(uid).child(CHILD_NOTES).child(note.id)
            .setValue(note.getAsMap()).addOnCompleteListener {
                onFinished(
                    if (it.isSuccessful)
                        Result.Success(Unit)
                    else
                        Result.Error("")
                )
            }
    }
}