package com.lsttsl.filetv


data class MovieItem(

    var id : Long = 0,
    var title : String? = null,
    var desctiption : String? = null,
    var backgroundImageUrl : String? = null,
    var cardImageUrl: String? = null,
    var videoUrl : String? = null,
    var studio: String? = null
)
