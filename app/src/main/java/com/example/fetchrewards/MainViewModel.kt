package com.example.fetchrewards

import android.util.Log
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import androidx.lifecycle.viewModelScope
import com.example.fetchrewards.data.api.model.Hiree
import com.example.fetchrewards.data.api.model.ResultOf
import com.example.fetchrewards.data.respository.FetchRepo
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "MainViewModel"
@HiltViewModel
class MainViewModel @Inject constructor(
    private val repo: FetchRepo
) : ViewModel() {
    private val _hireeList = MutableStateFlow<List<Hiree>>(listOf())
    private val _selectedId =  MutableStateFlow<Long>(-1)

    init {
        viewModelScope.launch(Dispatchers.IO) {
            repo.fetchHiringJson().collect {result ->
                when(result) {
                    is ResultOf.Success -> {
                        _hireeList.value = repo.getAllHiree().sorted().filterNot {
                            it.name.isNullOrBlank()
                        }
                        Log.d(TAG, "fetchHiringJson() success=${_hireeList.value.size}")
                    }
                    is ResultOf.Error -> {
                        Log.e(TAG, "fetchHiringJson() error=${result.message}", result.throwable)
                    }
                }
            }
        }
    }

    val state: StateFlow<FetchHiringState> = combine(
        _hireeList, _selectedId
    ) { hireeList, selectedId ->
        FetchHiringState(hireeList, selectedId)
    }.stateIn(viewModelScope, SharingStarted.Lazily, FetchHiringState())

    fun onHireeClick(hiree: Hiree) {
        _selectedId.value = hiree.id
    }
}

data class FetchHiringState(
    val hireeList: List<Hiree> = listOf(),
    val selectedId: Long = -1
)
