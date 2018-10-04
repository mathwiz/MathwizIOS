package pattern.behavioral

class TCPClosedState extends TCPState {
    def activeOpen(aTCPConnection) {
        super.activeOpen(aTCPConnection)
        nextState(TCPEstablishedState)
    }

    def passiveOpen(aTCPConnection) {
        super.passiveOpen(aTCPConnection)
        nextState(TCPListenState)
    }

    def close(aTCPConnection) {
        println("close not valid in state ${this}")
    }

    def sendThrough(aTCPConnection) {
        println("sendThrough not valid in state ${this}")
    }

    def transmitThrough(aTCPConnection) {
        println("transmitThrough not valid in state ${this}")
    }
}
