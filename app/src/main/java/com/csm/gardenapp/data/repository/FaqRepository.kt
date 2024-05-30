package com.csm.gardenapp.data.repository

import com.csm.gardenapp.data.util.CHILD_ANSWER
import com.csm.gardenapp.data.util.CHILD_QUESTION
import com.csm.gardenapp.data.util.DB
import com.csm.gardenapp.data.util.NODE_FAQS
import com.csm.gardenapp.data.util.getDataOnce
import com.csm.gardenapp.domain.model.Faq

object FaqRepository {
    suspend fun loadFaq() : List<Faq>{
        val faqSnapshot = DB.child(NODE_FAQS).getDataOnce()
        if (!faqSnapshot.exists()) return emptyList<Faq>()

        val faqs = mutableListOf<Faq>()

        faqSnapshot.children.forEach { faq ->
            val question = (faq.child(CHILD_QUESTION).value?:"").toString()
            val answer = (faq.child(CHILD_ANSWER).value?:"").toString()

            faqs.add(Faq(question, answer))
        }

        return faqs
    }
}