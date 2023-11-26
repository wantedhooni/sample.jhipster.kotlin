package com.revy.app.config

import org.springframework.boot.context.properties.ConfigurationProperties

/**
 * Properties specific to Kotlin App.
 *
 * Properties are configured in the `application.yml` file.
 * See [tech.jhipster.config.JHipsterProperties] for a good example.
 */
@ConfigurationProperties(prefix = "application", ignoreUnknownFields = false)
class ApplicationProperties {
     // jhipster-needle-application-properties-property
     // jhipster-needle-application-properties-property-getter
     // jhipster-needle-application-properties-property-class
}
