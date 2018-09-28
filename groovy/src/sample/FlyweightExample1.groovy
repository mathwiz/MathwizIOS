package sample

import pattern.structural.Player

class FlyweightExample1 {
    def doIt() {
        println("Flyweight")
        def player1 = new Player(name: "Tom Brady", pos: "qb", points: 127, salary: 3_000_000, isPersistent: false)
        def player2 = new Player(name: "Tom Brady", pos: "qb", points: 127, salary: 3_000_000, isPersistent: false)
    }
}
