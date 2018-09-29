package pattern.behavioral

class CutCommand extends Command {
    def handleExecute() {
        receiver .cut()
    }

    def unexecute() {
        println("Undoing Cut")
        receiver .paste()
    }
}
