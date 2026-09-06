package com.zippy.zippy.viewmodel

import androidx.compose.runtime.mutableStateListOf
import com.zippy.zippy.model.Order

object OrderRepository {

    val orders = mutableStateListOf<Order>()

    fun addOrder(order: Order) {
        orders.add(order)
    }

    fun getOrders(): List<Order> {
        return orders
    }

    fun clearOrders() {
        orders.clear()
    }

}