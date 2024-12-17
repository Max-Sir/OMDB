package com.max.sir.omdb.movie_details.domain

import com.max.sir.omdb.movie_details.presentation.MovieDetailsItemUi

sealed interface MovieDetailsResponseState {


    data class Failure(
         val message: String
    ): MovieDetailsResponseState

    data class Success(
         val data: MovieDetailsItemUi
    ): MovieDetailsResponseState

}