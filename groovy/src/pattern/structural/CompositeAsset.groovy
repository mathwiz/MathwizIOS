package pattern.structural

class CompositeAsset extends Asset {
    def assets = []

    def add(anAsset) {
        assets .add(anAsset)
        anAsset .container = this
        this
    }

    def remove(anAsset) {
        anAsset .container = null
        assets .remove(anAsset)
        this
    }

    def value() {
        assets .inject(0.0) { sum, it -> sum + it.value() }
    }

    def containsSecurity(aSecurity) {
        assets .any() { it .containsSecurity(aSecurity) }
    }

    String toString() {
        assets .inject("${this.description()} \$${this.value()}: ")
                { str, it -> str + "\n${it.padding()}|\n${it.padding()}+----" + it.toString() }
    }
}
