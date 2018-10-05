package pattern.behavioral

class Magnitude {
    def val

    def gt(other) {
        this.val > other.val
    }

    def gteq(other) {
        this .equals(other) || this .gt(other)
    }

    def lt(other) {
        !(this .gteq(other))
    }

    def lteq(other) {
        !(this .gt(other))
    }

    boolean equals(other) {
        this.val == other.val
    }

    String toString() {
        val ?.toString()
    }
}
