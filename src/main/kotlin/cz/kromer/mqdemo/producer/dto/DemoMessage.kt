package cz.kromer.mqdemo.producer.dto

import java.time.Instant

data class DemoMessage(
    val text: String,
    val timestamp: Instant
)
