package me.study.tdd.londonvsdetroit.order

interface Store {
    fun getStock(product: Product): Long
}
