package sample

import pattern.creational.Singleton
import pattern.structural.MessageAdapter
import pattern.structural.ParameterizedAdapter
import pattern.structural.StringTailoredAdapter

class Patterns {
    def static doSingleton() {
        def one = Singleton.getInstance()
        def two = Singleton.getInstance()

        println "Count: ${one.instanceCount}"
        println "Count: ${two.instanceCount}"
    }

    def static doTailoredAdapter() {
        def one = "Four score and seven"
        def two = " years ago"

        def adapter1 = new StringTailoredAdapter(string: one)
        def adapter2 = new StringTailoredAdapter(string: two)

        println "Substring(2,8) of '${one}': ${adapter1.sub(2, 8)}"
        println "Substring(2,8) of '${two}': ${adapter2.sub(2, 8)}"
    }

    def static doMessageAdapter() {
        def one = "Four score and seven"
        def two = " years ago"

        def adapter1 = MessageAdapter.on(one)
        adapter1.setGetter("length")
        def adapter2 = MessageAdapter.on(two)
        adapter2.setGetter("length")

        println "length of '${one}': ${adapter1.value}"
        println "length of '${two}': ${adapter2.value}"
    }

    def static doParameterizedAdapter() {
        def one = "Four score and seven"
        def two = " years ago"
        def substringBlock = { it.substring(2, 8) }

        def adapter1 = ParameterizedAdapter.on(one)
        adapter1 .setGetBlock(substringBlock)
        def adapter2 = ParameterizedAdapter.on(two)
        adapter2 .setGetBlock(substringBlock)

        println "Substring(2,8) of '${one}': ${adapter1.value}"
        println "Substring(2,8) of '${two}': ${adapter2.value}"
    }

    def static main(String... args) {
        switch (args[0]) {
            case "singleton":
                doSingleton()
                break
            case "adapter":
                doTailoredAdapter()
                doMessageAdapter()
                doParameterizedAdapter()
                break
            default:
                println "no pattern: ${args[0]}"
        }
    }
}
