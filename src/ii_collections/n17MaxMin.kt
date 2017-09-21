package ii_collections

fun example4() {
    val max = listOf(1, 42, 4).max()
    val longestString = listOf("a", "b").maxBy { it.length }
}

fun Shop.getCustomerWithMaximumNumberOfOrders(): Customer? {
    // Return a customer whose order numberOfInvocations is the highest among all customers
    return customers.maxBy { it.orders.size }
//    get list of customers
//    for each customer
//        get numberOfInvocations list of orders
//        if numberOfInvocations max return customer

}

fun Customer.getMostExpensiveOrderedProduct(): Product? {
    // Return the most expensive product which has been ordered
    return orderedProducts.maxBy { product ->  product.price}
}
