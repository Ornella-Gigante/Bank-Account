/**
 * This class will have all the operations of transactions and bank accounts
 * @SERVICE makes it possible to use the methods of this class in other parts of the app
 */

package com.example.demo

import org.springframework.stereotype.Service


@Service

class BankAccountService (

    private val bankAccountRepository: BankAccountRepository,
    private val transactionRepository: TransactionRepository



)  {


    //NEED TO IMPLEMENT SOME METHODS

    //- DEPOSITAR
    //- RETIRAR DINERO
    //- TRANSFERIR
    //- VALOR TOTAL DE CUENTA


}