package tech.zemn.mobile.playlist

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.runtime.Composable
import tech.zemn.mobile.data.music.Song
import tech.zemn.mobile.home.AllSongs

@Composable
fun PlaylistContent(
    paddingValues: PaddingValues,
    songs: List<Song>,
    songsListState: LazyListState,
    onSongClicked: (Song) -> Unit
) {
    AllSongs(
        songs = songs,
        onSongClicked = onSongClicked,
        paddingValues = paddingValues,
        listState = songsListState,
    )
}