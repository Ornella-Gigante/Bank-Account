/**
 * This class is the principal class of the app
 * It has the execution and importation of spring boot
 * This is the class that initializes the hole app in the main method
 */

package com.example.demo

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class BankAccountApplication

fun main(args: Array<String>) {
	runApplication<BankAccountApplication>(*args)
}
