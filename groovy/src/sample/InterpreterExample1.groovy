package sample

import pattern.behavioral.AttributeNode
import pattern.structural.Bond

class InterpreterExample1 {
    def doIt() {
        println("Interpreter")
        def result = new AttributeNode(attributeName: "id") .evaluateAgainst(new Bond(name: "30 Treasury", id: "CUSIP0030"))
        println(result)
    }
}
