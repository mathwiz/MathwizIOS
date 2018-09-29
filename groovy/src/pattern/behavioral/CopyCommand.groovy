package pattern.behavioral

class CopyCommand extends Command {
    def handleExecute() {
        receiver .copy()
    }
}
