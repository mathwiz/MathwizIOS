package pattern.structural

class Security extends Asset {
    def quantity, price

    def value() {
        price * quantity
    }

    def containsSecurity(aSecurity) {
        aSecurity == this
    }

    String toString() {
        "${this.description()} \$${this.value()}"
    }
}
