package com.max.sir.omdb.movie_details.domain

import com.max.sir.omdb.core.ResponseHandler
import javax.inject.Inject

class GetMovieDetailsUseCase @Inject constructor(
    private val repository: MovieDetailsRepository,
    private val responseHandler: ResponseHandler
) {

    suspend operator fun invoke(id: String): MovieDetailsResponseState =
        responseHandler.handle(
            block = {
                val result = repository.loadDetails(id)
                MovieDetailsResponseState.Success(result.mapToMovieDetailsUi())
            },
            failure = {_,message->
                MovieDetailsResponseState.Failure(message)
            }
        )


}