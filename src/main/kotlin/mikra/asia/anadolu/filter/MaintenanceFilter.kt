package mikra.asia.anadolu.filter

import mu.KotlinLogging
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
// https://www.baeldung.com/spring-onceperrequestfilter
class MaintenanceFilter : OncePerRequestFilter() {
    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        if (shouldRedirectToMaintenancePage()) {
            response.sendRedirect("/maintenance")
        }

        filterChain.doFilter(request, response)
    }

    override fun shouldNotFilter(request: HttpServletRequest): Boolean {
        // maintenanceに直接アクセスが来た場合はFilterしない
        return if (request.requestURI == "/maintenance") {
            true
        } else super.shouldNotFilter(request)
    }

    // ここに判定式を書く
    private fun shouldRedirectToMaintenancePage(): Boolean {
        return true
    }
}