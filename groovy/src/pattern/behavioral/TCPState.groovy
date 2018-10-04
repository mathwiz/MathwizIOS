package pattern.behavioral

abstract class TCPState {
    def context

    def activeOpen(aTCPConnection) {
        println("- Doing activeOpen in ${this}")
    }

    def passiveOpen(aTCPConnection) {
        println("- Doing passiveOpen in ${this}")
    }

    def close(aTCPConnection) {
        println("- Doing close in ${this}")
    }

    def sendThrough(aTCPConnection) {
        println("- Doing sendThrough in ${this}")
    }

    def transmitThrough(aTCPConnection) {
        println("- Doing transmitThrough in ${this}")
    }

    def nextState(stateClass) {
        def next = stateClass .newInstance()
        next .context = context
        context .state = next
    }

    String toString() {
        this .getClass() .toString() .drop(6) .split("\\.") .last()
    }
}
