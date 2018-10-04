package pattern.behavioral

class ReadStream {
    private elems
    private int current = 0

    def atEnd() {
        current == elems .size()
    }

    def next() {
        elems[current++]
    }

    def reset() {
        current = 0
    }
}
