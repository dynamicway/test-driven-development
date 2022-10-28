package me.study.tdd.londonvsdetroit.order

class StoreImpl(
    private val products: MutableMap<Product, Long>
) : Store {
    override fun getStock(product: Product): Long {
        return products[product]!!
    }

    override fun decreaseStock(product: Product, stock: Long) {
        products[product] = getStock(product) - stock
    }
}
