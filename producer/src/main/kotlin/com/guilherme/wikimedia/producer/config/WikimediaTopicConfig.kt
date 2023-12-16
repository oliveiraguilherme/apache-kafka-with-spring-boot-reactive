package com.guilherme.wikimedia.producer.config

import org.apache.kafka.clients.admin.NewTopic
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.kafka.config.TopicBuilder

@Configuration
class WikimediaTopicConfig {

    @Bean
    fun wikimediaStreamTopic(): NewTopic {
        return TopicBuilder.name("wikimedia-stream").build()
    }
}