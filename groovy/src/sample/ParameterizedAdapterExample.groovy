package sample

import pattern.structural.ParameterizedAdapter

class ParameterizedAdapterExample extends AdapterExample {
    def doIt() {
        def substringBlock = { it.substring(2, 8) }

        adapter1 = ParameterizedAdapter.on(one)
        adapter1 .setGetBlock(substringBlock)
        adapter2 = ParameterizedAdapter.on(two)
        adapter2 .setGetBlock(substringBlock)

        println "Substring(2,8) of '${one}': ${adapter1.value}"
        println "Substring(2,8) of '${two}': ${adapter2.value}"
    }
}
