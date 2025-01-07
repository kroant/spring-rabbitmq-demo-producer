package cz.kromer.mqdemo.producer.config

import org.springframework.amqp.core.Queue
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class AppConfig(

    @Value("\${app.messaging.queue-name}")
    private val queueName: String
) {

    @Bean
    fun queue() = Queue(queueName, false)

    @Bean
    fun jackson2JsonMessageConverter() = Jackson2JsonMessageConverter()
}