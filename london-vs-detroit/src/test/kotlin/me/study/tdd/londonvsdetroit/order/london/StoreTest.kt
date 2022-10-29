package me.study.tdd.londonvsdetroit.order.london

import me.study.tdd.londonvsdetroit.order.Product
import me.study.tdd.londonvsdetroit.order.StoreImpl
import org.assertj.core.api.Assertions
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

private class StoreTest {

    @Test
    fun get_the_stock_of_the_product() {
        val givenProduct = Product.I_PAD
        val givenStock = (Long.MIN_VALUE..Long.MAX_VALUE).random()
        val givenProducts = hashMapOf(givenProduct to givenStock)
        val store = StoreImpl(givenProducts)

        val stock = store.getStock(givenProduct)

        assertThat(stock).isEqualTo(givenStock)
    }

    @Test
    fun decrease_the_stock_when_stock_is_enough() {
        val givenProduct = Product.I_PAD
        val givenStock = (10 .. 20L).random()
        val givenNumberOfStockReduction = (0 .. 10L).random()
        val givenProducts = hashMapOf(givenProduct to givenStock)
        val store = StoreImpl(givenProducts)

        store.decreaseStock(givenProduct, givenNumberOfStockReduction)

        assertThat(store.getStock(givenProduct)).isEqualTo(givenStock - givenNumberOfStockReduction)
    }

    @Test
    fun decrease_stock_is_failing_when_the_stock_is_not_enough() {
        val givenProduct = Product.I_PAD
        val givenStock = (0 .. 9L).random()
        val givenNumberOfStockReduction = (10 .. 20L).random()
        val givenProducts = hashMapOf(givenProduct to givenStock)
        val store = StoreImpl(givenProducts)

        Assertions.assertThatThrownBy { store.decreaseStock(givenProduct, givenNumberOfStockReduction) }
            .isInstanceOf(IllegalStateException::class.java)
    }

}
