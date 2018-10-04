package pattern.behavioral

class TCPConnection {
    def state

    TCPConnection() {
        state = new TCPClosedState(context: this)
        println("Created TCPConnection in state ${state}")
    }

    def activeOpen() {
        state .activeOpen(this)
    }

    def passiveOpen() {
        state .passiveOpen(this)
    }

    def close() {
        state .close(this)
    }

    def send() {
        state .sendThrough(this)
    }

    def transmit() {
        state .transmitThrough(this)
    }

}
