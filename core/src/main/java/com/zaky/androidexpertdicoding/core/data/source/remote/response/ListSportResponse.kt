package com.zaky.androidexpertdicoding.core.data.source.remote.response

import com.google.gson.annotations.SerializedName

data class ListSportResponse(
    @field:SerializedName("teams")
    val teams: List<SportResponse>
)