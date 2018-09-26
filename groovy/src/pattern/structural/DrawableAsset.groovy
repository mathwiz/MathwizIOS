package pattern.structural

class DrawableAsset extends AssetDecorator {
    def draw() {
        println("drawing in Drawable " + asset .getClass())
        println(asset)
    }
}
