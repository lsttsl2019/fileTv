package com.lsttsl.filetv.models

import android.app.SearchManager
import android.database.Cursor
import android.media.tv.TvContentRating
import android.net.Uri
import android.os.Parcelable
import android.provider.BaseColumns
import androidx.room.*
import androidx.tvprovider.media.tv.BasePreviewProgram
import androidx.tvprovider.media.tv.TvContractCompat
import kotlinx.android.parcel.Parcelize
import java.util.*


@Entity
@Parcelize
data class TvMediaMetadata(

    @PrimaryKey val id : String,

    var collectionId : String,

    var title: String,

    var artUri: Uri? = null,

    var actor : String,

    var lonMsg: String,

    var ViedoUrl: Uri? = null,

    var playBackDuationMillis: Long? = null,

    var playBackPositionMillis: Long? = null,

    var description: String?= null,

    var programType: Int = TvContractCompat.PreviewProgramColumns.TYPE_MOVIE,

    var artAspectRatio : Int = TvContractCompat.PreviewPrograms.ASPECT_RATIO_MOVIE_POSTER,

    var ratings : List<String>? = null,

    var genres: List<String>?  = null

): Parcelable {

    fun  <T: BasePreviewProgram.Builder<*>>copyToBuilder(builder: T) {

        builder.setContentId(id).setTitle(title).setType(programType)

        actor?.let { builder.setAuthor(it) }

        description?.let { builder.setDescription(it) }

        playBackDuationMillis?.let { builder.setDurationMillis(it.toInt()) }

        playBackPositionMillis?.let { builder.setLastPlaybackPositionMillis(it.toInt()) }


        artUri?.let {
            builder.setPosterArtUri(it)
            builder.setPosterArtAspectRatio(artAspectRatio)
        }

    }


    companion object {

        fun searchableText(text: String) =
            text.replace(Regex("[^A-Za-z0-9 ]"), "").toLowerCase(Locale.getDefault())
    }
}

@Dao
interface TvMediaMetadataDAO {

    @Query("SELECT " +
            "id as ${BaseColumns._ID}, " +
            "id as ${SearchManager.SUGGEST_COLUMN_INTENT_DATA_ID}, " +
            "title as ${SearchManager.SUGGEST_COLUMN_TEXT_1}, " +
            "description as ${SearchManager.SUGGEST_COLUMN_TEXT_2}, " +
            "artUri as ${SearchManager.SUGGEST_COLUMN_RESULT_CARD_IMAGE}, " +
            "year as ${SearchManager.SUGGEST_COLUMN_PRODUCTION_YEAR}, " +
            "playbackDurationMillis as ${SearchManager.SUGGEST_COLUMN_DURATION} " +
            "FROM tvmediametadata WHERE :title LIKE '%' || searchableTitle || '%'")
    fun contentProviderQuery(title: String): Cursor?

    @Query("SELECT * FROM tvmediametadata")
    fun findAll(): List<TvMediaMetadata>

    @Query("SELECT * FROM tvmediametadata WHERE id = :id LIMIT 1")
    fun findById(id: String): TvMediaMetadata?

    @Query("SELECT * FROM tvmediametadata WHERE collectionId = :collectionId")
    fun findByCollection(collectionId: String): List<TvMediaMetadata>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(vararg metadata: TvMediaMetadata)

    @Update
    fun update(metadata: TvMediaMetadata)

    @Delete
    fun delete(metadata: TvMediaMetadata)

    @Query("DELETE FROM tvmediametadata")
    fun truncate()
}





























