package sample

import pattern.creational.PrototypicalPlayer

class PrototypeExample1 {
    def doIt() {
        def prototype = new PrototypicalPlayer()
        println prototype

        def veteran =  prototype .copy()
        veteran.years = 10
        veteran.pro_bowls = 1
        println veteran
    }
}
