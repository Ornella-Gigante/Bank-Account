/**
 * This class will have all the operations of transactions and bank accounts
 * @SERVICE makes it possible to use the methods of this class in other parts of the app
 * @TRANSACTIONAL is a powerful annotation that simplifies transaction management, ensuring
 * all operations within a transaction are completed or rolled back
 *  This class will have 4 methods:
 * -deposit
 * -withdraw
 * -transfer
 * -getAcountStatement (list of transaction in descendant order)
 **/

package com.example.demo

import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import kotlin.IllegalArgumentException


@Service

class BankAccountService (

    private val bankAccountRepository: BankAccountRepository,
    private val transactionRepository: TransactionRepository



)  {

  @Transactional
  fun deposit (accountId: Long, amount:Double){

      val account = bankAccountRepository.findById(accountId)
          .orElseThrow  {IllegalArgumentException("This account doesn´t exist")}

      account.balance  +=amount
      bankAccountRepository.save(account)

      val transaction = Transaction(

          accountId= account.id!! ,
          date= LocalDateTime.now(),
          amount = amount,
          type= TransactionType.DEPOSIT
      )
      transactionRepository.save(transaction)
  }

    @Transactional
    fun withdraw (accountId: Long, amount:Double){

        val account= bankAccountRepository.findById(accountId)
            .orElseThrow{IllegalArgumentException("Insufficient")}

        if (account.balance < amount) {

            throw IllegalArgumentException ("Insufficient balance")

        }

        account.balance -=amount
        bankAccountRepository.save (account)

        val transaction= Transaction(

            accountId= account.id!!,
            date= LocalDateTime.now(),
            amount = amount,
            type= TransactionType.WITHDRAWAL

        )

        transactionRepository.save(transaction)

    }

    @Transactional
    fun transfer (fromAccountId:Long, toAccountIban:String, amount: Double){

        val fromAccount =bankAccountRepository.findById(fromAccountId)
            .orElseThrow{IllegalArgumentException("Account not found")}

        val toAccount= bankAccountRepository.findByIban(toAccountIban)
            ?: throw IllegalArgumentException ("Account not found")

        if (fromAccount.balance < amount){

            throw  IllegalArgumentException ("Insufficient balance")
        }

        fromAccount.balance -= amount
        toAccount.balance += amount

        bankAccountRepository.save(fromAccount)
        bankAccountRepository.save((toAccount))

        val fromTransaction= Transaction (

            accountId = fromAccount.id !!,
            date= LocalDateTime.now(),
            amount = -amount,
            type= TransactionType.TRANSFER

        )

        transactionRepository.save (fromTransaction)

        val toTransaction= Transaction (

            accountId =  toAccount.id !!,
            date= LocalDateTime.now(),
            amount = amount,
            type= TransactionType.TRANSFER

        )

        transactionRepository.save(toTransaction)
    }


    fun getAccountStatement (accountId: Long): List <Transaction> {

        return transactionRepository.findByAccountId(accountId)
            .sortedByDescending {it.date}

    }
}


