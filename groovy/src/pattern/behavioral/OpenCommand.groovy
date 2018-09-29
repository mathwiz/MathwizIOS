package pattern.behavioral

class OpenCommand extends Command {
    def handleExecute() {
        receiver .open()
        application.document = receiver
    }
}
