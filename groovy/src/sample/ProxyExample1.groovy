package sample

import pattern.structural.Image
import pattern.structural.ImageProxy

class ProxyExample1 {
    def doIt() {
        println("Proxy")
        def img = new ImageProxy()
        img .draw([x:100, y:200])
    }
}
