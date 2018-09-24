package sample

import sun.reflect.generics.reflectiveObjects.NotImplementedException

class AdapterExample {
    String one = "Four score and seven"
    String two = " years ago"

    def adapter1, adapter2

    def doIt() {
        throw new NotImplementedException("Subclass responsibility")
    }
}
