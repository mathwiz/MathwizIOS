package sample

import pattern.behavioral.ReadStream
import pattern.behavioral.Totaler

class IteratorExample1 {
    def players = [
            new Player(name: "Giannis", ppg: 30.7),
            new Player(name: "Gordon", ppg: 21.2),
            new Player(name: "Al", ppg: 18.8),
            new Player(name: "Kemba", ppg: 27.1),
            new Player(name: "Kevin", ppg: 24.5),
    ]

    def internalStrategy = {elems -> elems .inject(0) {tot, it -> tot + it .ppg}}

    def externalStrategy = {elems ->
        def stream = new ReadStream(elems: players)
        def tot = 0
        while (! stream .atEnd()) {
            tot += stream .next() .ppg
        }
        tot
    }

    def doIt() {
        println("Iterator")
        println("Totaling with internal iterator")
        println(new Totaler(strategy: internalStrategy).calculateTotal(players))
        println("Totaling with external iterator")
        println(new Totaler(strategy: externalStrategy).calculateTotal(players))
    }
}

class Player {
    def name, ppg
}
