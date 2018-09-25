package pattern.structural

class DrawableAsset extends AssetDecorator {
    def draw() {
        println(asset)
    }
}
