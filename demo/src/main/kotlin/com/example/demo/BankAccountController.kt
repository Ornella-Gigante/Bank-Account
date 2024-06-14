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

        bankAccountService.deposit(accountId, amount)

    }

    @PostMapping ("/bank-accounts/{accountId}/withdraw")
    fun withdraw (@PathVariable accountId:Long, @RequestParam amount: Double){

        bankAccountService.withdraw(accountId, amount)

    }

    @PostMapping ("/{accountId}/transfer")
    fun transfer (@PathVariable fromAccountId:Long, @RequestParam toAccountIban:String, @RequestParam amount: Double){

        bankAccountService.transfer(fromAccountId, toAccountIban, amount)
    }

    @GetMapping ("/{accountId}/statement")
    fun getAccountStatement (@PathVariable accountId: Long): List <Transaction>{

        return bankAccountService.getAccountStatement(accountId)

    }

}


