package pattern.structural

class AssetDecorator extends Asset {
    def asset

    def description() { asset .description() }

    String toString() { asset .toString() }
}
