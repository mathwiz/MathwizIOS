package pattern.structural

class ImageProxy extends VisualComponent {
    def subject

    def draw(graphicsContext) {
        if (subject == null) {
            subject = loadImage()
        }
        subject .draw(graphicsContext)
    }

    def loadImage() {
        println("Going to a store to get the image.")
        Thread.sleep(2000)
        new Image()
    }
}
