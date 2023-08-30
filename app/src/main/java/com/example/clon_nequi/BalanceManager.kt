package com.example.clon_nequi

object BalanceManager {
    private var balance: Double = 10000.00
    fun getBalance(): Double{
        return balance
    }
    fun restBalance(amount: Double){
        balance -= amount
    }
    fun plusBalance(amount: Double){
        balance += amount
    }

}