package com.alexapps.simklapp.ui.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.alexapps.simklapp.databinding.FragmentListBinding
import com.alexapps.simklapp.server.model.TvItem

class ListFragment : Fragment() {

    private lateinit var listBinding: FragmentListBinding
    private lateinit var listViewModel: ListViewModel

    private  var moviesList: ArrayList<TvItem> = ArrayList()
    private lateinit var moviesAdapter: MoviesAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View {
        listViewModel = ViewModelProvider(this)[ListViewModel::class.java]
        listBinding = FragmentListBinding.inflate(inflater, container, false)
        val root: View = listBinding.root

        return root
    }

    // cuando se crea toda la vista
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //el adapter
        moviesAdapter = MoviesAdapter(moviesList, onItemClicked = {onMoviesItemClicked(it)})

        //vista reutilizable
        listBinding.moviesRecyclerView.apply {
            layoutManager = LinearLayoutManager(this@ListFragment.requireContext())
            adapter = moviesAdapter
            setHasFixedSize(false)
        }

        listViewModel.moviesLoaded.observe(viewLifecycleOwner){ result ->
            onMoviesLoadedSubcribe(result)
        }

        listViewModel.getTvShows()   // traigame las peliculas

    }

    private fun onMoviesItemClicked(tvItem: TvItem) { // cuando se selecciona una pelicula
        findNavController().navigate(ListFragmentDirections.actionNavigationListToDetailFragment(tvItem))
    }

    //presentamos la informacion de las peliculas
    private fun onMoviesLoadedSubcribe(showsList: ArrayList<TvItem>?) {
        showsList?.let { showsList->
            moviesAdapter.appendItems(showsList)
        }
    }
}