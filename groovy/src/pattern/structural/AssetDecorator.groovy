package pattern.structural

class AssetDecorator extends Asset {
    def asset

    def description() { asset .description() }

    String toString() {
        println("toString in AssetDecorator " + asset .getClass())
        asset .toString()
    }
}
