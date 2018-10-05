package pattern.structural

class Bond extends Security {
    def maturity, type

    def description() {
        "${type} ${super.description()}"
    }

    def acceptVisitor(visitor) {
        visitor .visitBond(this)
    }
}
