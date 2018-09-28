package sample

import pattern.structural.DatabaseBroker
import pattern.structural.Player

class FacadeExample1 extends CompositeExample1 {
    def doIt() {
        println("Facade")
        new DatabaseBroker()
                .save(new Player(name: "Tom Brady", pos: "qb", points: 127, salary: 3_000_000, isPersistent: false))
    }

}