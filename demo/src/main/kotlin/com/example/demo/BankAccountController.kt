/**
 * A controller Rest (Representational State Transfer)
 * is a component that will make it possible to make HTTP actions
 * With this component, it is possible to exec the logic of the code and give HTTP answers7
 *
 */

//Controller for the bank account
package com.example.demo
import jdk.jfr.DataAmount
import org.springframework.web.bind.annotation.*
import org.springframework.data.domain.Pageable
import java.time.LocalDateTime


@RestController
@RequestMapping ("/api")
class ApiController(

    private val bankAccountService: BankAccountService,
    private val transactionRepository: TransactionRepository



){
    @PostMapping ("/bank-accounts/ {accountId}/deposit")
    fun deposit (@PathVariable accountId: Long, @RequestParam amount: Double){

        //Call the service to make a deposit

    }

    @PostMapping ("/bank-accounts/{accountId}/withdraw")
    fun withdraw (@PathVariable accountId:Long, @RequestParam amount: Double){

        //Call the service to do the withdraw

    }

    //HABRIA QUE PONER ESTADOS DE CUENTA , ETC
    //REVISAR
    //ETC


}


