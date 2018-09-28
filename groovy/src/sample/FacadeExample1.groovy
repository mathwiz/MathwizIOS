package sample

import pattern.structural.DatabaseBroker
import pattern.structural.PlayerFactory

class FacadeExample1 {
    def doIt() {
        println("Facade")
        def player = PlayerFactory .getInstance() .fromMap(name: "Tom Brady", pos: "qb", points: 127, salary: 3_000_000)
        DatabaseBroker .getInstance() .save(player)
    }

}