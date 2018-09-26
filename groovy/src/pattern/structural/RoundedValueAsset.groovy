package pattern.structural

class RoundedValueAsset extends AssetDecorator {
    def value() {
        Math.round(asset .value())
    }
}
