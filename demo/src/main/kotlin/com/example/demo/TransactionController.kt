/**
 *
 * @RestController: it will handle HTTP requests and return responses
 * @RequestMapping: Specifies the base URL for all requests handled by this controller with the route expressed
 * Constructor TransactionController: receives an instance of TRANSACTIONREPOSITORY
 *
 */
package com.example.demo
import org.springframework.web.bind.annotation.*  // import to define access to controller RES
import org.springframework.data.domain.Pageable  //pagination of query results
import java.time.LocalDateTime


@RestController
@RequestMapping ("/api/transactions")
class TransactionController (private val transactionRepository: TransactionRepository){


    @GetMapping ("/{accountId}") // handles GET REQUESTS at the URL ("/api/transactions/{accountId}")
    fun getTransactionByAccountId (
        @PathVariable accountId:Long,
        pageable: Pageable
    )= transactionRepository.findByAccountId(accountId, pageable)


    //The following method defines that
    @GetMapping ("/search") // handles GET REQUESTS at the URL ("/api/transactions/search")
    fun searchTransactions(
        @RequestParam accountId:Long,
        @RequestParam (required = false) from: LocalDateTime?,
        @RequestParam (required = false) to: LocalDateTime?,
        @RequestParam (required = false) types: List <TransactionType>?,
        pageable: Pageable
    ) = transactionRepository.findByDateBetweenAndTypeIn(

        from ?: LocalDateTime.MIN,
        to?:LocalDateTime.MAX,
        types?: listOf (TransactionType.DEPOSIT, TransactionType.WITHDRAWAL),
        pageable
    )



}
