package com.example.data.database.converters

import androidx.room.TypeConverter
import com.example.data.database.entity.TitleEntity
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import java.util.*


class TitleConverter {
    var gson = Gson()

    @TypeConverter
    fun stringToSomeObjectList(data: String?): List<TitleEntity> {
        if (data == null) {
            return Collections.emptyList()
        }

        val listType = object : TypeToken<List<TitleEntity>>() {

        }.type

        return gson.fromJson<List<TitleEntity>>(data, listType)
    }

    @TypeConverter
    fun someObjectListToString(someObjects: List<TitleEntity>): String {
        return gson.toJson(someObjects)
    }
}