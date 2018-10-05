package pattern.behavioral

class BarChartGrapher extends Grapher {
    BarChartGrapher() {
        penSequence = ["*"]
    }

    def plotFor(visualizer) {
        println("Bar Chart")
        this .width = visualizer .horizontalSize()
        chartLines(visualizer .data) .each { println(it) }
    }
}
