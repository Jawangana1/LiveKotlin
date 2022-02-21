package com.learncatfacts.app.network.models.fetchfact

import com.google.gson.annotations.SerializedName

data class FetchFactResponse(

	@field:SerializedName("fact")
	val fact: String? = null,

	@field:SerializedName("length")
	val length: Int? = null
)
