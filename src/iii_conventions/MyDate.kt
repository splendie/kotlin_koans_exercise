package iii_conventions

data class MyDate(val year: Int, val month: Int, val dayOfMonth: Int) : Comparable<MyDate> {
    override fun compareTo(other: MyDate): Int {
        if (this.year < other.year)
            return -1
        else if (this.year > other.year)
            return 1
        else {
            if (this.month < other.month)
                return -1
            else if (this.month > other.month)
                return 1
            else {
                if (this.dayOfMonth < other.dayOfMonth)
                    return -1
                else if (this.dayOfMonth > other.dayOfMonth)
                    return 1
                else
                    return 0
            }
        }

    }
}

operator fun MyDate.rangeTo(other: MyDate): DateRange = DateRange(this, other)

operator fun MyDate.plus(timeInterval: TimeInterval) : MyDate {
    var result: MyDate
    when (timeInterval) {
        TimeInterval.DAY -> result = this.addTimeIntervals(iii_conventions.TimeInterval.DAY, 1)
        TimeInterval.WEEK -> result = this.addTimeIntervals(iii_conventions.TimeInterval.WEEK, 1)
        TimeInterval.YEAR -> result = this.addTimeIntervals(iii_conventions.TimeInterval.YEAR, 1)
    }
    return result
}

operator fun MyDate.plus(rti: RepeatedTimeInterval): MyDate {
    var result: MyDate
    when (rti.ti) {
        TimeInterval.DAY -> result = this.addTimeIntervals(iii_conventions.TimeInterval.DAY, rti.n)
        TimeInterval.WEEK -> result = this.addTimeIntervals(iii_conventions.TimeInterval.WEEK, rti.n)
        TimeInterval.YEAR -> result = this.addTimeIntervals(iii_conventions.TimeInterval.YEAR, rti.n)
    }
    return result
}

operator fun DateRange.iterator(): DateRangeIterator = object : DateRangeIterator() {
    private var current: MyDate = start

    override fun nextDate(): MyDate {
        if (!hasNext())
            throw NoSuchElementException()

        val result = current
        current = current.nextDay()
        return result
    }

    override fun hasNext(): Boolean = current <= endInclusive
}

abstract class DateRangeIterator : Iterator<MyDate> {
    override final fun next() = nextDate()

    /** Returns the next value in the sequence without boxing. */
    abstract fun nextDate(): MyDate
}

enum class TimeInterval {
    DAY,
    WEEK,
    YEAR
}

class DateRange(override val start: MyDate, override val endInclusive: MyDate) : ClosedRange<MyDate>


