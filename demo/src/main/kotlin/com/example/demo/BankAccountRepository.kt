/**
 * This is an interface that  makes inheritance of the methods for JpaREPOSITORY
 * Which permits CRUD to be done on BankAccount
 * findByIban: method to find accounts with the IBAN
 *
 */


package com.example.demo
import org.springframework.data.jpa.repository.JpaRepository


//Implementation of repository for the bank account

interface BankAccountRepository: JpaRepository <BankAccount, Long> {


    fun findByIban (iban: String): BankAccount?

}