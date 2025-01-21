package br.com.kafka.integration_test

import org.springframework.data.repository.findByIdOrNull
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class MyListener(
    val repository: MyRepository
) {

    @KafkaListener(topics = ["mytopic"])
    fun receive(id: String) {
        println("Event received: $id")

        val entity = repository.findByIdOrNull(id)
        entity?.let {
            it.status = "Completed"
            repository.save(it)
        } ?: println("Not Found $id")

        println("Finished $entity")
    }

}
