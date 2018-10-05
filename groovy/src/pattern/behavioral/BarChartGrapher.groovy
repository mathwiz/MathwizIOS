package pattern.behavioral

class BarChartGrapher extends Grapher {
    BarChartGrapher() {
        penSequence = ["*"]
    }

    def plotFor(visualizer) {
        println("Bar Chart")
    }
}
