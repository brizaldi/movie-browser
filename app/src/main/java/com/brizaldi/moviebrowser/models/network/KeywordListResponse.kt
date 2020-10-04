package com.brizaldi.moviebrowser.models.network

import com.brizaldi.moviebrowser.models.Keyword
import com.brizaldi.moviebrowser.models.NetworkResponseModel

data class KeywordListResponse(
    val id: Int,
    val keywords: List<Keyword>
) : NetworkResponseModel