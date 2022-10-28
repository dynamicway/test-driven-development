package me.study.tdd.londonvsdetroit.order.detroit

import me.study.tdd.londonvsdetroit.order.Product
import me.study.tdd.londonvsdetroit.order.StoreImpl
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class StoreTest {

    @Test
    fun get_the_stock_of_the_product() {
        val givenProduct = Product.I_PAD
        val givenStock = (Long.MIN_VALUE..Long.MAX_VALUE).random()
        val givenProducts = hashMapOf(givenProduct to givenStock)
        val store = StoreImpl(givenProducts)

        val stock = store.getStock(givenProduct)

        assertThat(stock).isEqualTo(givenStock)
    }

}
