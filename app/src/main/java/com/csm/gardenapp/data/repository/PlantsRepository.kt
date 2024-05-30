package com.csm.gardenapp.data.repository

import com.csm.gardenapp.data.util.CHILD_DAY_PERIOD
import com.csm.gardenapp.data.util.CHILD_DESCRIPTION
import com.csm.gardenapp.data.util.CHILD_IMAGE_URL
import com.csm.gardenapp.data.util.CHILD_MONTH
import com.csm.gardenapp.data.util.CHILD_NAME
import com.csm.gardenapp.data.util.DB
import com.csm.gardenapp.data.util.NODE_PLANTS
import com.csm.gardenapp.data.util.getDataOnce
import com.csm.gardenapp.domain.model.Plant

object PlantsRepository {
    suspend fun loadPlants() : List<Plant> {
        val plants = mutableListOf<Plant>()
        val plantsSnapshot = DB.child(NODE_PLANTS).getDataOnce()

        if (!plantsSnapshot.exists()) return emptyList()

        plantsSnapshot.children.forEach { plant ->
            val name = (plant.child(CHILD_NAME).value?:"").toString()
            val month = (plant.child(CHILD_MONTH).value?:"").toString()
            val dayPeriod = (plant.child(CHILD_DAY_PERIOD).value?:"").toString()
            val imageUrl = (plant.child(CHILD_IMAGE_URL).value?:"").toString()
            val description = (plant.child(CHILD_DESCRIPTION).value?:"").toString()

            plants += Plant(name, month, dayPeriod, imageUrl, description)
        }
        return plants
    }
}