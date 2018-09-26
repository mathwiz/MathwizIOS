package pattern.structural

class RoundedValueAsset extends AssetDecorator {
    def value() {
        Math.round(asset .value())
    }

    String toString() {
        println("toString in RoundedValueAsset " + asset .getClass())
        asset .toString()
    }
}
