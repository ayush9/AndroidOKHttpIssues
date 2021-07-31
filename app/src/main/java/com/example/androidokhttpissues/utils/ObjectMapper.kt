package com.example.androidokhttpissues.utils

import com.google.gson.Gson


object ObjectMapper {
    // this method convert json string into Java object of required Class type
    fun getObjectFromJson(jsonString: String?, resultObjectClass: Class<*>?): Any? {
        return if (resultObjectClass == null) {
            // This block will return response data as it is (whether it is in JSON or other string
            // Hence user can get raw response string, if he pass responseObjectClass as null
            jsonString
        } else try {
            val gson = Gson()
            gson.fromJson<Any>(jsonString, resultObjectClass)
        } catch (e: Exception) {
            null
        }
    }

    fun toJson(`object`: Any?): String {
        return try {
            val gson = Gson()
            gson.toJson(`object`)
        } catch (e: Exception) {
            ""
        }
    }
}

