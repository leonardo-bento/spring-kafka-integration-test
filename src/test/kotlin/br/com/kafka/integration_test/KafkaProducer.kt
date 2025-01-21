package br.com.kafka.integration_test

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.stereotype.Component


@Component
class KafkaProducer {
    @Autowired
    private val kafkaTemplate: KafkaTemplate<String, String>? = null

    fun send(topic: String?, payload: String) {
        kafkaTemplate!!.send(topic!!, payload)
    }
}
