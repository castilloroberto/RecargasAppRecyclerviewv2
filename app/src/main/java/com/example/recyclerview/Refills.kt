package com.example.recyclerview

import android.content.Context
import org.json.JSONException
import org.json.JSONObject




 fun getArrays(json:JSONObject,objName:String):ArrayList<Country>{
    val arrayList = ArrayList<Country>()

    try {
        val refills = json.getJSONArray(objName)
        (0 until refills.length()).mapTo(arrayList){
            Country(
                refills.getJSONObject(it).getString("name"),
                refills.getJSONObject(it).getString("code")

            )
        }
    }catch (e:JSONException){
        e.printStackTrace()
    }

    return arrayList
}
fun getRefillsArray(json:JSONObject,objName:String):ArrayList<Refill>{
    val arrayList = ArrayList<Refill>()

    try {
        val refills = json.getJSONArray(objName)
        (0 until refills.length()).mapTo(arrayList){
            Refill(
                refills.getJSONObject(it).getString("cod"),
                refills.getJSONObject(it).getString("description"),
                refills.getJSONObject(it).getString("duration"),
                refills.getJSONObject(it).getInt("price"),
                refills.getJSONObject(it).getString("title")

            )
        }
    }catch (e:JSONException){
        e.printStackTrace()
    }

    return arrayList
}



fun getJSONFromFile(fileName:String,context: Context): JSONObject{
    lateinit var jsonResult: JSONObject

    try {

        val jsonString = loadFromAssets(fileName,context)
        val json = JSONObject(jsonString)
        jsonResult = json

    }catch (e:JSONException){
        e.printStackTrace()
    }

    return jsonResult
}
fun loadFromAssets(fileName:String,context: Context):String {

    var result:String = "{\"countries\":[\"name:\"Error no se ha podido cargar los datos\"\"]}"
    try {

        val inputStream = context.assets.open(fileName)
        val size = inputStream.available()
        val buffer = ByteArray(size)
        inputStream.read(buffer)
        inputStream.close()
        result = String(buffer,Charsets.UTF_8)

    }catch (e:java.io.IOException){
        e.printStackTrace()
        return result
    }
    return result
}