/*
 * Copyright (C) 2017 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

package com.lsttsl.filetv

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.FragmentActivity
import org.json.JSONObject

/**
 * Loads [MainFragment].
 */
class MainActivity : FragmentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


    }

//    private fun getJsonString(){
//        val json : String? = null
//
//        try {
//            val assetManager =  resources.assets
//            var inputStream = assetManager.open("BD_MV1.json")
//            val inputString = inputStream.bufferedReader().use { it.readText() }
//
//            val jObject = JSONObject(inputString)
//            val jArray = jObject.getJSONObject("BD_MV")
//
//            Log.d("TAGss" , "  json + ${jArray.toString()}")
//
//        }catch (e : Exception){
//            e.printStackTrace()
//            Log.d("TAGss" , "dd  ${e.printStackTrace()}")
//        }
//
//
//    }
}
