package me.study.tdd.londonvsdetroit.order

class StoreImpl(
    private val products: MutableMap<Product, Long>
) : Store {
    override fun getStock(product: Product): Long {
        return products[product]!!
    }

    override fun decreaseStock(product: Product, stock: Long) {
        val decreasedStock = getDecreasedStock(product, stock)
        verifyNegativeStock(decreasedStock)
        products[product] = decreasedStock
    }

    private fun getDecreasedStock(product: Product, stock: Long) = getStock(product) - stock

    private fun verifyNegativeStock(stock: Long) {
        if (stock < 0)
            throw IllegalStateException()
    }
}
