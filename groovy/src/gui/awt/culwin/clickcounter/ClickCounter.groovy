package gui.awt.culwin.clickcounter

class ClickCounter {
    final static DEFAULT_MINIMUM = 0
    final static DEFAULT_MAXIMUM = 999

    def minimumCount, maximumCount, clicksCounted

    ClickCounter(min , max) {
        minimumCount = min
        maximumCount = max
    }

    ClickCounter(max) {
        this(DEFAULT_MINIMUM, max)
    }

    ClickCounter() {
        this(DEFAULT_MINIMUM, DEFAULT_MAXIMUM)
    }

    def count() {
        ++clicksCounted
    }

    def unCount() {
        --clicksCounted
    }

    def reset() {
        clicksCounted = min
    }

    def isAtMinimum() {
        clicksCounted == minimumCount
    }

    def isAtMaximum() {
        clicksCounted == maximumCount
    }

    def countIs() {
        clicksCounted
    }

    def countIsAsString() {
        clicksCounted.toString()
    }
}
