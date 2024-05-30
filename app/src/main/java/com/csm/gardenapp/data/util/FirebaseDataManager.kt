package com.csm.gardenapp.data.util

import com.google.firebase.database.DataSnapshot
import com.google.firebase.database.DatabaseError
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.ValueEventListener
import kotlin.coroutines.resume
import kotlin.coroutines.resumeWithException
import kotlin.coroutines.suspendCoroutine

suspend fun DatabaseReference.getDataOnce() = suspendCoroutine {continuation ->
    addListenerForSingleValueEvent(object : ValueEventListener {
        override fun onDataChange(snapshot: DataSnapshot) {
            continuation.resume(snapshot)
        }

        override fun onCancelled(error: DatabaseError) {
            continuation.resumeWithException(error.toException())
        }
    })
}