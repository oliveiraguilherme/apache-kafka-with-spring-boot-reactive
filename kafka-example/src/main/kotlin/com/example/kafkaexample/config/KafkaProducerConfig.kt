package com.example.kafkaexample.config

import lombok.extern.slf4j.Slf4j
import org.slf4j.LoggerFactory
import org.apache.kafka.clients.producer.ProducerConfig
import org.apache.kafka.common.serialization.StringSerializer
import org.slf4j.Logger
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.core.DefaultKafkaProducerFactory
import org.springframework.kafka.core.KafkaTemplate
import org.springframework.kafka.core.ProducerFactory
import org.springframework.stereotype.Service
import kotlin.reflect.jvm.internal.impl.load.kotlin.JvmType

@Service
class KafkaProducerConfig(

    private val kafkaTemplate: KafkaTemplate<String, String>,
    private val log: Logger? = LoggerFactory.getLogger(KafkaProducerConfig::class.java)
) {

    fun sendMessage(msg: String): String {
        log?.info(String.format("Sending message to guilherme Topic: $msg"))
        kafkaTemplate.send("guilherme", msg)
        return "olá"
    }

//    fun producerConfig(): Map<String, Any>{
//        val props = HashMap<String, Any>()
//        props[ProducerConfig.BOOTSTRAP_SERVERS_CONFIG] = bootstrapServers;
//        props[ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
//        props[ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG] = StringSerializer::class.java
//        return props
//
//    }
//
//    @Bean
//    fun producerFactory(): ProducerFactory<String, String>{
//        return DefaultKafkaProducerFactory(producerConfig())
//    }
//
//    @Bean
//    fun kafkaTemplate(
//        producerFactory: ProducerFactory<String, String>
//    ): KafkaTemplate<String, String>{
//        return KafkaTemplate(producerFactory)
//    }
}