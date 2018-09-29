package pattern.behavioral

class UndoCommand extends Command {
    def execute() {
        handleExecute()
    }

    def handleExecute() {
        application .undo()
    }
}
