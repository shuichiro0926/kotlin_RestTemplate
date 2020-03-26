package com.example.demo.api_call

import org.springframework.context.annotation.Bean
import org.springframework.http.HttpEntity
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpMethod
import org.springframework.http.ResponseEntity
import org.springframework.stereotype.Service
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper

/**
 * 外部API リクエスト.
 *
 * @author suzuki
 */
@Service
class ApiCall {

    companion object {
        const val contentType = "Content-Type"
        const val contentTypeValue = "application/json"
    }

    @Bean
    fun restTemplate(): RestTemplate {
        return RestTemplate()
    }

    /**
     * 外部API リクエスト.
     */
    fun exchange(builder: UriComponentsBuilder, httpMethod: HttpMethod, entity: HttpEntity<Any>): String? {
        val response: ResponseEntity<String> = restTemplate().exchange(
                builder.toUriString(),
                httpMethod,
                entity,
                String::class.java
        )
        return response.body
    }

    /**
     * Sample Api Call method
     */
    fun doApiCall(): SampleDto {
        // URI作成
        val builder: UriComponentsBuilder = UriComponentsBuilder
                .fromHttpUrl("")
                .queryParam("", 1)

        // HttpHeader
        val headers: HttpHeaders = HttpHeaders()
        headers.set(contentType, contentTypeValue)
        val entity: HttpEntity<Any> = HttpEntity(headers)

        // call
        val response: String? = exchange(builder, HttpMethod.GET, entity)

        // Json → Object 変換
        return jacksonObjectMapper().readValue(response, SampleDto::class.java)
    }

}