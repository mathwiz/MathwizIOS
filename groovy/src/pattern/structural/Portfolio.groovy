package pattern.structural

class Portfolio extends CompositeAsset {
    String description() {
        "Portfolio: ${this.name}"
    }

    def acceptVisitor(visitor) {
        visitor .visitPortfolio(this)
    }
}
