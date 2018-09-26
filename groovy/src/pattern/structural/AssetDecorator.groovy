package pattern.structural

class AssetDecorator extends Asset {
    def asset

    def value() {
        asset .value()
    }

    def description() {
        asset .description()
    }

    def draw() {
        asset .draw()
    }

    String toString() {
        println("toString in AssetDecorator " + asset .getClass())
        asset .toString()
    }
}
