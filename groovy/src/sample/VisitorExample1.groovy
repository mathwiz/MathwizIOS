package sample

import pattern.behavioral.FeeCalculationVisitor
import pattern.behavioral.OnlineFormatVisitor

class VisitorExample1 extends CompositeExample1 {
    def doIt() {
        println("Visitor")
        def securities = [apple, amazon, treasury, sp500]

        println()
        def formats = securities .collect { it .acceptVisitor(new OnlineFormatVisitor()) }
        println("\nResults of OnlineFormatVisitor")
        formats .each { println(it) }

        println()
        def fees = securities .collect { it .acceptVisitor(new FeeCalculationVisitor()) }
        println("\nResults of FeeCalculationVisitor")
        fees .each { println(it) }
    }

}
