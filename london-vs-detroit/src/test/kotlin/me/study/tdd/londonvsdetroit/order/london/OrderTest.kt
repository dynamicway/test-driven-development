package me.study.tdd.londonvsdetroit.order.london

import me.study.tdd.londonvsdetroit.order.OrderImpl
import me.study.tdd.londonvsdetroit.order.Product
import me.study.tdd.londonvsdetroit.order.StoreImpl
import me.study.tdd.londonvsdetroit.order.london.testdouble.SpyStore
import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatThrownBy
import org.assertj.core.api.Assertions.catchThrowable
import org.junit.jupiter.api.Test

private class OrderTest {

    @Test
    fun order_succeeds_then_decreases_the_store_stock() {
        val givenProduct = Product.I_PAD
        val givenAmountOfOrder = (0..10L).random()
        val givenSpyStore = SpyStore()
        val order = OrderImpl(givenSpyStore, givenProduct, givenAmountOfOrder)

        order.order()

        assertThat(givenSpyStore.decreaseStockArgumentsProduct).isEqualTo(givenProduct)
        assertThat(givenSpyStore.decreaseStockArgumentsStock).isEqualTo(givenAmountOfOrder)
    }

    @Test
    fun order_fails_when_store_decreaseStock_throws_IllegalArgumentException() {
        val givenProduct = Product.I_PAD
        val givenAmountOfOrder = (10..20L).random()
        val givenStore = SpyStore()
        givenStore.decreaseStockThrows = IllegalArgumentException()
        val order = OrderImpl(givenStore, givenProduct, givenAmountOfOrder)

        assertThatThrownBy { order.order() }
            .isInstanceOf(IllegalArgumentException::class.java)
    }

}
