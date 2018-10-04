package sample

import pattern.behavioral.TCPConnection

class StateExample1 {
    def doIt() {
        println("State")
        def conn = new TCPConnection()
        conn .send()
        conn .transmit()
        conn .passiveOpen()
        conn .send()
        conn .passiveOpen()
        conn .transmit()
        conn .activeOpen()
        conn .close()
        conn .close()
        println("Final state is ${conn .state}")
        conn = new TCPConnection()
        conn .activeOpen()
        conn .send()
        conn .transmit()
        conn .close()
        conn .close()
        conn .close()
        println("Final state is ${conn .state}")
    }
}
