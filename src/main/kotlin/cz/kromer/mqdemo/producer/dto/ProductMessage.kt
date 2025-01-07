package cz.kromer.mqdemo.producer.dto

data class ProductMessage(
    val productName: String,
    val stock: Long
)
