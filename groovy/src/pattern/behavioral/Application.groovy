package pattern.behavioral

class Application {
    def mainMenu, document, shouldQuit
    private List<Command> historyList = []

    Application() {
        init()
    }

    def init() {
        document = new Document(text: "When in the course of human events...")

        mainMenu = new Menu(container: this)

        mainMenu .add(new MenuItem(name: "Open", command: new OpenCommand(receiver: document, application: this)))
        mainMenu .add(new MenuItem(name: "Save", command: new SaveCommand(receiver: document, application: this)))
        mainMenu .add(new MenuItem(name: "Cut", command: new CutCommand(receiver: document, application: this)))
        mainMenu .add(new MenuItem(name: "Copy", command: new CopyCommand(receiver: document, application: this)))
        mainMenu .add(new MenuItem(name: "Paste", command: new PasteCommand(receiver: document, application: this)))
        mainMenu .add(new MenuItem(name: "SelectAll", command: new SelectAllCommand(receiver: document, application: this)))
        mainMenu .add(new MenuItem(name: "Quit", command: new QuitCommand(receiver: this, application: this)))
    }

    def run() {
        mainMenu .show()
        def exp
        while (exp = System.console().readLine()) {
            mainMenu .select(exp)
            if (shouldQuit) {
                break
            }
            mainMenu .show()
        }
    }

    def saveForUndo(command) {
        historyList .add(command)
    }

    def quit() {
        shouldQuit = true
    }
}
