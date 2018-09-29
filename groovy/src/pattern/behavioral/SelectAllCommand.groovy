package pattern.behavioral

class SelectAllCommand extends Command {
    def handleExecute() {
        receiver .selectAll()
    }
}
