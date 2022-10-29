package me.study.tdd.londonvsdetroit.order.london.testdouble

import me.study.tdd.londonvsdetroit.order.Product
import me.study.tdd.londonvsdetroit.order.Store

class SpyStore : Store {
    var decreaseStockThrows: Throwable? = null
    var decreaseStockArgumentsProduct: Product? = null
    var decreaseStockArgumentsStock: Long? = null

    override fun getStock(product: Product): Long {
        TODO("Not yet implemented")
    }

    override fun decreaseStock(product: Product, stock: Long) {
        if (decreaseStockThrows != null)
            throw decreaseStockThrows!!
        decreaseStockArgumentsProduct = product
        decreaseStockArgumentsStock = stock
    }
}
