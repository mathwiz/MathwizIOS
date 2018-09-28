package sample

import pattern.creational.Singleton

class SingletonExample1 {
    def one = Singleton.getInstance()
    def two = Singleton.getInstance()

    def doIt() {
        printll("Singleton")
        println "Count: ${one.instanceCount}"
        println "Count: ${two.instanceCount}"
    }
}
