package pattern.structural

class AssetDecorator extends Asset {
    def asset

    def draw() {
        println(asset .draw())
    }
}
