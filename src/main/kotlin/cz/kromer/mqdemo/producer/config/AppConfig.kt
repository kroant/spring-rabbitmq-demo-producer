package cz.kromer.mqdemo.producer.config

import org.springframework.amqp.core.Queue
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.scheduling.annotation.EnableScheduling

@Configuration
@EnableScheduling
class AppConfig {

    @Bean
    fun queue() = Queue("demoQueue", false)

    @Bean
    fun jackson2JsonMessageConverter() = Jackson2JsonMessageConverter()
}