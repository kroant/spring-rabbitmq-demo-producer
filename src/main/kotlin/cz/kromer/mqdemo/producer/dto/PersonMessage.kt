package cz.kromer.mqdemo.producer.dto

import com.fasterxml.jackson.annotation.JsonFormat
import java.time.LocalDate

data class PersonMessage(

    val firstName: String,

    val surname: String,

    @JsonFormat(pattern = "yyyy-MM-dd")
    val birthDate: LocalDate
)
