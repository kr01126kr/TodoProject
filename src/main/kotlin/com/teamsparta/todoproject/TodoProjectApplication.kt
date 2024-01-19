package com.teamsparta.todoproject

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class TodoProjectApplication

fun main(args: Array<String>) {
	runApplication<TodoProjectApplication>(*args)
}
