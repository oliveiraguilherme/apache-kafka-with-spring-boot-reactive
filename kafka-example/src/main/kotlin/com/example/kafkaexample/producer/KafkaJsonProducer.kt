package com.example.kafkaexample.producer

import com.example.kafkaexample.payload.Student

import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.support.KafkaHeaders
import org.springframework.messaging.Message
import org.springframework.messaging.support.MessageBuilder
import org.springframework.stereotype.Service

@Service
class KafkaJsonProducer(
    private val kafkaTemplate: KafkaTemplate<String, String>
) {

    fun sendMessage(student: Student){
        var message: Message<Student> = MessageBuilder
            .withPayload(student)
            .setHeader(KafkaHeaders.TOPIC, "guilherme")
            .build()

        kafkaTemplate.send(message)
    }
}