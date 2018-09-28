package pattern.structural

class Image extends VisualComponent {
    def draw(graphicsContext) {
        println("Drawing a big object")
        Thread.sleep(3000)
        println("Whew! Done drawing.")
    }
}
