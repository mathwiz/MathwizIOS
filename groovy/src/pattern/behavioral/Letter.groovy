package pattern.behavioral

class Letter {
    def event, block

    def createMemento() {
        new Letter(event: event, block: block)
    }

    def restoreFrom(aMemento) {
        event = aMemento .event
        block = aMemento .block
    }
}
