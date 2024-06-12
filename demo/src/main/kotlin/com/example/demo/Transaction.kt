/**
 * This class represents s TRANSACTION ENTITY from the bank account
 * Contains this information: id- account associated to ID, date, amount and type of transaction.
 * The class Transaction it's marked with @Entity because it can be added permanently to the database
 * There are also 3 types of transaction: DEPOSIT- WITHDRAWAL-TRANSFER
 *
 */

package com.example.demo
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import java.time.LocalDateTime


@Entity

data class Transaction (

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)
    val id:Long? = null, //can be null
    val accountId:Long,
    val date: LocalDateTime,
    val amount: Double,
    val type: TransactionType

)

//Types of transaction

enum class TransactionType {

    DEPOSIT,
    WITHDRAWAL,
    TRANSFER

}