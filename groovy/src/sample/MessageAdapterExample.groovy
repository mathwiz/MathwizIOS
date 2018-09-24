package sample

import pattern.structural.MessageAdapter

class MessageAdapterExample extends AdapterExample {
    def doIt() {
        adapter1 = MessageAdapter.on(one)
        adapter1.setGetter("length")
        adapter2 = MessageAdapter.on(two)
        adapter2.setGetter("length")

        println "length of '${one}': ${adapter1.value}"
        println "length of '${two}': ${adapter2.value}"
    }
}
