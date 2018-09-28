package sample

import pattern.structural.DatabaseBroker
import pattern.structural.Player
import pattern.structural.PlayerFactory

class FlyweightExample1 {
    def doIt() {
        println("Flyweight")
        println("- Player is a Shareable where instances are shared. DB key determines identity.")
        println("- Access must be controlled through the PlayerFactory for Player to be a Shareable.")
        def player1 = PlayerFactory .getInstance() .fromMap(name: "Tom Brady", pos: "qb", points: 127, salary: 3_000_000)

        def player2 = PlayerFactory .getInstance() .get(player1)
        player2 .salary = 73_000_000
        player2 .points = 297

        println("Players are equal: " + (player1 == player2))

        DatabaseBroker .getInstance() .save(player2)
    }
}
