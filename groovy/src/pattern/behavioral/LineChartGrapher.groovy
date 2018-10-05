package pattern.behavioral

class LineChartGrapher extends Grapher {
    LineChartGrapher() {
        penSequence = ["-"]
    }

    def plotFor(visualizer) {
        println("Line Chart")
        this .width = visualizer .horizontalSize()
        chartLines(visualizer .data) .each { println(it) }
    }
}
