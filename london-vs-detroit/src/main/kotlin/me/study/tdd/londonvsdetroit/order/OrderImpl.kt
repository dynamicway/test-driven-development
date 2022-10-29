package me.study.tdd.londonvsdetroit.order

class OrderImpl(
    private val store: Store,
    private val product: Product,
    private val stock: Long
) : Order {
    override fun order() {
        store.decreaseStock(product, stock)
    }
}
