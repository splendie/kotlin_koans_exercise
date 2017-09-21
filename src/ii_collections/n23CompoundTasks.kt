package ii_collections

fun Shop.getCustomersWhoOrderedProduct(product: Product): Set<Customer> {
    // Return the set of customers who ordered the specified product

    return customers.filter { customer -> customer.orderedProducts.contains(product) }.toSet()
}

fun Customer.getMostExpensiveDeliveredProduct(): Product? {
    // Return the most expensive product among all delivered products
    // (use the Order.isDelivered flag)
    return orders.filter {
        order ->
        order.isDelivered
    }.flatMap { order -> order.products }
            .maxBy { product -> product.price }
}

fun Shop.getNumberOfTimesProductWasOrdered(p: Product): Int {
    // Return the number of times the given product was ordered.
    // Note: a customer may order the same product for several times.
    return this.customers.flatMap { customer -> customer.orders }
            .flatMap { order -> order.products }
            .filter { product -> product.equals(p) }
            .size
}
