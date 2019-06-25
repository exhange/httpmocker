/*
 * Copyright 2019 David Blanc
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package fr.speekha.httpmocker.jackson

import com.fasterxml.jackson.annotation.JsonCreator
import com.fasterxml.jackson.annotation.JsonProperty
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize

internal data class RequestDescriptor
@JsonCreator constructor(

    @JsonProperty("method")
    val method: String? = null,

    @JsonProperty("host")
    val host: String? = null,

    @JsonProperty("port")
    val port: Int? = null,

    @JsonProperty("path")
    val path: String? = null,

    @JsonProperty("headers")
    @JsonDeserialize(using = HeadersDeserializer::class)
    @JsonSerialize(using = HeadersSerializer::class)
    val headers: List<Header> = emptyList(),

    @JsonProperty("params")
    val params: Map<String, String> = emptyMap(),

    @JsonProperty("body")
    val body: String? = null

)