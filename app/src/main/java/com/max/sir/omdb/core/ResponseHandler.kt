package com.max.sir.omdb.core

import com.max.sir.omdb.R
import javax.inject.Inject

class ResponseHandler @Inject constructor(
    private val managerResource: ManagerResource
) {

    suspend fun <T> handle(block: suspend () -> T, failure: (Exception, String) -> T): T {
        return try {
            block.invoke()
        } catch (e: ResponseFailedException) {
            failure.invoke(e, managerResource.getString(R.string.failed_responce))
        } catch (e: Exception) {
            failure.invoke(e, managerResource.getString(R.string.something_went_wrong))
        }
    }

}