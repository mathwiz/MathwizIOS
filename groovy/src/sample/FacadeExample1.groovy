package sample

import pattern.structural.DatabaseBroker
import pattern.structural.Player

class FacadeExample1 {
    def doIt() {
        println("Facade")
        def player = null
        DatabaseBroker.getInstance()
                .save(new Player(name: "Tom Brady", pos: "qb", points: 127, salary: 3_000_000, isPersistent: false))
    }

}