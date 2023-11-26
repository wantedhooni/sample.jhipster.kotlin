package com.revy.app

import com.revy.app.KotlinAppApp
import com.revy.app.config.AsyncSyncConfiguration
import com.revy.app.config.EmbeddedKafka
import com.revy.app.config.EmbeddedSQL

import org.springframework.test.annotation.DirtiesContext
import org.springframework.boot.test.context.SpringBootTest

/**
 * Base composite annotation for integration tests.
 */
@kotlin.annotation.Target(AnnotationTarget.CLASS)
@kotlin.annotation.Retention(AnnotationRetention.RUNTIME)
@SpringBootTest(classes = [KotlinAppApp::class, AsyncSyncConfiguration::class])
@EmbeddedKafka
@EmbeddedSQL
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_CLASS)
annotation class IntegrationTest {
}
