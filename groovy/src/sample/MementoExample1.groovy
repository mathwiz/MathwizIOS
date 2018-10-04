package sample

import pattern.behavioral.Letter

class MementoExample1 {
    def originator, memento

    def doIt() {
        println("Memento")
        originator = new Letter(event: "clicked", block: { details -> println("Clicked on ${details .name}")})
        memento = originator .createMemento()
        originator .block = { details -> println("Updated the handler. ${details .name} was clicked.")}
        originator .block([name: "Originator Button"])
        memento .block([name: "Memento Button"])
        undo()
        originator .block([name: "Originator Button"])
        memento .block([name: "Memento Button"])
    }

    def undo() {
        originator .restoreFrom(memento)
    }
}
