package tech.zemn.mobile.home

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutLinearInEasing
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.MoreVert
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import kotlinx.coroutines.launch
import tech.zemn.mobile.data.music.Song

@Composable
fun AllSongs(
    songs: List<Song>,
    onSongClicked: (Song) -> Unit,
    paddingValues: PaddingValues,
    listState: LazyListState,
    onFavouriteClicked: (Song) -> Unit
) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(bottom = paddingValues.calculateBottomPadding()),
        state = listState
    ) {
        items(songs) { song ->
            SongCard(
                song = song,
                onSongClicked = onSongClicked,
                onFavouriteClicked = {
                    onFavouriteClicked(song)
                }
            )
        }
    }
}

@Composable
fun SongCard(
    song: Song,
    onSongClicked: (Song) -> Unit,
    onFavouriteClicked: () -> Unit,
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(85.dp)
            .clickable(
                onClick = {
                    onSongClicked(song)
                }
            ),
        contentAlignment = Alignment.BottomCenter
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth(0.8f)
                    .fillMaxHeight()
                    .padding(start = 20.dp),
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = song.title,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    maxLines = 1,
                    modifier = Modifier.fillMaxWidth(),
                )
                Text(
                    text = "${song.artist}  •  ${song.durationFormatted}",
                    maxLines = 1,
                    fontSize = 14.sp,
                    modifier = Modifier.fillMaxWidth(),
                )
            }
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .fillMaxHeight(),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically,
            ) {
                val scope = rememberCoroutineScope()
                val favouriteButtonScale = remember { Animatable(1f) }
                Icon(
                    imageVector = if (song.favourite) Icons.Filled.Favorite else Icons.Outlined.FavoriteBorder,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .scale(favouriteButtonScale.value)
                        .clickable(
                            onClick = {
                                onFavouriteClicked()
                                scope.launch {
                                    favouriteButtonScale.animateTo(
                                        targetValue = 1.2f,
                                        animationSpec = tween(
                                            durationMillis = 300,
                                            easing = FastOutLinearInEasing,
                                        )
                                    )
                                    favouriteButtonScale.animateTo(
                                        targetValue = 0.8f,
                                        animationSpec = tween(
                                            durationMillis = 200,
                                            easing = LinearEasing,
                                        )
                                    )
                                    favouriteButtonScale.animateTo(
                                        targetValue = 1f,
                                        animationSpec = tween(
                                            durationMillis = 100,
                                            easing = FastOutLinearInEasing,
                                        )
                                    )
                                }
                            },
                            indication = rememberRipple(
                                bounded = false,
                                radius = 20.dp
                            ),
                            interactionSource = MutableInteractionSource()
                        )
                        .padding(8.dp),
                    tint = if (song.favourite) Color.Red else Color.Black,
                )
                Icon(
                    imageVector = Icons.Outlined.MoreVert,
                    contentDescription = null,
                    modifier = Modifier
                        .size(40.dp)
                        .clickable(
                            onClick = {

                            },
                            indication = rememberRipple(
                                bounded = false,
                                radius = 20.dp
                            ),
                            interactionSource = MutableInteractionSource()
                        )
                        .padding(8.dp)
                )
            }
        }
        Spacer(
            modifier = Modifier
                .padding(horizontal = 20.dp)
                .fillMaxWidth()
                .height(0.8.dp)
                .background(color = Color.Black.copy(alpha = 0.1f))
        )
    }
}