package cz.kromer.mqdemo.producer.service

import cz.kromer.mqdemo.dto.PersonMessage
import cz.kromer.mqdemo.dto.ProductMessage
import org.slf4j.LoggerFactory.getLogger
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ProducerService(

    @Value("\${app.messaging.queue-name}")
    private val queueName: String,

    private val rabbitTemplate: RabbitTemplate
) {

    private val log = getLogger(javaClass)

    @Scheduled(fixedDelayString = "\${app.scheduling.produce-messages.fixed-delay}")
    fun produceMessages() {
        log.info("Sending product message.")
        rabbitTemplate.convertAndSend(queueName, ProductMessage("OLED Monitor", 4))

        log.info("Sending person message.")
        rabbitTemplate.convertAndSend(queueName, PersonMessage("John", "Doe", LocalDate.of(1990, 11, 5)))
    }
}