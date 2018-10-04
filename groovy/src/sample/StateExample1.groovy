package sample

import pattern.behavioral.TCPConnection

class StateExample1 {
    def doIt() {
        println("State")
        def conn = new TCPConnection()
        conn .transmit()
        conn .send()
        conn .passiveOpen()
        conn .send()
        conn .transmit()
        conn .close()
        println("Final state is ${conn .state}")
        conn = new TCPConnection()
        conn .activeOpen()
        conn .transmit()
        conn .close()
        println("Final state is ${conn .state}")
    }
}
