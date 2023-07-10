package dev.pegasus.paging3.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import dev.pegasus.paging3.models.Result
import dev.pegasus.paging3.retrofit.RetrofitInstance.getClientApi
import retrofit2.HttpException
import java.io.IOException

/**
 * @Author: SOHAIB AHMED
 * @Date: 10,July,2023
 * @Accounts
 *      -> https://github.com/epegasus
 *      -> https://stackoverflow.com/users/20440272/sohaib-ahmed
 */

class DataPagingSource : PagingSource<Int, Result>() {
    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Result> {
        return try {
            val nextPageNumber = params.key ?: 1
            val response = getClientApi().getQuotes(nextPageNumber)
            LoadResult.Page(
                data = response.results,
                prevKey = if (nextPageNumber == 1) null else (nextPageNumber - 1),
                nextKey = if (nextPageNumber == response.totalPages) null else (nextPageNumber + 1)
            )
        } catch (ex: IOException) {
            LoadResult.Error(ex)
        } catch (ex: HttpException) {
            LoadResult.Error(ex)
        }
    }

    override fun getRefreshKey(state: PagingState<Int, Result>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }
}