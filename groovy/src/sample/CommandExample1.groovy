package sample

import pattern.behavioral.Application

class CommandExample1 {
    def doIt() {
        println("Command")
        println("Starting app...")
        def app  = new Application()
        app .run()
    }
}
