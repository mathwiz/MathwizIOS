package pattern.behavioral

class GraphVisualizer {
    def grapher, data, dimensions

    def graphIt() {
        grapher .plotFor(this)
    }

    def verticalSize() {
        dimensions.vertical ?: 20
    }

    def horizontalSize() {
        dimensions.horizontal ?: 40
    }
}
