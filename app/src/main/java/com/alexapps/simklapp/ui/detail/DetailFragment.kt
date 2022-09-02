package com.alexapps.simklapp.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.navArgs
import com.alexapps.simklapp.databinding.FragmentDetailBinding
import com.squareup.picasso.Picasso

class DetailFragment : Fragment() {

    private lateinit var detailViewModel: DetailViewModel
    private lateinit var detailBinding: FragmentDetailBinding

    private  val  args: DetailFragmentArgs by navArgs()

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        detailBinding = FragmentDetailBinding.inflate(inflater, container, false)
        detailViewModel = ViewModelProvider(this)[DetailViewModel::class.java]

        return detailBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val tvitem = args.tvItem
        with(detailBinding){
            movieTitleTextView.text = tvitem.title
            releaseDateTextView.text = tvitem.year.toString()
            voteAverageTextView.text = tvitem.ratings?.simkl?.rating.toString()
            Picasso.get().load("https://simkl.in/posters/"+ tvitem.poster+"_w.jpg").into(posterImageView)
        }
    }

}