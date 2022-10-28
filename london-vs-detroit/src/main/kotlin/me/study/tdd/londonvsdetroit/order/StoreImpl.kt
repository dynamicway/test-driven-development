package me.study.tdd.londonvsdetroit.order

class StoreImpl(
    private val products: Map<Product, Long>
) : Store {
    override fun getStock(product: Product): Long {
        return products[product]!!
    }
}
