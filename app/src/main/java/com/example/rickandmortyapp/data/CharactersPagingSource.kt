package com.example.rickandmortyapp.data

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.example.rickandmortyapp.domain.model.CharacterDetail
import com.example.rickandmortyapp.domain.use_case.GetCharactersUseCase

class CharactersPagingSource(
    private val getCharactersUseCase: GetCharactersUseCase
) : PagingSource<Int, CharacterDetail>() {

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, CharacterDetail> {
        val pageNumber = params.key ?: 1
        val previousKey = if (pageNumber == 1) null else pageNumber - 1

        try {
            val result = getCharactersUseCase.executeGetCharacters(pageNumber)
            return LoadResult.Page(
                data = result.characters,
                prevKey = previousKey,
                nextKey = getPageIndexFromNext(result.nextPage)
            )
        } catch (e: Exception) {
            throw e
        }
    }

    override fun getRefreshKey(state: PagingState<Int, CharacterDetail>): Int? {
        return state.anchorPosition?.let {
            val anchorPage = state.closestPageToPosition(it)
            anchorPage?.prevKey?.plus(1) ?: anchorPage?.nextKey?.minus(1)
        }
    }


    private fun getPageIndexFromNext(next: String?): Int? {
        return next?.split("?page=")?.get(1)?.toInt()
    }

}