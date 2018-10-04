package pattern.behavioral

class Totaler {
    def strategy

    def calculateTotal(elems) {
        strategy(elems)
    }
}
