package com.csm.gardenapp.domain.model

import android.os.Parcelable
import com.csm.gardenapp.data.util.CHILD_DATE_CREATED
import com.csm.gardenapp.data.util.CHILD_NAME
import com.csm.gardenapp.data.util.CHILD_TEXT
import kotlinx.parcelize.Parcelize

@Parcelize
data class Note (
    var id: String,
    var name: String,
    var dateCreated: String,
    var text: String
) : Parcelable {
    fun getAsMap() : Map<String, String> {
        return mapOf(
            CHILD_NAME to name,
            CHILD_DATE_CREATED to dateCreated,
            CHILD_TEXT to text
        )
    }
}