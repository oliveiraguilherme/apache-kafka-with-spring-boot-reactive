package com.example.kafkaexample.consumer

import com.example.kafkaexample.payload.Student
import org.slf4j.Logger
import org.slf4j.LoggerFactory
import org.springframework.kafka.annotation.KafkaListener
import org.springframework.stereotype.Service

@Service
class KafkaConsumer(
    private val log: Logger? = LoggerFactory.getLogger(KafkaConsumer::class.java)
) {

    //@KafkaListener(topics = ["guilherme"], groupId = "myGroup")
    fun consumeMessage(msg: String){
        log?.info("Consuming the message from guilherme Topic: $msg")
    }

    @KafkaListener(topics = ["guilherme"], groupId = "myGroup")
    fun consumeJsonMessage(student: Student){
        log?.info("Consuming the message from guilherme Topic: ${student.toString()}")
    }
}