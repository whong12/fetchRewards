package com.example.fetchrewards.ui.theme.fetchHireeScreen

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import com.example.fetchrewards.R
import com.example.fetchrewards.data.api.model.Hiree

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun FetchHiringScreen(
    modifier: Modifier,
    hireeList: List<Hiree>,
    onHireeClick: (Hiree) -> Unit,
    selectedId: Long
) {
    Column(
        modifier = modifier
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn {
            stickyHeader {
                HireeItem(
                    modifier = Modifier,
                    id = stringResource(id = R.string.id),
                    listId = stringResource(id = R.string.list_id),
                    name = stringResource(id = R.string.name),
                    onHireeClick = {}
                )
            }
            items(hireeList){ hiree ->
                HireeItem(
                    modifier = Modifier
                        .background(color = if(selectedId == hiree.id) Color.LightGray else Color.White),
                    id = hiree.id.toString(),
                    listId = hiree.listId.toString(),
                    name = hiree.name.toString(),
                    onHireeClick = { onHireeClick.invoke(hiree) },
                )
            }
        }
    }
}