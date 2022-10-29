package me.study.tdd.londonvsdetroit.order.detroit

import me.study.tdd.londonvsdetroit.order.OrderImpl
import me.study.tdd.londonvsdetroit.order.Product
import me.study.tdd.londonvsdetroit.order.StoreImpl
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test

private class OrderTest {

    @Test
    fun order_succeeds_then_decreases_the_store_stock() {
        val givenProduct = Product.I_PAD
        val givenStock = (10..20L).random()
        val givenAmountOfOrder = (0..10L).random()
        val givenProducts = hashMapOf(givenProduct to givenStock)
        val givenStore = StoreImpl(givenProducts)
        val order = OrderImpl(givenStore, givenProduct, givenAmountOfOrder)

        order.order()

        val decreasedStockByOrdered = givenStock - givenAmountOfOrder
        assertThat(givenStore.getStock(givenProduct)).isEqualTo(decreasedStockByOrdered)
    }

    @Test
    fun order_fails_when_the_store_had_not_enough_stock() {
        val givenProduct = Product.I_PAD
        val givenStock = (0..9L).random()
        val givenAmountOfOrder = (10..20L).random()
        val givenProducts = hashMapOf(givenProduct to givenStock)
        val givenStore = StoreImpl(givenProducts)
        val order = OrderImpl(givenStore, givenProduct, givenAmountOfOrder)

        catchThrowable { order.order() }

        assertThat(givenStore.getStock(givenProduct)).isEqualTo(givenStock)
    }

}
