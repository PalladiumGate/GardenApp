package com.csm.gardenapp.data.util

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.database.FirebaseDatabase

val AUTH = FirebaseAuth.getInstance()
val DB = FirebaseDatabase.getInstance().reference