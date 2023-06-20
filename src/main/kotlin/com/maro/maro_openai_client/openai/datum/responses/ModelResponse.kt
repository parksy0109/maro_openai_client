package com.maro.maro_openai_client.openai.datum.responses


import com.fasterxml.jackson.annotation.JsonProperty

data class ModelResponse(
    @JsonProperty("data")
    val `data`: List<Data?>?,
    @JsonProperty("object")
    val objectX: String?
) {
    data class Data(
        @JsonProperty("created")
        val created: Int?,
        @JsonProperty("id")
        val id: String?,
        @JsonProperty("object")
        val objectX: String?,
        @JsonProperty("owned_by")
        val ownedBy: String?,
        @JsonProperty("parent")
        val parent: Any?,
        @JsonProperty("permission")
        val permission: List<Permission?>?,
        @JsonProperty("root")
        val root: String?
    ) {
        data class Permission(
            @JsonProperty("allow_create_engine")
            val allowCreateEngine: Boolean?,
            @JsonProperty("allow_fine_tuning")
            val allowFineTuning: Boolean?,
            @JsonProperty("allow_logprobs")
            val allowLogprobs: Boolean?,
            @JsonProperty("allow_sampling")
            val allowSampling: Boolean?,
            @JsonProperty("allow_search_indices")
            val allowSearchIndices: Boolean?,
            @JsonProperty("allow_view")
            val allowView: Boolean?,
            @JsonProperty("created")
            val created: Int?,
            @JsonProperty("group")
            val group: Any?,
            @JsonProperty("id")
            val id: String?,
            @JsonProperty("is_blocking")
            val isBlocking: Boolean?,
            @JsonProperty("object")
            val objectX: String?,
            @JsonProperty("organization")
            val organization: String?
        )
    }
}