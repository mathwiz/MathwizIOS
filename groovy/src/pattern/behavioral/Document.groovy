package pattern.behavioral

class Document {
    def selectionStart, selctionEnd, text

    def open() {
        println("Opening document")
    }

    def save() {
        println("Saving document")
    }

    def cut() {
        println("Cutting text")
    }

    def copy() {
        println("Copying text")
    }

    def paste() {
        println("Pasting text")
    }

    def selectAll() {
        println("Selecting all text")
    }
}
