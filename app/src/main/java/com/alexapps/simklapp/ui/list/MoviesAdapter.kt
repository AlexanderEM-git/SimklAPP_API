package com.alexapps.simklapp.ui.list

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.alexapps.simklapp.R
import com.alexapps.simklapp.databinding.CardViewItemMovieBinding
import com.alexapps.simklapp.server.model.TvItem
import com.squareup.picasso.Picasso

class MoviesAdapter (
    private val moviesList: ArrayList<TvItem>,
    private val onItemClicked: (TvItem) -> Unit
        ):RecyclerView.Adapter<MoviesAdapter.MoviesViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesViewHolder {
        val itemView = LayoutInflater.from(parent.context).inflate(R.layout.card_view_item_movie, parent, false)
        return  MoviesViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MoviesViewHolder, position: Int) {
        val movie = moviesList[position]
        holder.bindMovie(movie)
        holder.itemView.setOnClickListener{onItemClicked(moviesList[position])}
    }

    override fun getItemCount(): Int = moviesList.size

    fun appendItems(newList: ArrayList<TvItem>){ // cambiar nuevos elementos en la lista
        moviesList.clear()
        moviesList.addAll(newList)
        notifyDataSetChanged()
    }

    class MoviesViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
        private val  binding = CardViewItemMovieBinding.bind(itemView)

        fun bindMovie(tvItem: TvItem){ // pintamos las peliculas
            with(binding){
                movieTitleTextView.text = tvItem.title
                releaseDateTextView.text = tvItem.year.toString()
                voteAverageTextView.text = tvItem.ratings?.simkl?.rating.toString()
                Picasso.get().load("https://simkl.in/posters/"+ tvItem.poster+"_w.jpg").into(posterImageView)
            }
        }
    }
}