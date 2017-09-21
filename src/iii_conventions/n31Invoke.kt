package iii_conventions

import util.TODO


class Invokable {
    var numberOfInvocations: Int = 0
    operator fun invoke(): Invokable {
        numberOfInvocations++
        return this
    }
}


fun task31(invokable: Invokable): Int {
    return invokable()()()().numberOfInvocations
}

fun Invokable.getNumberOfInvocations(): Int = numberOfInvocations