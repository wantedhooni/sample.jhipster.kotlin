package com.revy.app.security

import com.revy.app.config.SYSTEM_ACCOUNT

import java.util.Optional

import org.springframework.data.domain.AuditorAware
import org.springframework.stereotype.Component

/**
 * Implementation of [AuditorAware] based on Spring Security.
 */
@Component
class SpringSecurityAuditorAware : AuditorAware<String> {
    override fun getCurrentAuditor(): Optional<String> = Optional.of(getCurrentUserLogin().orElse(SYSTEM_ACCOUNT))
}
