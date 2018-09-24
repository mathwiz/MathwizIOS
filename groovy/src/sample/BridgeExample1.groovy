package sample

import pattern.structural.ArrayStack
import pattern.structural.ListStack
import pattern.structural.PeekableStack

class BridgeExample1 {
    def doIt() {
        doWith(new PeekableStack(impl: new ArrayStack()))
        doWith(new PeekableStack(impl: new ListStack()))
    }

    def doWith(stack) {
        stack.push(1)
        stack.push(2)
        stack.push(3)

        println "First with peek: ${stack.peek()}"
        println "First: ${stack.pop()}"
        println "Second: ${stack.pop()}"
        println "Third: ${stack.pop()}"
    }
}
