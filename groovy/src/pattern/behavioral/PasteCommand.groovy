package pattern.behavioral

class PasteCommand extends Command {
    def handleExecute() {
        receiver .paste()
    }
}
