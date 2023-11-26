package com.revy.app.config

import org.testcontainers.containers.JdbcDatabaseContainer
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.testcontainers.containers.MariaDBContainer
import org.testcontainers.containers.output.Slf4jLogConsumer

import java.util.Collections

class MariadbTestContainer: SqlTestContainer {

    private val log = LoggerFactory.getLogger(javaClass)

    private var mariaDBContainer: MariaDBContainer<*>? = null

    override fun destroy() {
        if (null != mariaDBContainer && mariaDBContainer?.isRunning == true) {
            mariaDBContainer?.stop()
        }
    }

    override fun afterPropertiesSet() {
        if (null == mariaDBContainer) {
            mariaDBContainer = MariaDBContainer("mariadb:10.8.3")
                .withDatabaseName("kotlin_app")
                .withTmpFs(Collections.singletonMap("/testtmpfs", "rw"))
                .withLogConsumer(Slf4jLogConsumer(log))
                .withReuse(true)
                .withConfigurationOverride("testcontainers/mariadb")
        }
        if (mariaDBContainer?.isRunning != true) {
            mariaDBContainer?.start()
        }
    }
    
    override fun getTestContainer() = mariaDBContainer as JdbcDatabaseContainer<*>
}
