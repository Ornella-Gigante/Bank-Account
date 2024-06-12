/**
 * This class defines the entity ACCOUNT which represents the bank account inside the
 * database.
 * @Entity indicates that is a class JPA (Java Persistente API) which is  an interface that
 * interacts with relational DDBB from java apps
 * The account will have the following data form the user:
 * -ID
 * -IBAN
 * -MONEY NSIDE ACCOUNT
 *
 * There will be a REPOSITORY for the CRUD of the entities as well
 *
 */


package com.example.demo
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id



@Entity
data class BankAccount(

    @Id @GeneratedValue (strategy = GenerationType.IDENTITY)

    val id: Long?= null,   //identifier of the account
    val iban: String,      // IBAN of the account
    var balance: Double   //amount of money in the account

)


