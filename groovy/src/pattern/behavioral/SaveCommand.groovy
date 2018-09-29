package pattern.behavioral

class SaveCommand extends Command {
    def handleExecute() {
        receiver .save()
    }
}
