package sample

import pattern.behavioral.BarChartGrapher
import pattern.behavioral.GraphVisualizer
import pattern.behavioral.LineChartGrapher
import pattern.behavioral.PieChartGrapher

class StrategyExample1 {
    def doIt() {
        println("Strategy")
        def bar = new BarChartGrapher()
        def line = new LineChartGrapher()
        def pie = new PieChartGrapher()

        def visualizer = new GraphVisualizer()
        visualizer .data = [Mayfield: 295, Brees: 408, Rodgers: 350, Brady: 374, Newton: 233]

        println("Simulate changing strategy to Bar")
        visualizer .grapher = bar
        visualizer .graphIt()
        println()
        println("Simulate changing strategy to Line")
        visualizer .grapher = line
        visualizer .graphIt()
        println()
        println("Simulate changing strategy to Pie")
        visualizer .grapher = pie
        visualizer .graphIt()
        println()
    }
}
