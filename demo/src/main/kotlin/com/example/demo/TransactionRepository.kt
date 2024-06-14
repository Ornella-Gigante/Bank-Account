
/**
 * This is an interface that  makes inheritance of the methods for JpaREPOSITORY
 * Which permits CRUD to be done on Transaction
 * The method findByAccountId looks for transactions by ID
 * The method findByDateBetweenAndTypeIn looks for transactions between a range of time
 *
 */

package com.example.demo

import org.springframework.data.domain.Page
import org.springframework.data.domain.Pageable
import org.springframework.data.jpa.repository.JpaRepository
import java.time.LocalDateTime



interface TransactionRepository: JpaRepository <Transaction,Long> {

    fun findByAccountId (accountId: Long):List<Transaction>
    fun findByAccountId (accountId: Long, pageable: Pageable):Page<Transaction>
    fun findByDateBetweenAndTypeIn (

        from: LocalDateTime,
        to: LocalDateTime,
        types: List<TransactionType>,
        pageable: Pageable

    ): Page <Transaction>


}


