package pattern.structural

class AssetDecorator {
    def asset

    def value() {
        asset .value()
    }

    def containsSecurity(aSecurity) {
        asset .containsSecurity(aSecurity)
    }

    def description() {
        asset .description()
    }

    def draw() {
        asset .draw()
    }

    def depth() {
        asset .depth()
    }

    def padding() {
        asset .padding()
    }

    String toString() {
        println("toString in AssetDecorator " + asset .getClass())
        asset .toString()
    }
}
