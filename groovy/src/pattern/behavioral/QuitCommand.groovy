package pattern.behavioral

class QuitCommand extends Command {
    def handleExecute() {
        println("Quitting...")
        application .quit()
    }
}
