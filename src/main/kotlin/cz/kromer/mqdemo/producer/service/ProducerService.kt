package cz.kromer.mqdemo.producer.service

import cz.kromer.mqdemo.producer.dto.DemoMessage
import org.slf4j.LoggerFactory.getLogger
import org.springframework.amqp.core.Queue
import org.springframework.amqp.rabbit.core.RabbitTemplate
import org.springframework.scheduling.annotation.Scheduled
import org.springframework.stereotype.Service
import java.time.Clock
import java.time.Instant.now

@Service
class ProducerService(
    private val clock: Clock,
    private val rabbitTemplate: RabbitTemplate,
    private val queue: Queue
) {

    private val log = getLogger(javaClass)

    @Scheduled(fixedDelayString = "\${app.scheduling.produce-message.fixed-delay}")
    fun produceMessage() {
        log.info("Sending message.")
        rabbitTemplate.convertAndSend(queue.name, DemoMessage("Hello world!", now(clock)))
    }
}