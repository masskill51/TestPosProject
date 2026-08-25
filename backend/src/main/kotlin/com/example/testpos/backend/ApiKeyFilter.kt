package com.example.testpos.backend

import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.beans.factory.annotation.Value
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import java.security.MessageDigest

/** Protects business data while leaving the hosting health check public. */
@Component
class ApiKeyFilter(
    @Value("\${pos.api.key}") private val apiKey: String
) : OncePerRequestFilter() {

    override fun shouldNotFilter(request: HttpServletRequest): Boolean =
        request.method.equals("OPTIONS", ignoreCase = true) ||
            request.requestURI == "/api/health" ||
            request.requestURI == "/api/auth/login"

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val supplied = request.getHeader("X-API-Key")
            ?: request.getHeader("Authorization")
                ?.takeIf { it.startsWith("Bearer ", ignoreCase = true) }
                ?.substring(7)
                ?.trim()

        if (supplied != null && secureEquals(apiKey, supplied)) {
            filterChain.doFilter(request, response)
            return
        }

        response.status = HttpServletResponse.SC_UNAUTHORIZED
        response.contentType = MediaType.APPLICATION_JSON_VALUE
        response.writer.write("{\"error\":\"Missing or invalid API key\"}")
    }

    private fun secureEquals(expected: String, supplied: String): Boolean =
        MessageDigest.isEqual(
            expected.toByteArray(StandardCharsets.UTF_8),
            supplied.toByteArray(StandardCharsets.UTF_8)
        )
}
