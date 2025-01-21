package br.com.kafka.integration_test

import jakarta.persistence.Entity
import jakarta.persistence.Id

@Entity
data class MyEntity(
    @Id
    val id: String,
    var status: String
)
