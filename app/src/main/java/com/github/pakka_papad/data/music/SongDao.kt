package com.github.pakka_papad.data.music

import androidx.room.*
import kotlinx.coroutines.flow.Flow
import com.github.pakka_papad.Constants

@Dao
interface SongDao {

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllSongs(data: List<Song>)

    @Query("SELECT * FROM ${Constants.Tables.SONG_TABLE} ORDER BY title ASC")
    fun getAllSongs(): Flow<List<Song>>

    @Update
    suspend fun updateSong(song: Song)

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllAlbums(data: List<Album>)

    @Transaction
    @Query("SELECT * FROM ${Constants.Tables.ALBUM_TABLE} ORDER BY name ASC")
    fun getAllAlbumsWithSongs(): Flow<List<AlbumWithSongs>>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertAllArtists(data: List<Artist>)

    @Transaction
    @Query("SELECT * FROM ${Constants.Tables.ARTIST_TABLE} ORDER BY name ASC")
    fun getAllArtistsWithSongs(): Flow<List<ArtistWithSongs>>
}