package pattern.behavioral

class PieChartGrapher extends Grapher {
    PieChartGrapher() {
        penSequence = new ArrayList(defaultPens)
    }

    def plotFor(visualizer) {
        println("PIe Chart")
        this .width = visualizer .horizontalSize()
        chartLines(visualizer .data) .each { println(it) }
    }
}
