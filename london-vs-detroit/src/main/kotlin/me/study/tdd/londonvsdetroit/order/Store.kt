package me.study.tdd.londonvsdetroit.order

interface Store {
    fun getStock(product: Product): Long

    fun decreaseStock(product: Product, stock: Long)
}
