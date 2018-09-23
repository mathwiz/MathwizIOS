package sample

import pattern.creational.Singleton

class Patterns {
    def static doSingleton() {
        def one = Singleton.getInstance()
        def two = Singleton.getInstance()

        println "Count: ${one.instanceCount}"
        println "Count: ${two.instanceCount}"
    }

    def static main(String... args) {
        switch (args[0]) {
            case "singleton":
                doSingleton()
                break
            case "adapter":
                println "todo"
                break
            default:
                println "no pattern ${args[0]}"
        }
    }
}
