package cz.kromer.mqdemo.producer.service

import cz.kromer.mqdemo.producer.dto.PersonMessage
import cz.kromer.mqdemo.producer.dto.ProductMessage
import org.slf4j.LoggerFactory.getLogger
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.LocalDate

@Service
class ProducerService(
    private val rabbitTemplate: RabbitTemplate,
    private val queue: Queue
) {

    private val log = getLogger(javaClass)

    @Scheduled(fixedDelayString = "\${app.scheduling.produce-messages.fixed-delay}")
    fun produceMessages() {
        log.info("Sending product message.")
        rabbitTemplate.convertAndSend(queue.name, ProductMessage("OLED Monitor", 4))

        log.info("Sending person message.")
        rabbitTemplate.convertAndSend(queue.name, PersonMessage("John", "Doe", LocalDate.of(1990, 11, 5)))
    }
}