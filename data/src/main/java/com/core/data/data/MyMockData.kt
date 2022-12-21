package com.core.data.data

import com.core.domain.entities.Product
import com.core.domain.entities.category.Category

class MyMockData {

    val cateList : ArrayList<Category> = ArrayList()

    val productList = arrayListOf(
        Product(1, 1, name = "Chicken burger", price = 12.2, qty = 1),
        Product(2, 1, name = "beef Burger", price = 15.2, qty = 1),
        Product(3, 2, name = "Ranch Pizza", price = 16.56, qty = 1),
        Product(4, 2, name = "BBQ Pizza", price = 11.11, qty = 1),
        Product(5, 3, name = "Mocha", price = 15.21, qty = 1),
        Product(6, 3, name = "Americano", price = 1.2, qty = 1),
        Product(7, 4, name = "Ice Latte", price = 12.1, qty = 1),
        Product(8, 4, name = "Ice Coffee", price = 12.00, qty = 1),
        Product(9, 5, name = "Molten cake", price = 1.12, qty = 1),
        Product(10, 5, name = "Cheese cake", price = 15.15, qty = 1),
        Product(11, 5, name = "Cheese cake2", price = 11.11, qty = 1),
    )
}