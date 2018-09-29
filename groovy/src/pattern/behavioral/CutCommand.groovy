package pattern.behavioral

class CutCommand extends Command {
    def handleExecute() {
        receiver .cut()
    }
}
