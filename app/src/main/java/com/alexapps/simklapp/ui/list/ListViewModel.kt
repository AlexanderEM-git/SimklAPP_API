package com.alexapps.simklapp.ui.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alexapps.simklapp.server.model.Tv
import com.alexapps.simklapp.server.model.TvItem
import com.alexapps.simklapp.server.moviesrespository.TvRepository
import kotlinx.coroutines.launch

class ListViewModel : ViewModel() {

    private val tvRepository = TvRepository() //instanciamos el repositorio

    //observador de la lista de datos de peliculas
    private val _moviesLoaded : MutableLiveData<ArrayList<TvItem>> = MutableLiveData()
    val moviesLoaded: LiveData<ArrayList<TvItem>> = _moviesLoaded

    fun getTvShows() {
        viewModelScope.launch {
            val TvList : Tv = tvRepository.getBestTV() // le pedimos al repositrio las peliculas

            // cargamos la lista para enviar al fragmento
            _moviesLoaded.postValue(TvList as ArrayList<TvItem>)

        }
    }
}