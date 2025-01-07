package cz.kromer.mqdemo.producer.service

import cz.kromer.mqdemo.dto.PersonMessage
import cz.kromer.mqdemo.dto.ProductMessage
import org.junit.jupiter.api.Test
import org.mockito.kotlin.then
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.beans.factory.annotation.Value
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.bean.override.mockito.MockitoBean
import java.time.LocalDate

@SpringBootTest
@ActiveProfiles("test")
class ProducerServiceTest @Autowired constructor(

    @Value("\${app.messaging.queue-name}")
    val queueName: String,

    val producerService: ProducerService,
) {

    @MockitoBean
    lateinit var rabbitTemplate: RabbitTemplate

    @Test
    fun `should send messages when service method called`() {
        producerService.produceMessages()

        then(rabbitTemplate)
            .should()
            .convertAndSend(queueName, ProductMessage("OLED Monitor", 4))

        then(rabbitTemplate)
            .should()
            .convertAndSend(queueName, PersonMessage("John", "Doe", LocalDate.of(1990, 11, 5)))
    }
}