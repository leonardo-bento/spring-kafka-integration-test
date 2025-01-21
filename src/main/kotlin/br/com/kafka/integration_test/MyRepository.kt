package br.com.kafka.integration_test

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository

@Repository
interface MyRepository : CrudRepository<MyEntity, String> {}
