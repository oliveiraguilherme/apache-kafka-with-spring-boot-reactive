package com.example.kafkaexample

import org.springframework.boot.CommandLineRunner
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.context.annotation.Bean
import org.springframework.kafka.core.KafkaTemplate

@SpringBootApplication
class KafkaExampleApplication

fun main(args: Array<String>) {
	runApplication<KafkaExampleApplication>(*args)
}

@Bean
fun commandLineRunner(
	kafkaTemplate: KafkaTemplate<String, String>
): CommandLineRunner {
	return CommandLineRunner {
		println("Hello Gui, ta dando erro")
		//kafkaTemplate.send("guilherme", "hello")
	}
}
