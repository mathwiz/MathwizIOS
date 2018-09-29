package pattern.behavioral

class PasteCommand extends Command {
    def handleExecute() {
        receiver .paste()
    }

    def unexecute() {
        println("Undoing Paste")
        receiver .cut()
    }
}
