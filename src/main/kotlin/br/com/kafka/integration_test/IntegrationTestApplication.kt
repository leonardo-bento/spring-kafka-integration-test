package br.com.kafka.integration_test

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.kafka.annotation.EnableKafka

@SpringBootApplication
@EnableKafka
class IntegrationTestApplication

fun main(args: Array<String>) {
	runApplication<IntegrationTestApplication>(*args)
}
