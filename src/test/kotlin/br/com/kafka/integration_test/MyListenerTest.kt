package br.com.kafka.integration_test

import jakarta.transaction.Transactional
import org.awaitility.Awaitility.await
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.repository.findByIdOrNull
import org.springframework.test.annotation.DirtiesContext
import java.util.concurrent.TimeUnit

@SpringBootTest
@DirtiesContext
class MyListenerTest {

 @Autowired
 private lateinit var producer: KafkaProducer

 @Autowired
 private lateinit var repository: MyRepository

 @Test
 @Transactional(Transactional.TxType.NOT_SUPPORTED)
 fun testEventReceived() {
  val newEntity = MyEntity("123", "")
  repository.save(newEntity)

  producer.send("mytopic", "123")

  await().atMost(10, TimeUnit.SECONDS)
   .pollInterval(2, TimeUnit.SECONDS)
   .until { !repository.findByIdOrNull("123")?.status.isNullOrEmpty() }

  val entity = repository.findByIdOrNull("123")

  assertNotNull(entity)
  assertEquals("Completed", entity?.status)
 }

}
