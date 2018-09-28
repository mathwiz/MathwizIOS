package sample

import pattern.structural.StringTailoredAdapter

class TailoredAdapterExample extends AdapterExample {
    def doIt() {
        println("Adapter")
        adapter1 = new StringTailoredAdapter(string: one)
        adapter2 = new StringTailoredAdapter(string: two)

        println "Substring(2,8) of '${one}': ${adapter1.sub(2, 8)}"
        println "Substring(2,8) of '${two}': ${adapter2.sub(2, 8)}"
    }
}
