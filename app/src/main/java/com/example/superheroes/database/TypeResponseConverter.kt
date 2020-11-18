package com.example.superheroes.database

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.superheroes.model.SuperHeroDetail
import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.Moshi
import com.squareup.moshi.Types
import javax.inject.Inject

@ProvidedTypeConverter
class TypeResponseConverter @Inject constructor(
    private val moshi: Moshi
) {

    @TypeConverter
    fun fromString(value: String): List<SuperHeroDetail.PowerStats>? {
        val listType = Types.newParameterizedType(List::class.java, SuperHeroDetail.PowerStats::class.java)
        val adapter: JsonAdapter<List<SuperHeroDetail.PowerStats>> = moshi.adapter(listType)
        return adapter.fromJson(value)
    }

    @TypeConverter
    fun fromPowerStats(type: List<SuperHeroDetail.PowerStats>?): String{
        val listType = Types.newParameterizedType(List::class.java, SuperHeroDetail.PowerStats::class.java)
        val adapter: JsonAdapter<List<SuperHeroDetail.PowerStats>> = moshi.adapter(listType)
        return adapter.toJson(type)
    }
}