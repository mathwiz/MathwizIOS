package pattern.structural

class DrawableAsset extends AssetDecorator {
    def draw() {
        println("Drawing in Drawable " + asset .getClass())
        println(asset .toString())
    }
}
