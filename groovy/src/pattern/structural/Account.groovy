package pattern.structural

class Account extends CompositeAsset {
    String description() {
        "Account: " + super.description()
    }

    def acceptVisitor(visitor) {
        visitor .visitAccount(this)
    }
}
