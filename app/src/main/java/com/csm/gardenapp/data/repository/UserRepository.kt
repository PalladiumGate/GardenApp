package com.csm.gardenapp.data.repository

import com.csm.gardenapp.data.util.CHILD_EMAIL
import com.csm.gardenapp.data.util.CHILD_IMAGE_URL
import com.csm.gardenapp.data.util.CHILD_NAME
import com.csm.gardenapp.data.util.CHILD_USERNAME
import com.csm.gardenapp.data.util.DB
import com.csm.gardenapp.data.util.NODE_USERS
import com.csm.gardenapp.data.util.getDataOnce
import com.csm.gardenapp.domain.model.User
import com.csm.gardenapp.domain.util.Result

object UserRepository {
    fun createUser(uid: String, userInfo: Map<String, String>, onComplete: (Result) -> Unit) {
        DB.child(NODE_USERS).child(uid).setValue(userInfo)
            .addOnCompleteListener {
                onComplete(
                    if (it.isSuccessful) {
                        Result.Success(Unit)
                    } else {
                        Result.Error(it.exception?.message ?: "")
                    }
                )
            }
    }

    suspend fun loadUser(uid: String) : User{
        val userSnapshot = DB.child(NODE_USERS).child(uid).getDataOnce()

        if (!userSnapshot.exists())
            return User("", "")

        val username = (userSnapshot.child(CHILD_USERNAME).value ?: "").toString()
        val email = (userSnapshot.child(CHILD_EMAIL).value ?: "").toString()

        return User(username, email)
    }
}