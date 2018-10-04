package pattern.behavioral

class TCPEstablishedState extends TCPState {
    def activeOpen(aTCPConnection) {
        println("activeOpen not valid in state ${this}")
    }

    def passiveOpen(aTCPConnection) {
        println("passiveOpen not valid in state ${this}")
    }

    def close(aTCPConnection) {
        super.close(aTCPConnection)
        nextState(TCPListenState)
    }

    def sendThrough(aTCPConnection) {
        println("sendThrough not valid in state ${this}")
    }

    def transmitThrough(aTCPConnection) {
        super.transmitThrough(aTCPConnection)
        //stay in current state
    }
}
