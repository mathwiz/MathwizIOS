package pattern.behavioral

class TCPListenState extends TCPState {
    def activeOpen(aTCPConnection) {
        println("activeOpen not valid in state ${this}")
    }

    def passiveOpen(aTCPConnection) {
        println("passiveOpen not valid in state ${this}")
    }

    def close(aTCPConnection) {
        println("close not valid in state ${this}")
    }

    def sendThrough(aTCPConnection) {
        super.sendThrough(aTCPConnection)
        nextState(TCPEstablishedState)
    }

    def transmitThrough(aTCPConnection) {
        println("transmitThrough not valid in state ${this}")
    }
}
